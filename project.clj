(defproject blog.hashobject.com "0.1.0"
  :description "Hashobject team technical blog. Generated using Clojure. Hosted on Amazon S3."
  :url "http://blog.hashobject.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.4"]
                 [markdown-clj "0.9.41"]
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
            "site-build" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "build"]
            "site-deploy" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "deploy"]})
