(ns blog.hashobject.generator
  (:use clojure.java.io)
  (:require [markdown.core :as markdown]
            [endophile.core :as markdown-parser]
            [blog.hashobject.views.index :as index-view]))

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

(defn parse-post-defn [lines]
  (let [metadata {}]
        (into metadata
          (for [line lines]
            (let [tokens (clojure.string/split line #":")
                  key-token (first tokens)
                  value-token (second tokens)]
                  [key-token value-token])))))

(defn process-posts []
  (let [files (get-files-to-process)]
    (for [file files]
      (let [post (post-to-clj file)
            data (:data (first post))
            lines (clojure.string/split data #"\n")
            metadata (parse-post-defn lines)]
            metadata
    ))))

(defn generate []
  (process-posts)
  (spit (str "./resources/public/index.html") (index-view/index)))



(process-posts)