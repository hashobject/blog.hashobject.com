(ns blog.hashobject.views.common
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))

(defn header []
  [:nav
    [:a#logo {:href "/"}]])


(defn footer []
  [:footer.row
    [:nav {:role "navigation"}
      [:ul
       [:li [:a {:href "http://hashobject.com"} "Home"]]
       [:li [:a {:href "http://blog.hashobject.com"} "Blog"]]
       [:li [:a {:href "http://code.hashobject.com"} "Code"]]
       [:li [:a {:href "http://labs.hashobject.com"} "Labs"]]]]
    [:p.license.small-12.columns "Except as otherwise noted, the content of this site is licensed
     under the <a href='http://creativecommons.org/licenses/by/3.0/'>Creative Commons Attribution 3.0 License</a>,
     and code samples are licensed under the
     <a href='http://opensource.org/licenses/eclipse-1.0'>Eclipse Public License 1.0</a>."]
    [:script {:src "//my.hellobar.com/e7784fac20054cc1170db3e6417786f1a864a9aa.js"
              :type "text/javascript"
              :charset "utf-8" :async "async"}]

])
