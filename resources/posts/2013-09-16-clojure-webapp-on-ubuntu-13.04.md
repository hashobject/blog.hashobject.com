---
name: Configure Clojure web app to run on Ubuntu 13.04
description:  Short guide how to deploy Clojure web app on Ubuntu 13.04 with HTTPS support with almost no cost
author: Anton Podviaznikov
author-email: anton@hashobject.com
author-url: http://twitter.com/podviaznikov
author-github: podviaznikov
author-twitter: podviaznikov
author-avatar: /images/anton-avatar.png
location: Buenos Aires, Argentina
date-created: 2013-09-16
date-modified: 2013-09-16
date-published: 2013-09-16
headline:
in-language: en
keywords: clojure web app, ubuntu 13.04, Digital Ocean, leiningen, git
discussion-url: https://github.com/hashobject/blog.hashobject.com/issues/9
---
## Intro

It's super easy to configure your new Clojure web app on Ubuntu machine.
Basically you need to install Java, Leinigen and Git.


## General instructions

Update repositories:

`sudo apt-get update`

Install Java:

`sudo apt-get install openjdk-7-jdk`

Install Leiningen:

```shell

  cd bin/
  curl https://raw.github.com/technomancy/leiningen/stable/bin/lein > lein
  chmod a+x lein

```

## Git installation

If you need to get source code of your application on server using git few steps should be made.

Install git:

`sudo apt-get install git`

Generate RSA key:

`ssh-keygen`

If you are using BitBucket follow [this instructions](https://confluence.atlassian.com/pages/viewpage.action?pageId=270827678).

For GitHub check [this page](https://help.github.com/articles/generating-ssh-keys).

In general you need to add RSA public key and grant read only access to this key.


## Final steps

Then just clone source code using git. Enter directory with source code and launch your app using
Leiningen:

`lein ring server`

or

`lein with-profile prod ring server`


## Conclusion

I tried this on [DigitalOcean](http://digitalocean.com) Ubuntu instance and it worked great.
There is another related [blog post](http://blog.hashobject.com/upstart-configuration-for-clojure-apps/)
that covers how to create upstart configuration for your Clojure web app on Ubuntu 13.04.
