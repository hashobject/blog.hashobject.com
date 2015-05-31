<!--
name: Upstart configuration for Clojure apps
description: Short guide how to create Ubuntu Upstart configuration for Clojure apps using Leiningen
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Quito, Ecuador
date_created: 2013-09-01
date_modified: 2015-05-31
date_published: 2013-09-01
headline:
in_language: en
keywords: clojure, upstart, ubuntu, leiningen
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/8
canonical_url: http://blog.hashobject.com/upstart-configuration-for-clojure-apps
-->
## Intro

If you are deploying any app to production you want to run it as Linux daemon.
In Ubuntu you can use [Upstart](http://upstart.ubuntu.com/) as tool that will restart
you app automatically in case of crash.


## Instructions

To use Upstart you need to create configuration file for your app inside the /etc/init directory.

Pick up any good name for your app (e.x. 'mywebapp') and create file /etc/init/mywebapp.conf

`nano /etc/init/mywebapp.conf`

Let's assume that you have source code for your app in the following directory:
`/root/apps/mywebapp` and you can run you application within directory using lein
`lein with-profile prod ring server`.

Then /etc/init/mywebapp.conf content should look similar to this:

```shell

  author "Team Hashobject"
  description "Start the mywebapp clojure on port 3000"
  start on (local-filesystems and net-device-up IFACE!=lo)
  chdir root/apps/communi.st
  env LEIN_ROOT=yes
  exec lein with-profile prod ring server

```

The last 3 lines are the most important:

  * chdir allows you to configure path to the source code
  * setting environment variable LEIN_ROOT disables warning that you may see if you try to run app under the root
  * exec - actually starts your ring server


This is just sample upstart configuration file. You can refer documentation for more features.


After you save this configuration you can start your app using `start mywebapp`
and stop it using `stop mywebapp`


All logs for you app will be available in /var/log/upstart/mywebapp.log file.


## Conclusion

Provided instructions should definitely work on Ubuntu 13.04. This configuration was tested
on [DigitalOcean](http://digitalocean.com) with Leiningen 2 and Clojure 1.5.1.

In this post I described how to run Clojure web app in production using Leiningen and Upstart.

You can also do this by just running Java jar files using Upstart. See following
[article](https://theholyjava.wordpress.com/2013/07/27/running-a-leiningenring-webapp-as-a-daemon-via-upstart-ubuntu) for more details.
