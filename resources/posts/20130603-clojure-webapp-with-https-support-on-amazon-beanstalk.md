<!--
name: Configure Clojure web app to run with HTTPS support on Amazon Beanstalk
description: Short guide how to deploy Clojure web app on Amazon Beanstalk with HTTPS support with almost no cost.
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://hashobject.com/team/anton
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Guatemala City, Guatemala
date_created: 2013-06-03
date_modified: 2013-06-10
date_published: 2013-06-06
headline:
in_language: en
keywords: clojure, amazon beanstalk, https, ssl, aws, heroku, deploy, web app, amazon route 53, naked domain
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/1
canonical_url: http://blog.hashobject.com/clojure-webapp-with-https-support-on-amazon-beanstalk.html
-->
## Intro

Currently there are several options for hosting Clojure web apps.

The obvious one is [Heroku](http://heroku.com) with their great
[guide](https://devcenter.heroku.com/articles/clojure-web-application).

However, if your web app needs SSL support on custom domain you immediately need to pay $20/month
for the [Heroku addon](https://addons.heroku.com/ssl).


The second option is to host your Clojure web app on Amazon EC2. This can be done almost for free for
the first year if your app is small enough. Check out AWS [Free Usage Tier](http://aws.amazon.com/free/).
Hosting web app on Amazon EC2 has its own upsides and downsides.


The third solution (probably, there are many other options out there) is the one, that I want to describe in this post.


## Amazon Beanstalk

Amazon has product in their AWS suite which reminds Heroku a lot.

It's called [Beanstalk](http://aws.amazon.com/elasticbeanstalk/). According to Amazon docs:

>New AWS customers who are eligible for the AWS free usage tier can deploy an application in Elastic Beanstalk for free.


There are some resources that can help Clojure developers to deploy their apps on Beanstalk.
I recommend reading this [blog post](http://www.ctdean.com/2012/04/10/aws-beanstalk-on-clojure.html) and using
[lein-beanstalk](https://github.com/weavejester/lein-beanstalk) plugin.

Basically you will be able to deploy you app using following command:
`lein beanstalk deploy prod`
Where 'prod' is the name of you environment that you need to specify creating Beanstalk app.

Creating Amazon Beanstalk application is easy. Just follow [official docs](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/create_deploy_Java.html).
You can choose Tomcat 6 or Tomcat 7 as container (both 32 and 64 bit).


## How to get SSL certificate

Usually I'm getting my SSL certificates from [StartSSL](http://www.startssl.com/).

They are providing Class 1 SSL certificates for 1 year for free.

You will get from them (after registration and applying for certificate) two files:

  * certificate (let's call it server.crt).
    File content starts with '-----BEGIN CERTIFICATE-----'.
  * private key (let's call it ssl.key).
    File content starts with '-----BEGIN RSA PRIVATE KEY-----'.

You shouldn't share these files.


## How to setup custom domain(naked domain) for Beanstalk application

I recommend to use [Amazon Route 53](http://aws.amazon.com/route53/) for managing DNS records.
If you have a hosted zone on Amazon Route 53 for your domain name, then you need just to create new Record set
of type A.

Select "Yes" for "Alias" field and you will be able to select Elastic Load balancer that works
with your Beanstalk instance in the "Alias target" field.

After this is done you will be able to reach your web app using naked domain name (e.x. example.com instead of www.example.com).


## How to configure HTTPS support for you Beanstalk application

There is a nice [article](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/configuring-https.html)
in Amazon docs about how to add HTTPS support for your Beanstalk application.

You need to upload your SSL certificate using command
`iam-servercertupload -b server.crt -k ssl.key -s server`
You will get Amazon Resource name for your certificate similar to
`arn:aws:iam::123456789012:server-certificate/cert`

After uploading SSL certificate you need to edit configuration for your Beanstalk app.
In the "Load balancer" section specify:

  * Secure listener port: 443
  * Protocol: HTTPS
  * SSL Certiificate ID: Amazon Resource name that you received after certificate upload.


## Conclusion

In this post I tried to describe steps needed to have Clojure web app deployed to Amazon Beanstalk
and available behind your own secure naked domain.

Described setup will cost almost nothing for the first year.