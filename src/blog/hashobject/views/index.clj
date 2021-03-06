(ns blog.hashobject.views.index
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [blog.hashobject.dates :as dates]
          [blog.hashobject.views.common :as common]))

(defn render-post [post]
  [:li.item {:itemprop "blogPost" :itemscope "" :itemtype "http://schema.org/BlogPosting"}
   [:a.title {:href (str (:slug post)) :itemprop "name"} (:name post)]
   [:div.item-meta
    [:meta {:itemprop "author" :content (str (:author post) " (" (:author-email post) ")" )}]
    [:img.author-avatar {:src (:author-avatar post) :title (:author post)}]
    [:p.pub-data (str (dates/reformat-date (:date-published post) "MMM dd, YYYY") ", by " (:author post))
     [:span.reading-time (str " " (:ttr post) " mins read")]]
     [:p {:itemprop "description"} (:description post)]]])


(defn render [{metadata :meta posts :entries}]
  (html5 {:lang "en" :itemtype "http://schema.org/Blog"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "hashobject (team@hashobject.com)"}]
      [:meta {:name "keywords" :itemprop "keywords" :content "hashobject, blog, clojure, development, heroku, amazon route 53, aws"}]
      [:meta {:name "description" :itemprop "description" :content "Hashobject - software engineering, design and application development"}]
      [:title "Hashobject team blog about development and design"]
      [:link {:rel "shortcut icon" :href "/favicon.ico"}]
      [:link {:rel "publisher" :href "https://plus.google.com/118068495795214676039"}]
      [:link {:rel "author" :href "/humans.txt"}]
      [:link {:rel "alternate" :type "application/rss+xml" :title "RSS" :href "/feed.rss"}]
      (include-css "/css/app.css")
      (include-css "https://fonts.googleapis.com/css?family=PT+Sans")
     ]
    [:body
       (common/header)
       [:div.row.content
         [:ul.items.columns.small-12
          (for [post posts] (render-post post))]]
       (common/footer)]))
