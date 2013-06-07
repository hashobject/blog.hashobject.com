(defproject blog.hashobject.com "0.1.0"
  :description "HashObject team technical blog. Generated using Clojure. Hosted on Amazon S3."
  :url "http://blog.hashobject.com"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.3"]
                 [markdown-clj "0.9.26"]
                 [endophile "0.1.0"]
                 [sitemap "0.2.0"]
                 [clj-time "0.5.0"]]
  :plugins [[lein-shell "0.1.0"]]
  :aliases {"index-html" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-index"]
            "posts-html" ["trampoline" "run" "-m" "blog.hashobject.generator/generate-posts"]
            "site-build" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "build"]
            "site-deploy" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "deploy"]})
