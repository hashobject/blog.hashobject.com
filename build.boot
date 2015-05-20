(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [markdown-clj "0.9.40"]
                 [endophile "0.1.2"]
                 [sitemap "0.2.4"]
                 [clj-time "0.9.0"]
                 [clj-rss "0.1.9"]
                 [time-to-read "0.1.0"]
                 [tonsky/boot-anybar "0.1.0" :scope "test"]
                 [jeluard/boot-notify "0.1.2" :scope "test"]])

(task-options!
  pom {:project 'blog.hashobject.com
       :version "0.2.0"})


(require '[blog.hashobject.markdown :refer :all])
(require '[blog.hashobject.ttr :refer :all])
(require '[blog.hashobject.sitemap :refer :all])
(require '[blog.hashobject.rss :refer :all])
(require '[blog.hashobject.posts :refer :all])
(require '[tonsky.boot-anybar :refer [anybar]])
(require '[jeluard.boot-notify :refer [notify]])

(deftask build
  "Build blog."
  []
  (comp (parse-markdown)
        (calc-ttr)
        (generate-sitemap)
        (generate-rss)
        (generate-posts)
        (notify)))