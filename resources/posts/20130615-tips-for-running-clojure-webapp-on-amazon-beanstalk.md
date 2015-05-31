<!--
name: Tips for running Clojure web app on Amazon Beanstalk
description: Bunch of small advises for running Clojure web app on Amazon Beanstalk
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: San Salvador, El Salvador
date_created: 2013-06-15
date_modified: 2015-05-31
date_published: 2013-06-26
headline:
in_language: en
keywords: clojure, amazon beanstalk, https, aws, logs, tips, logging, web app
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/2
canonical_url: http://blog.hashobject.com/tips-for-running-clojure-webapp-on-amazon-beanstalk
-->
## Logging

If you are using `clojure.tools.logging` in the app for logging, the following snippet will
help you to have proper logs on Amazon Beanstalk.

```clojure

  (alter-var-root
   #'clojure.tools.logging/*logger-factory*
   (constantly (clojure.tools.logging.impl/jul-factory)))

```

For Ring/Compojure projects just put this code somewhere at the top of your web handler file.

## Force HTTPS

I described how to get HTTPS support for Clojure web app deployed on Amazon Beanstalk in the
[previous post](http://blog.hashobject.com/clojure-webapp-with-https-support-on-amazon-beanstalk.html).

Sometimes you need to force HTTPS traffic for everything. So e.x. if user requests page on
http://example.com you want to redirect him on https://example.com.

You can setup proxy to do just that.

I was able to achieve this with a sample ring middleware:

```clojure

  (defn https-url [request-url]
    (str (str (str (str "https://" (:server-name request-url) ":") "443")) (:uri request-url)))


  (defn require-https
    [handler]
    (fn [request]
      (if (= (:scheme request) :http)
        (ring.util.response/redirect (https-url request))
        (handler request))))

```

And then just add `require-https` middleware to your other middlewares. E.x.:

```clojure

  (def war-handler
    (-> app
      (require-https)
      (wrap-resource "public")
      (wrap-base-url)
      (wrap-file-info)))

```
