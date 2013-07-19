<!--
name: Payments API for the collaborative consumption apps
description: Mangopay - payments API for marketplaces/collaborative consumption apps in Europe
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://hashobject.com/team/anton
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Nicaragua, Leon
date_created: 2013-07-18
date_modified: 2013-07-18
date_published: 2013-07-18
headline:
in_language: en
keywords: clojure, amazon s3, web site, amazon route 53, amazon cloudfront, markdown, html, github, amazon route 53, clojure hiccup
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/4
canonical_url: http://blog.hashobject.com/payments-api-for-collaborative-consumption-apps
-->
## Intro

We were looking recently for good solution to process payments for
our new app [communi.st](http://communi.st)(more on that soon).

Currently there are several really good companies that
may solve that problem for most apps (both in US and Europe markets):

  * [Stripe](https://stripe.com/)
  * [Braintree](https://www.braintreepayments.com/)
  * [Paymill](http://paymill.com/)


But we had few very specific requirements:

  * solution should be ideal for markeplaces
  * it should work in Europe


## Payments for markeplaces

describe the main case.+ escrow accounts.


## US vs Europe

Turns our that if your company is based in US there are already few options,
but [Balanced](https://www.balancedpayments.com/)
seems to be the best option (and these guys are really amazing. They are building
an open company. Read about [it](http://www.fastcolabs.com/3008944/open-company/why-i-made-my-payments-startup-an-open-company)).


But if your company is based in Europe options are much more limited.

After some investigation for us we found new promising solution called [Mangopay](http://www.mangopay.com/).

## Mangopay

Mangopay is product of [Leetchi.com](http://leetchi.com) and they claim to be
>the European leading service for group payments

In general there are two typical apps that you can built on top of their payments:

  * marketplaces and collaborative consumption platforms
  * crowdfunding platforms

## Conclusion

We still not using Mangopay API in production, but so far it looks that it fits our needs.
API itself is well designed and [documentation](http://www.mangopay.com/api-references/)
is full and has good examples.

We even created [clojure library](http://os.hashobject.com/mangopay/) for it.