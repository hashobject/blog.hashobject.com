(ns blog.hashobject.markdown
  {:boot/export-tasks true}
  (:require [boot.core       :as boot]
            [clojure.java.io :as io]
            [markdown.core   :as markdown]
            [endophile.core  :as markdown-parser]))


(defn read-file [file]
  (slurp (str (:dir file) "/" (:path file))))

(defn post-to-clj [file]
  (into []
        (-> file
            read-file
            markdown-parser/mp
            markdown-parser/to-clj)))

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
  (let [filepath (:path file)
        filename (last (clojure.string/split filepath #"/"))
        length (count filename)
        short-name (subs filename 9 (- length 3))]
        short-name))


(defn original-md-to-html-str [file]
  (-> file
      read-file
      markdown/md-to-html-string))

(defn process-post [file]
  (let [post (post-to-clj file)
        data (:data (first post))
        lines (clojure.string/split data #"\n")
        filename (generate-post-url file)
        metadata (parse-post-defn lines)
        content (original-md-to-html-str file)]
    (assoc metadata :filename filename
                    :content content)))

(boot/deftask parse-markdown
  "Parse markdown files"
  []
  (let [tmp (boot/temp-dir!)]
    (fn middleware [next-handler]
      (fn handler [fileset]
        (let [markdown-files (->> fileset boot/user-files (boot/by-ext [".md"]))
              parsed-files (map process-post markdown-files)
              posts-file (io/file tmp "posts.edn")
              content (prn-str parsed-files)]
          (spit posts-file content)
          (println "step1 done>>")
          (-> fileset
              (boot/add-resource tmp)
              boot/commit!
              next-handler))))))
