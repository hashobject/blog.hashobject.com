(defproject blog.hashobject.com "0.1.0"
  :description "HashObject team technical blog. Generated using Clojure. Hosted on Amazon S3."
  :url "http://blog.hashobject.com"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.3"]]
  :plugins [[lein-shell "0.1.0"]]
  :aliases {"html" ["trampoline" "run" "-m" "blog.hashobject.generator/generate"]
            "site-build" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "build"]
            "site-deploy" ["shell" "./frontend/node_modules/grunt-cli/bin/grunt" "--gruntfile" "frontend/Gruntfile.js" "deploy"]})
