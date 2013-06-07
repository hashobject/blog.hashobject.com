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
      [:meta {:itemprop "author" :name "author" :content "HashObject (team@hashobject.com)"}]
      [:meta {:name "keywords" :itemprop "keywords" :content (get metadata "keywords")}]
      [:meta {:name "description" :itemprop "description" :content (get metadata "description")}]
      [:meta {:itemprop "inLaguage" :content (get metadata "inLaguage")}]
      [:meta {:itemprop "dateCreated" :content (get metadata "date_created")}]
      [:meta {:itemprop "dateModified" :content (get metadata "date_modified")}]
      [:meta {:itemprop "datePublished" :content (get metadata "date_published")}]
      [:title {:itemprop "name"}  (get metadata "name")]
      (include-css "/css/app.css")
      (common/ga)]
    [:body
     [:header]
     [:div.row
       [:div.content
         [:article.post-content.columns.large-12
          [:header.post-metadata
           [:h1 {:itemprop "name"} (get metadata "name")]
           [:a.author {:href (get metadata "author_url")} (get metadata "author")]
           [:span.date-published (dates/reformat-datestr (get metadata "date_published") "YYYY-MM-dd", "MMM dd, YYYY")]]
          (str content)]]]
     [:footer]
     ]))
