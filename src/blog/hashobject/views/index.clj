(ns blog.hashobject.views.index
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))



(defn index []
  (html5 {:lang "en"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "HashObject (team@hashobject.com)"}]
      [:meta {:name "keywords" :itemprop "keywords" :content "HashObject, hashobject, #{hash:object}, HashObject Team, HashObject Ltd"}]
      [:meta {:name "description" :itemprop "description" :content "HashObject - software engineering, design and application development"}]
      [:title "HashObject: we love development"]
      (include-css "/css/app.css")]
    [:body "Our site will be here soon..."]     ))
