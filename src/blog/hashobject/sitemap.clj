(ns blog.hashobject.sitemap
  {:boot/export-tasks true}
  (:require [boot.core       :as boot]
            [clojure.java.io :as io]
            [sitemap.core    :as sitemap]))

(defn read-tmp-file [file]
  (slurp (str (:dir file) "/" (:path file))))

(defn posts-sitemap-definitions [posts]
  (map
    (fn [post]
      {:loc (str "http://blog.hashobject.com/" (:filename post))
       :lastmod (get post "date_modified")
       :changefreq "weekly"
       :priority 0.8}) posts))

(defn create-sitemap [posts]
  (let [posts-pages (posts-sitemap-definitions posts)
        all-pages (conj posts-pages
                        {:loc (str "http://blog.hashobject.com/")
                         :lastmod "2013-06-26"
                         :changefreq "daily"
                         :priority 1.0})]
        all-pages))

(defn write-sitemap-file [out-file content]
  (doto out-file
    io/make-parents
    (spit content)))

(boot/deftask generate-sitemap
  "Generate sitemap"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [edn-file (->> fileset boot/input-files (boot/by-name ["posts.edn"]) first)
              file-content (read-tmp-file edn-file)
              posts (read-string file-content)
              sitemap-file (io/file tmp "public/sitemap.xml")
              sitemap-xml (create-sitemap posts)
              sitemap-string (sitemap/generate-sitemap sitemap-xml)]
          (println "all posts done>>" (count posts) sitemap-string)

          (write-sitemap-file sitemap-file sitemap-string)
          (println "step2 done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))

