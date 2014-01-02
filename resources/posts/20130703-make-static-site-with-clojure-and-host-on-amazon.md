<!--
name: Make static web site with Clojure and host it on Amazon S3 and CloudFront
description: Short guide how to create static web site using Clojure and host it on Amazon S3 and CloudFront
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Tegucigalpa, Honduras
date_created: 2013-07-06
date_modified: 2013-07-06
date_published: 2013-07-06
headline:
in_language: en
keywords: clojure, amazon s3, web site, amazon route 53, amazon cloudfront, markdown, html, github, amazon route 53, clojure hiccup
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/3
canonical_url: http://blog.hashobject.com/make-static-site-with-clojure-and-host-on-amazon
-->
## Intro

We decided to host our own [site](http://hashobject.com), [blog](http://hashobject.com) and
[open source corner](http://os.hashobject.com) sites on Amazon S3.

I'll not go into details about reasoning for that but rather try to explain technology used.


## Technology

There are a lot of articles on the Internet how to make you custom blog using [Jekyll](http://jekyllrb.com/)
and host it on Amazon [1](http://www.savjee.be/2013/02/howto-host-jekyll-blog-on-amazon-s3/),
[2](http://vvv.tobiassjosten.net/development/jekyll-blog-on-amazon-s3-and-cloudfront/).

Our approach was very similar to one described in these articles but instead of Jekyll we used
custom [Clojure code](https://github.com/hashobject/blog.hashobject.com/blob/master/src/blog/hashobject/generator.clj).

Our code is very similar to standalone Clojure library for sites generation called
[ecstatic](https://github.com/samrat/ecstatic).


It's pretty trivial to generate HTML code in any programming language. In Clojure we are
using [Hiccup library](https://github.com/weavejester/hiccup).

After you have static site (html, css, images etc) you can host it on Amazon S3.
Please see [official documentation](http://docs.aws.amazon.com/AmazonS3/latest/dev/WebsiteHosting.html)
how to do that.


Hosting your static web sites has already amazing benefits:

  * your site will be served very fast to clients
  * Amazon will handle all load when someday you'll get a lot of users/traffic
  * it's very cheap

However you can improve speed dramatically even more. For that you need [Amazon CloudFront](https://aws.amazon.com/cloudfront/).
CloudFront is Amazon's own Content Distribution Network. Amazon basically will push your static
site to the hundreds(thousands?) of servers located in different parts of the world.
So e.x. if some user will visit your site from far country your site will not be served from
e.x. US East coast but from closest server to that user.



## Configure Amazon CloudFront for S3 bucket

Please read [official documentation](http://docs.aws.amazon.com/AmazonCloudFront/2012-03-15/GettingStartedGuide/StartingCloudFront.html)
how to configure CloudFront to work with site deployed to your S3 bucket.

I would give you just one small tip.
If you have S3 bucket with the name example.com CloudFront will suggest
`example.com.s3.amazonaws.com` as Origin Domain Name during distribution creation.
If you choose such name you may have some troubles:
'example.com/some-folder' will not be resolved automatically to 'example.com/some-folder/index.html'.
I suggest to use full endpoint name for your S3 bucket. E.x. for bucket hosted on the US East
`example.com.s3-website-us-east-1.amazonaws.com`


After creating 'Content distribution' on Amazon CloudFront for your site you should change your DNS records.
Basically you need some way to resolve DNS name of your site (e.x. [http://os.hashobject.com](http://os.hashobject.com))
into CloudFront URL for your distribution. Luckily if you already using [Amazon Route 53](https://aws.amazon.com/route53/)
it will be super easy to do.
You need to create new Record Set of type 'A' for your domain name.
Then just select Alias and pickup your CloudFront distribution you just created.



## What can be improved

Right now I need manually run build commands to re-generate HTML content from Markdown.
Ideally this can be done automatically. E.x. site generator can be hosted on Heroku and
it can be executed automatically (to generate HTML and deploy it to Amazon S3) when somebody
pushes changes to GitHub repository where source hosted.
