(ns blog.hashobject.views.post
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [blog.hashobject.dates :as dates]
            [blog.hashobject.views.common :as common]))


(defn render [metadata]
  (html5 {:lang (:in_language metadata) :itemscope "" :itemtype "http://schema.org/BlogPosting"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content (str (:author metadata) " (" (:author_email metadata) ")" )}]
      [:meta {:name "keywords" :itemprop "keywords" :content (:keywords metadata)}]
      [:meta {:name "description" :itemprop "description" :content (:description metadata)}]
      [:meta {:itemprop "inLanguage" :content (:in_language metadata)}]
      [:meta {:itemprop "dateCreated" :content (:date_created metadata)}]
      [:meta {:itemprop "dateModified" :content (:date_modified metadata)}]
      [:meta {:itemprop "datePublished" :content (:date_published metadata)}]
      [:title {:itemprop "name"} (:name metadata)]
      [:link {:rel "shortcut icon" :href "/favicon.ico"}]
      [:link {:rel "publisher" :href "https://plus.google.com/118068495795214676039"}]
      [:link {:rel "author" :href "humans.txt"}]
      [:link {:rel "alternate" :type "application/rss+xml" :title "RSS" :href "feed.rss"}]
      [:link {:rel "discussionUrl" :href (:discussion_url metadata)}]
      [:link {:rel "canonical" :href (:canonical_url metadata)}]
      (include-css "/css/app.css")
      (include-css "https://fonts.googleapis.com/css?family=PT+Sans")
      (common/ga)]
    [:body
       (common/header)
       [:div.row.content
         [:div.post.small-12.columns
           [:h1 {:itemprop "name"} (:name metadata)]
           (str (:content metadata))
           [:aside.post-meta.small-12.medium-12.columns
            [:img.author-avatar {:src (:author_avatar metadata) :title (:author metadata)}]
            [:div.meta-info
              [:div
                [:span.meta-label "Written by: "]
                [:a.author-name {:href (:author_url metadata)} (:author metadata)]]
              [:div
                [:span.meta-label "Published: "]
                [:span (dates/reformat-datestr (:date_published metadata) "YYYY-MM-dd", "MMM dd, YYYY")]]
              [:div
                [:span.meta-label "Modified: "]
                [:span (dates/reformat-datestr (:date_modified metadata) "YYYY-MM-dd", "MMM dd, YYYY")]]
              [:div
                [:span.meta-label "Published in: "]
                [:span (:location metadata)]]
              [:div
                [:span.meta-label "Reading time: "]
                [:span (str (:ttr metadata) " mins")]]]]]
          [:footer.post-discussion.small-12.columns  "Discussion for this post available on "
            [:a {:href (:discussion_url metadata)} "GitHub"] "."]]
         (common/footer)]))
