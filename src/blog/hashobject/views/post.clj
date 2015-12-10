(ns blog.hashobject.views.post
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [blog.hashobject.dates :as dates]
            [blog.hashobject.views.common :as common]))

(defn render [{metadata :meta posts :entries post :entry}]
  (html5 {:lang (:in_language metadata) :itemscope "" :itemtype "http://schema.org/BlogPosting"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content (str (:author post) " (" (:author-email post) ")" )}]
      [:meta {:name "keywords" :itemprop "keywords" :content (:keywords post)}]
      [:meta {:name "description" :itemprop "description" :content (:description post)}]
      [:meta {:itemprop "inLanguage" :content (:in-language post)}]
      [:meta {:itemprop "dateCreated" :content (:date-created post)}]
      [:meta {:itemprop "dateModified" :content (:date-modified post)}]
      [:meta {:itemprop "datePublished" :content (:date-published post)}]
      [:title {:itemprop "name"} (:name post)]
      [:link {:rel "shortcut icon" :href "/favicon.ico"}]
      [:link {:rel "publisher" :href "https://plus.google.com/118068495795214676039"}]
      [:link {:rel "author" :href "/humans.txt"}]
      [:link {:rel "alternate" :type "application/rss+xml" :title "RSS" :href "feed.rss"}]
      [:link {:rel "discussionUrl" :href (:discussion-url post)}]
      [:link {:rel "canonical" :href (:canonical-url post)}]
      (include-css "/css/app.css")
      (include-css "https://fonts.googleapis.com/css?family=PT+Sans")]
    [:body
       (common/header)
       [:div.row.content
         [:div.post.small-12.columns
           [:h1 {:itemprop "name"} (:name post)]
           (str (:content post))
           [:aside.post-meta.small-12.medium-12.columns
            [:img.author-avatar {:src (:author-avatar post) :title (:author post)}]
            [:div.meta-info
              [:div
                [:span.meta-label "Written by: "]
                [:a.author-name {:href (:author-url post)} (:author post)]]
              [:div
                [:span.meta-label "Published: "]
                [:span (dates/reformat-date (:date-published post) "MMM dd, YYYY")]]
              [:div
                [:span.meta-label "Modified: "]
                [:span (dates/reformat-date (:date-modified post) "MMM dd, YYYY")]]
              [:div
                [:span.meta-label "Published in: "]
                [:span (:location post)]]
              [:div
                [:span.meta-label "Reading time: "]
                [:span (str (:ttr post) " mins")]]]]]
          [:footer.post-discussion.small-12.columns  "Discussion for this post available on "
            [:a {:href (:discussion-url post)} "GitHub"] "."]]
         (common/footer)]))
