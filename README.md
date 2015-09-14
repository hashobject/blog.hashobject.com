# blog.hashobject.com

Hashobject team technical blog. Generated using Clojure. Hosted on Amazon S3.

## Full deploy

```
  pygmentize -S default -f html > styl/pygments.css
  boot build
```

This will build all html, sitemap, rss, js, css and deploy it to S3.


## CloudFront invalidation

```

  /
  /index.html
  /css/app.css
  /clojure-webapp-on-ubuntu-13.04/
  /clojure-webapp-on-ubuntu-13.04/index.html
  /upstart-configuration-for-clojure-apps/
  /upstart-configuration-for-clojure-apps/index.html
  /install-postgresql-9.2-on-ubuntu-13.04/
  /install-postgresql-9.2-on-ubuntu-13.04/index.html
  /product-launch-on-betalist/
  /product-launch-on-betalist/index.html
  /website-launch-checklist/
  /website-launch-checklist/index.html
  /payments-api-for-collaborative-consumption-apps/
  /payments-api-for-collaborative-consumption-apps/index.hmtl
  /make-static-site-with-clojure-and-host-on-amazon/
  /make-static-site-with-clojure-and-host-on-amazon/index.html
  /tips-for-running-clojure-webapp-on-amazon-beanstalk/
  /tips-for-running-clojure-webapp-on-amazon-beanstalk/index.html
  /clojure-webapp-with-https-support-on-amazon-beanstalk/
  /clojure-webapp-with-https-support-on-amazon-beanstalk/index.html
  /hacker-school-vs-finnish-education-system/
  /hacker-school-vs-finnish-education-system/index.html
  /places-to-hangout-with-hackers-around-the-world/
  /places-to-hangout-with-hackers-around-the-world/index.html
  /5-tech-videos-collections/
  /5-tech-videos-collections/index.html
  /tinychat/
  /tinychat/index.html
  /3rd-party-tools-and-services/
  /3rd-party-tools-and-services/index.html
  /first-timers/
  /first-timers/index.html
  /is-history-harmful/
  /is-history-harmful/index.html
  /innovations-in-clothing/
  /innovations-in-clothing/index.html
  /no-russian-rebound/
  /no-russian-rebound/index.html
  /ukrainian-vs-russian/
  /ukrainian-vs-russian/index.html
  /meeting-famous-people/
  /meeting-famous-people/index.html
  /traveling-and-diversity/
  /traveling-and-diversity/index.html
  /ukraine/
  /ukraine/index.html
  /5-years/
  /5-years/index.html
  /me-goosta/
  /me-goosta/index.html
```

## Content License

Except as otherwise noted, the content of this [site](http://blog.hashobject.com)
is licensed under the [Creative Commons Attribution 3.0 License](http://creativecommons.org/licenses/by/3.0/),
and code samples are licensed under the [Eclipse Public License 1.0](http://opensource.org/licenses/eclipse-1.0).

## Code License

Copyright © 2013-2015 Hashobject Ltd (team@hashobject.com).

Distributed under the [Eclipse Public License](http://opensource.org/licenses/eclipse-1.0).
