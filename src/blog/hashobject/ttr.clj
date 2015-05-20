(ns blog.hashobject.ttr
  {:boot/export-tasks true}
  (:require [boot.core        :as boot]
            [clojure.java.io  :as io]
            [time-to-read.core :as ttr]))


(boot/deftask calc-ttr
  "Calculate time to read"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [edn-file (->> fileset boot/input-files (boot/by-name ["posts.edn"]) first)
              file-content (slurp (str (:dir edn-file) "/" (:path edn-file)))
              posts (read-string file-content)
              updated-posts
                (map
                  (fn [post]
                    (let [time-to-read (ttr/estimate-for-text (:content post))]
                      (assoc post :ttr time-to-read)))
                  posts)
              posts-file (io/file tmp "posts.edn")
              content (prn-str updated-posts)]
          (spit posts-file content)
          (println "step ttr done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))
