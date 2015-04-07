(defproject blog.hashobject.com "0.1.0"
  :description "Hashobject team technical blog. Generated using Clojure. Hosted on Amazon S3."
  :url "http://blog.hashobject.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [hiccup "1.0.3"]
                 [markdown-clj "0.9.40"]
                 [endophile "0.1.2"]
                 [sitemap "0.2.1"]
                 [clj-time "0.6.0"]
                 [clj-rss "0.1.3"]
                 [time-to-read "0.1.0"]]
  :plugins [[lein-shell "0.1.0"]
            [lein-sitemap "0.1.0"]]
  :sitemaps ["http://blog.hashobject.com/sitemap.xml"]
  :aliases {"index-html" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-index"]
            "posts-html" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-posts"]
            "sitemap-xml" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-sitemap"]
            "rss" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-rss"]
            "site-deploy" ["shell" "gulp" "deploy"]})
