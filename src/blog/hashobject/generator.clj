(ns blog.hashobject.generator
  (:use clojure.java.io)
  (:require [markdown.core :as markdown]
            [endophile.core :as markdown-parser]
            [sitemap.core :as sitemap]
            [blog.hashobject.views.index :as index-view]
            [blog.hashobject.views.post :as post-view]))


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
            (let [tokens (clojure.string/split line #":")
                  key-token (trim-if-not-nil (first tokens))
                  value-token (trim-if-not-nil (second tokens))]
                  (if (not (clojure.string/blank? key-token))
                    [key-token value-token]))))))

(defn generate-post-url [file]
  (let [length (count file)
        filename (subs file 9 (- length 3))]
        filename))

(defn generate-post-html [metadata]
  (println "generate post html" (:filename metadata))
  (spit
   (str "./resources/public/" (:filename metadata) ".html")
   (post-view/index metadata (:content metadata))))

(defn original-md-to-html-str [file]
  (markdown/md-to-html-string (slurp (str "./resources/posts/" file))))

(defn process-post [file]
  (let [post (post-to-clj file)
        data (:data (first post))
        lines (clojure.string/split data #"\n")
        filename (generate-post-url file)
        metadata (parse-post-defn lines)
        content (original-md-to-html-str file)]
    (assoc metadata :filename filename
                    :content content)))


(defn process-posts []
  (let [files (get-files-to-process)]
    (for [file files]
      (process-post file))))


(defn generate-posts []
  (let [posts (process-posts)]
    (for [post posts]
       (generate-post-html post))))

(defn generate-index []
  (let [posts (process-posts)]
    (println "posts" posts)
    (spit (str "./resources/public/index.html")
          (index-view/index posts))))
