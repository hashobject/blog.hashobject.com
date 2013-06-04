(ns blog.hashobject.views.post
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))



(defn index [metadata content]
  (html5 {:lang (get metadata "inLanguage")}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "HashObject (team@hashobject.com)"}]
      [:meta {:name "keywords" :itemprop "keywords" :content (get metadata "keywords")}]
      [:meta {:name "description" :itemprop "description" :content (get metadata "description")}]
      [:title (get metadata "name")]
      (include-css "/css/app.css")]
    [:body
     (str content)]))
