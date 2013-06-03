(ns blog.hashobject.generator
  (:use clojure.java.io)
  (:require [markdown.core :as markdown]
            [blog.hashobject.views.index :as index-view]))

(def sources-dir (clojure.java.io/file "./resources/posts/"))

(def posts-files
    (for [file (file-seq sources-dir)] (.getName file)))

(defn get-files-to-process []
    (into [] (filter #(.endsWith % ".md") posts-files)))



(defn generate []
  (spit (str "./resources/public/index.html") (index-view/index)))


(get-files-to-process)
