(ns blog.hashobject.views.common
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))


(defn ga []
  [:script "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-41533076-2', 'hashobject.com');
  ga('require', 'displayfeatures');
  ga('send', 'pageview');"])


(defn header []
  [:nav#main-nav {:role "navigation"}
     [:div.header
      [:a#logo {:href "/"}]
      [:a#toggle {:href "#"} [:div.icon]]]
     [:div.overlay
       [:ul
        [:li [:a {:href "http://hashobject.com"} "Home"]]
        [:li.active [:a {:href "http://blog.hashobject.com"} "Blog"]]
        [:li [:a {:href "http://os.hashobject.com"} "Open Source"]]
        [:li [:a {:href "http://labs.hashobject.com"} "Labs"]]]]])

(defn footer []
  [:footer.row
    [:p.license.small-12.columns "Except as otherwise noted, the content of this site is licensed
     under the <a href='http://creativecommons.org/licenses/by/3.0/'>Creative Commons Attribution 3.0 License</a>,
     and code samples are licensed under the
     <a href='http://opensource.org/licenses/eclipse-1.0'>Eclipse Public License 1.0</a>."]
    [:script "var btn = document.getElementById('toggle');
              var nav = document.getElementById('main-nav');
              btn.addEventListener('click', function(e) {
                e.preventDefault();
                if(!nav.classList.contains('open')) {
                  nav.classList.add('open')
                } else {
                  nav.classList.remove('open')
                }
              });"]])
