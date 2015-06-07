(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.6.0"]
                 [hiccup "1.0.5"]
                 [perun "0.1.0-SNAPSHOT"]
                 [hashobject/boot-s3 "0.1.0-SNAPSHOT"]
                 [clj-time "0.9.0"]
                 [pandeiro/boot-http "0.6.2"]
                 [jeluard/boot-notify "0.1.2" :scope "test"]])


(require '[io.perun.markdown :refer :all])
(require '[io.perun.ttr :refer :all])
(require '[io.perun.draft :refer :all])
(require '[io.perun.permalink :refer :all])
(require '[io.perun.sitemap :refer :all])
(require '[io.perun.rss :refer :all])
(require '[io.perun.render :refer :all])
(require '[io.perun.collection :refer :all])
(require '[blog.hashobject.views.index :as index-view])
(require '[blog.hashobject.views.post :as post-view])

(require '[hashobject.boot-s3 :refer :all])
(require '[pandeiro.boot-http :refer :all])
(require '[jeluard.boot-notify :refer [notify]])

(task-options!
  pom {:project 'blog.hashobject.com
       :version "0.2.0"}
  s3-sync {
    :bucket "blog.hashobject.com"
    :source "resources/public/"
    :access-key (System/getenv "AWS_ACCESS_KEY")
    :secret-key (System/getenv "AWS_SECRET_KEY")
    :options {"Cache-Control" "max-age=315360000, no-transform, public"}})

(deftask build
  "Build blog."
  []
  (comp (markdown)
        (draft)
        (ttr)
        (permalink)
        (render :renderer post-view/render)
        (collection :renderer index-view/render :page "index.html" :comparator (fn [i1 i2] (compare i2 i1)))
        (sitemap :filename "sitemap.xml")
        (rss :title "Hashobject" :description "Hashobject blog" :link "http://blog.hashobject.com")
        (s3-sync)
        (notify)))