(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[hiccup "1.0.5"]
                  [perun "0.1.3-SNAPSHOT"]
                  [hashobject/boot-s3 "0.1.2-SNAPSHOT"]
                  [clj-time "0.9.0"]
                  [pandeiro/boot-http "0.6.3-SNAPSHOT"]
                  [org.martinklepsch/boot-gzip "0.1.1"]])

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
  (comp (global-metadata)
        (markdown)
        (draft)
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
        (sitemap :filename "sitemap.xml")
        (rss :title "Hashobject" :description "Hashobject blog" :link "http://blog.hashobject.com")
        (gzip :regex [#".html$" #".css$" #".js$"])
        (s3-sync)))

(deftask dev
  []
  (comp (watch)
        (build-dev)
        (serve :resource-root "public")))