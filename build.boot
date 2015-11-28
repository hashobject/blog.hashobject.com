(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[hiccup "1.0.5"]
                  [perun "0.2.1-SNAPSHOT"]
                  [hashobject/boot-s3 "0.1.2-SNAPSHOT"]
                  [clj-time "0.11.0"]
                  [pandeiro/boot-http "0.7.0"]
                  [org.martinklepsch/boot-gzip "0.1.2"]])

(require '[io.perun :refer :all]
         '[blog.hashobject.views.index :as index-view]
         '[blog.hashobject.views.post :as post-view]
         '[pandeiro.boot-http :refer [serve]]
         '[hashobject.boot-s3 :refer :all]
         '[org.martinklepsch.boot-gzip :refer [gzip]])

(task-options!
  pom {:project 'blog.hashobject.com
       :version "0.2.0"}
  s3-sync {
    :bucket "blog.hashobject.com"
    :access-key (System/getenv "AWS_ACCESS_KEY")
    :secret-key (System/getenv "AWS_SECRET_KEY")
    :source "public"
    :options {"Cache-Control" "max-age=315360000, no-transform, public"}})

(deftask build-dev
  "Build blog dev version"
  []
  (comp ;(base)
        (global-metadata)
        (markdown)
        (dump-meta)
        ;(draft)
        (ttr)
        (slug)
        (permalink)
        (canonical-url)
        (render :renderer 'blog.hashobject.views.post/render)
        (collection :renderer 'blog.hashobject.views.index/render :page "index.html")))

(deftask build
  "Build blog prod version."
  []
  (comp (build-dev)
        (inject-scripts :scripts #{"ga.js"})
        (sitemap :filename "sitemap.xml")
        (rss)
        (gzip :regex [#".html$" #".css$" #".js$"])
        (s3-sync)))

(deftask dev
  []
  (comp (watch)
        (build-dev)
        (serve :resource-root "public")))
