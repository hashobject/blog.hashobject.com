(ns blog.hashobject.views.post
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [blog.hashobject.dates :as dates]
            [blog.hashobject.views.common :as common]))


(defn index [metadata content]
  (html5 {:lang (get metadata "inLanguage") :itemscope "" :itemtype "http://schema.org/BlogPosting"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content (str (get metadata "author") " (" (get metadata "author_email") ")" )}]
      [:meta {:name "keywords" :itemprop "keywords" :content (get metadata "keywords")}]
      [:meta {:name "description" :itemprop "description" :content (get metadata "description")}]
      [:meta {:itemprop "inLanguage" :content (get metadata "in_language")}]
      [:meta {:itemprop "dateCreated" :content (get metadata "date_created")}]
      [:meta {:itemprop "dateModified" :content (get metadata "date_modified")}]
      [:meta {:itemprop "datePublished" :content (get metadata "date_published")}]
      [:title {:itemprop "name"} (get metadata "name")]
      [:link {:rel "shortcut icon" :href "/favicon.ico"}]
      [:link {:rel "publisher" :href "https://plus.google.com/118068495795214676039"}]
      [:link {:rel "author" :href "humans.txt"}]
      [:link {:rel "alternate" :type "application/rss+xml" :title "RSS" :href "feed.rss"}]
      [:link {:rel "discussionUrl" :href (get metadata "discussion_url")}]
      [:link {:rel "canonical" :href (get metadata "canonical_url")}]
      (include-css "/css/app.css")
      (include-css "http://fonts.googleapis.com/css?family=PT+Sans")
      (common/ga)
     ]
    [:body
     [:div.off-canvas-wrap
       [:div.inner-wrap
         (common/header)
         [:div.row
           [:div.post.small-12.columns
             [:h1 {:itemprop "name"} (get metadata "name")]
             (str content)
             [:aside.post-meta.small-12.columns
              [:img.author-avatar {:src (get metadata "author_avatar") :title (get metadata "author")}]
              [:div.meta-info
                [:div
                  [:span.meta-label "Written by"]
                  [:a.author-name {:href (get metadata "author_url")} (get metadata "author")]]
                [:div
                  [:span.meta-label "Published: "]
                  [:span (dates/reformat-datestr (get metadata "date_published") "YYYY-MM-dd", "MMM dd, YYYY")]]
                [:div
                  [:span.meta-label "Modified: "]
                  [:span (dates/reformat-datestr (get metadata "date_modified") "YYYY-MM-dd", "MMM dd, YYYY")]]
                [:div
                  [:span.meta-label "Published in: "]
                  [:span (get metadata "location")]]
                [:div
                  [:span.meta-label "Reading time: "]
                  [:span (str (:ttr metadata) " mins")]]]]]
            [:footer.post-discussion.small-12.columns  "Discussion for this post available on "
              [:a {:href (get metadata "discussion_url")} "GitHub"] "."]]
         (common/footer)]]]))
