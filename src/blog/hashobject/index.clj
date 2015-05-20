(ns blog.hashobject.index
  {:boot/export-tasks true}
  (:require [boot.core        :as boot]
            [clojure.java.io  :as io]
            [blog.hashobject.views.index :as index-view]))


(defn generate-index-html [posts]
  (post-view/index posts))


(defn write-inded-file [out-file content]
  (doto out-file
    io/make-parents
    (spit content)))

(boot/deftask generate-index
  "Generate index"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [edn-file (->> fileset boot/input-files (boot/by-name ["posts.edn"]) first)
              file-content (slurp (str (:dir edn-file) "/" (:path edn-file)))
              posts (read-string file-content)
              html (generate-index-html posts)
              index-file-path "public/index.html"
              index-file (io/file tmp index-file-path)]
          (write-index-file index-file html)
          (println "step5 done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))
