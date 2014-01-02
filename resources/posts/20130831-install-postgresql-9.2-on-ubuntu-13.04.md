<!--
name: Install PostreSQL 9.2 on Ubuntu 13.04
description: Short guide how to install PostgreSQL 9.2 on Ubuntu 13.04
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Banos, Ecuador
date_created: 2013-08-31
date_modified: 2013-09-16
date_published: 2013-08-31
headline:
in_language: en
keywords: postgresql 9.2, ubuntu 13.04, digitalocean
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/7
canonical_url: http://blog.hashobject.com/install-postgresql-9.2-on-ubuntu-13.04
-->
## Intro

It's super easy to install default version of PosgtreSQL on Ubuntu.
Usually it is just: `apt-get install postgresql`.

However if you need to install version that became available after Ubuntu release
than it is a little bit more complicated. E.x. PostgreSQL 9.2 was released after Ubuntu 13.04 version.
Read about this in [official documentation](http://www.postgresql.org/download/linux/ubuntu/).
Also check this [StackOverflow discussion](http://askubuntu.com/questions/287786/how-to-install-postgresql-on-ubuntu-13-04).


## Instructions

Install missing dependencies:

`sudo apt-get install libpq-dev libpq5`.

Add PostgreSQL repo:

`sudo su; echo 'deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main' >> /etc/apt/sources.list.d/pgdg.list`

Add the key:

`wget --quiet -O - http://apt.postgresql.org/pub/repos/apt/ACCC4CF8.asc | apt-key add -`

Update repositories:

`sudo apt-get update`

Install PostgreSQL:

`sudo apt-get -t raring install postgresql-common -t raring postgresql-9.2 postgresql-client-9.2`

In this example I'm installing just PostgreSQL server and client, but you can also install 'postgresql-contrib-9.2'
package in addition.

## Conclusion

I tried this on [DigitalOcean](http://digitalocean.com) Ubuntu instance and it worked great.
Actually this instructions are heavily inspired by following [post](http://linuxg.net/how-to-install-postgresql-9-2-on-ubuntu-13-04-raring-ringtail/). I found other instructions that tried to solve same problem but they didn't work for me.
