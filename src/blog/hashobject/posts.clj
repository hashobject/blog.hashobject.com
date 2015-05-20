(ns blog.hashobject.posts
  {:boot/export-tasks true}
  (:require [boot.core        :as boot]
            [clojure.java.io  :as io]
            [blog.hashobject.views.post :as post-view]))


(defn generate-post-html [metadata]
  (post-view/index metadata (:content metadata)))


(defn write-post-file [out-file content]
  (doto out-file
    io/make-parents
    (spit content)))

(boot/deftask generate-posts
  "Generate posts"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [edn-file (->> fileset boot/input-files (boot/by-name ["posts.edn"]) first)
              file-content (slurp (str (:dir edn-file) "/" (:path edn-file)))
              posts (read-string file-content)]
          (doall
            (map (fn [post]
              (let [html (generate-post-html post)
                    post-file-path (str "public/" (:filename post) "/index.html")
                    post-file (io/file tmp post-file-path)]
                (println "saving post to " post-file-path)
                (write-post-file post-file html))
              ) posts))
          (println "step4 done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))
