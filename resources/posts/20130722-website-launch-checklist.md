<!--
name: Website launch checklist
description: List of activities to do while launcging website
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://hashobject.com/team/anton
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: San Jose, Costa Rica
date_created: 2013-07-22
date_modified: 2013-07-22
date_published: 2013-07-22
headline:
in_language: en
keywords: web site, web app, lauch checklist
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/5
canonical_url: http://blog.hashobject.com/website-launch-checklist
-->
## Intro

Here I'll try to write down list of typical activities that should be perfomed launching
web site or web app. Please note that all of them have different priorities an impacts.

## Checklist

  * add robots.txt file - in this file you should specify what pages should be crawlable by web spiders.
    Please visit [documentation site](http://www.robotstxt.org/robotstxt.html) for more details. Basically
    you are specifying private (will not be available on Google and other search engines) and public URLs.
  * add humans.txt file - not so important as robots.txt file. Your site should has humans.txt file in the
    root which will provide infomation about people responsible for the site: developers, designers etc.
    Check out [official documentation](http://humanstxt.org/). If you will add such file guys from
    http://humanstxt.org will put link to your site in their directory.
  * configure analytics - this will help you to understand something about visitors and your content:
    who visiting your site, how often, which mobile browser is the most popular among the visitors etc.
    [Google analytics](https://www.google.com/analytics/) is the most well-nkown solution, but there are
    much more options, e.x. [Mixpanel](http://mixpanel.com/), [KISSMetricks](https://www.kissmetrics.com/),
    [Segment.io](https://segment.io/).
  * add sitemap.xml file - this file defines structure of your site. You should enumerate all pages
    that are available on your resource. Listing all pages will help web spiders(e.x. Google bot) faster
    index your content. See [documentation] for more details.
  * setup [Google Webmaster Tools](https://www.google.com/webmasters/tools/) - set of free tools to monitor
    and analyze your site. Easy to setup.
  * setup social accounts if it's important to your app/site.
  * markup your pages with apprpriate schemas from [schema.org](http://schema.org). This will help search engines
    to understand content on your site much better. E.x. if you are developing site for hotel use following
    schema - http://schema.org/Hotel, if it's blog post page - http://schema.org/BlogPosting
  * fill proper data in you head tag. At leats don't forget to specify following 'meta' tags: author,keywords,
    description
  * dont' forget to add favicon (icon that is visible in the tab of the browser).
  * if you are developing web app you may think about publishing it to [Chrome Web Store](https://chrome.google.com/webstore).
    In such case you will have one more channel for discoverability - users will find your app through the store.
    It's fairly easy to publish application to Web Store. Please visit [official documentation](https://developers.google.com/chrome/web-store/docs/publish)
    for deatils guide on this topic.
  * before making your site/app public make sure to run [PageSpeed Tools](https://developers.google.com/speed/pagespeed/).
    You will get a lot of information and tips about performance on your new web resource.

## Conclusion

There are a lot of dimensions that you need to work on to do a proper web site/app.
You should optimize for speed, SEO, content, usability, discoverability and so on.
There is no such thing as ideal web site. Everything can be improved and done better.
In this post I tried to cover some basic steps that can be done very easily while publishing new
site/app.
