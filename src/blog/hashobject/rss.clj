(ns blog.hashobject.rss
  {:boot/export-tasks true}
  (:require [boot.core        :as boot]
            [clojure.java.io  :as io]
            [blog.hashobject.dates :as dates]
            [clj-rss.core :as rss]))


(defn posts-rss-definitions [posts]
  (for [post posts]
    {:link (get post "canonical_url")
     :guid (get post "canonical_url")
     :pubDate (dates/str-to-date (get post "date_published"))
     :title (get post "name")
     :description (get post "description")
     :author (get post "author_email")}))


(defn generate-rss-str [posts]
  (let [items (posts-rss-definitions posts)
        rss-str (apply rss/channel-xml
          {:title "Hashobject team blog"
           ;:image "http://blog.hashobject.com/images/hashobject-logo.png"
           :link "http://blog.hashobject.com"
           :description "Hashobject - software engineering, design and application development"} items)]
    rss-str))


(defn write-rss-file [out-file content]
  (doto out-file
    io/make-parents
    (spit content)))

(boot/deftask generate-rss
  "Generate rss"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [edn-file (->> fileset boot/input-files (boot/by-name ["posts.edn"]) first)
              file-content (slurp (str (:dir edn-file) "/" (:path edn-file)))
              posts (read-string file-content)
              rss-file (io/file tmp "public/feed.rss")
              rss-string (generate-rss-str posts)]
          (println "all posts done>>" (count posts) rss-string)
          (write-rss-file rss-file rss-string)
          ;(spit rss-file rss-string)
          (println "step3 done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))
