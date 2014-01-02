<!--
name: Website launch checklist
description: List of activities to do while launching website
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: San Jose, Costa Rica
date_created: 2013-07-22
date_modified: 2013-08-03
date_published: 2013-07-22
headline:
in_language: en
keywords: web site, web app, lauch checklist
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/5
canonical_url: http://blog.hashobject.com/website-launch-checklist
-->
## Intro

Here I'll try to write down list of typical activities that should be performed during
web site launch. Please note that all of them have different priorities and impacts.
And not all of them should be applied to your particular site.

## robots.txt

In this file you should specify what pages should be crawlable by web spiders.
Please visit [documentation site](http://www.robotstxt.org/robotstxt.html) for more details. Basically
you are specifying private (will not be available on Google and other search engines) and public URLs.


## analytics

Configuring analytics will help you to have better understanding about visitors and content on your site:
who visiting your site, how often, which mobile browser is the most popular among the visitors etc.
[Google analytics](https://www.google.com/analytics/) is the most well-known solution, but there are
much more options, e.x. [Mixpanel](http://mixpanel.com/), [KISSMetricks](https://www.kissmetrics.com/),
[Segment.io](https://segment.io/).

## sitemap.xml

This file defines structure of your site. You should enumerate all pages
that are available on your resource. Listing all pages will help web spiders(e.x. Google bot) faster
index your content. See [documentation](http://www.sitemaps.org/) for more details.

## google webmaster tools

Setup [Google Webmaster Tools](https://www.google.com/webmasters/tools/) - set of free tools to monitor
and analyze your site. Easy to configure.

## social

Setup social accounts if it's important to your site: twitter, google+, facebook, reddit.

## semantic markup

Markup your pages with appropriate schemas from [schema.org](http://schema.org). This will help search engines
to understand content on your site much better. E.x. if you are developing site for hotel use following
schema - [http://schema.org/Hotel](http://schema.org/Hotel), if it's blog post page - [http://schema.org/BlogPosting](http://schema.org/BlogPosting).

## metatags

Fill proper data in 'head' tag of your html pages.
At leats don't forget to specify following 'meta' tags: author, keywords,
description.

## favicon

Add favicon (icon that is visible in the tab of the browser). Read [more](https://en.wikipedia.org/wiki/Favicon) about it.

## chrome web store

If you are developing web app you may think about publishing it to [Chrome Web Store](https://chrome.google.com/webstore).
In such case you will have one more channel for discoverability - users will find your app through the store.
It's fairly easy to publish application to Web Store. Please visit [official documentation](https://developers.google.com/chrome/web-store/docs/publish)
for details guide on this topic.

## pagespeed tools

Before making your site public make sure to run [PageSpeed Tools](https://developers.google.com/speed/pagespeed/).
You will get a lot of information and tips about performance on your new web resource.

## humans.txt

Your site should have humans.txt file in the root which will provide information about people responsible
for the site: developers, designers etc.
Check out [official documentation](http://humanstxt.org/). If you will add such file guys from
[http://humanstxt.org](http://humanstxt.org) will put link to your site in their directory.

Adding humans.txt file is not very common practice, but I like the idea and I think we should promote it.

## Conclusion

There are a lot of ways how tow to make your web site better.
You should optimize for speed, SEO, content, usability, discoverability and so on.
There is no such thing as ideal web site. Everything can be improved and done better.
In this post I tried to cover some basic steps that can be done very easily while publishing new
site.
