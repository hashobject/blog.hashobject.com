# blog.hashobject.com

Hashobject team technical blog. Generated using Clojure. Hosted on Amazon S3.


## Full deploy

Inside `frontend` directory execute command:

```
  pygmentize -S default -f html > styl/pygments.css
  lein index-html;lein posts-html;lein sitemap-xml; grunt deploy; lein sitemap
```

This will build all html, sitemap, css and deploy it to S3.


## Content License

Except as otherwise noted, the content of this [site](http://blog.hashobject.com)
is licensed under the [Creative Commons Attribution 3.0 License](http://creativecommons.org/licenses/by/3.0/),
and code samples are licensed under the [Eclipse Public License 1.0](http://opensource.org/licenses/eclipse-1.0).

## Code License

Copyright © 2013 Hashobject Ltd (team@hashobject.com).

Distributed under the [Eclipse Public License](http://opensource.org/licenses/eclipse-1.0).
