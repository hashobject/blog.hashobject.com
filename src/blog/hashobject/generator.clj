(ns blog.hashobject.generator
  (:use clojure.java.io)
  (:require [markdown.core :as markdown]
            [endophile.core :as markdown-parser]
            [sitemap.core :as sitemap]
            [clj-rss.core :as rss]
            [time-to-read.core :as ttr]
            [blog.hashobject.dates :as dates]
            [blog.hashobject.views.index :as index-view]
            [blog.hashobject.views.post :as post-view]))



(defn make-dir [path]
   (.mkdir (java.io.File. path)))

(def sources-dir (file "./resources/posts/"))

(def posts-files
    (for [file (file-seq sources-dir)] (.getName file)))

(defn get-files-to-process []
    (into [] (filter #(.endsWith % ".md") posts-files)))

(defn post-to-clj [file]
  (into []
        (markdown-parser/to-clj
          (markdown-parser/mp
            (slurp (str "./resources/posts/" file))))))

(defn trim-if-not-nil [s]
  (if (clojure.string/blank? s)
    s
    (clojure.string/trim s)))


(defn parse-post-defn [lines]
  (let [metadata {}]
        (into metadata
          (for [line lines]
            (let [tokens (clojure.string/split line #":" 2)
                  key-token (trim-if-not-nil (first tokens))
                  value-token (trim-if-not-nil (second tokens))]
                  (if (not (clojure.string/blank? key-token))
                    [key-token value-token]))))))

(defn generate-post-url [file]
  (let [length (count file)
        filename (subs file 9 (- length 3))]
        filename))

(defn generate-post-html [metadata]
  (do
    (make-dir (str "./resources/public/" (:filename metadata)))
    (spit
     (str "./resources/public/" (:filename metadata) "/index.html")
     (post-view/index metadata (:content metadata)))
      ["x" 1]))

(defn original-md-to-html-str [file]
  (markdown/md-to-html-string (slurp (str "./resources/posts/" file))))

(defn process-post [file]
  (let [post (post-to-clj file)
        data (:data (first post))
        lines (clojure.string/split data #"\n")
        filename (generate-post-url file)
        metadata (parse-post-defn lines)
        content (original-md-to-html-str file)
        time-to-read (ttr/estimate-for-text content)]
    (println "post md ds" filename)
    (assoc metadata :filename filename
                    :ttr time-to-read
                    :content content)))

(defn process-posts []
  (let [files (get-files-to-process)]
    (for [file files]
      (process-post file))))


(defn generate-posts []
  (let [posts (process-posts)]
    (dorun
      (for [post posts]
        (generate-post-html post)))))

(defn generate-index []
  (let [posts (reverse (process-posts))]
    (spit (str "./resources/public/index.html")
          (index-view/index posts))))

(defn posts-sitemap-definitions []
  (let [posts (process-posts)]
    (for [post posts]
      {:loc (str "http://blog.hashobject.com/" (:filename post))
       :lastmod (get post "date_modified")
       :changefreq "weekly"
       :priority 0.8})))


(defn posts-rss-definitions []
  (let [posts (process-posts)]
    (for [post posts]
      {:link (get post "canonical_url")
       :guid (get post "canonical_url")
       :pubDate (dates/str-to-date (get post "date_published"))
       :title (get post "name")
       :description (get post "description")
       :author (get post "author_email")})))







(defn generate-rss []
  (let [items (posts-rss-definitions)
        rss (apply rss/channel-xml {:title "Hashobject team blog"
                                    ;:image "http://blog.hashobject.com/images/hashobject-logo.png"
                                    :link "http://blog.hashobject.com"
                                    :description "Hashobject - software engineering, design and application development"} items)]
    (spit
       (str "./resources/public/feed.rss")
       rss)))


;(generate-rss)


(defn generate-sitemap []
  (let [posts-pages (posts-sitemap-definitions)
        all-pages (conj posts-pages
                        {:loc (str "http://blog.hashobject.com/")
                         :lastmod "2013-06-26"
                         :changefreq "daily"
                         :priority 1.0})]
        (sitemap/generate-sitemap-and-save "./resources/public/sitemap.xml" all-pages)))
