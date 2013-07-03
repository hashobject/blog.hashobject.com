<!--
name: Make static web site wtih Clojure and host it on Amazon S3 and CLoudfront
description:
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://hashobject.com/team/anton
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Tegucigalpa, Honduras
date_created: 2013-07-03
date_modified: 2013-07-03
date_published: 2013-07-03
headline:
in_language: en
keywords: clojure, amazon s3, web site, amazon route 53, amazon cloudfront, markdown, html, github
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/2
canonical_url: http://blog.hashobject.com/make-static-site-with-clojure-and-host-on-amazon
-->
## Intro

We decided to host our own [site](http://hashobject.com), [blog](http://hashobject.com) and
[open source corner](http://os.hashobject.com) on Amazon S3.

I'll not go into details about reasoning for that but rather try to explain technology used.


## Technology

There are a lot of articles on the Internet how to make you custom blog using [Jekyll](http://jekyllrb.com/)
and host it on Amazon [1](http://www.savjee.be/2013/02/howto-host-jekyll-blog-on-amazon-s3/),
[2](http://vvv.tobiassjosten.net/development/jekyll-blog-on-amazon-s3-and-cloudfront/).

Our approach was pretty similar described in these articles but instead of Jekyll we used
custom-made Clojure code.


## What can be improved

Right now I need manually run build commands to regenerate HTML content from Markdown.
Ideally this can be done automatically. E.x. site generator can be hosted on Heroku and
it can be executed automatically (to generate HTML and push it to Amazon S3) when somebody
pushes changes to GitHub repository where source hosted.