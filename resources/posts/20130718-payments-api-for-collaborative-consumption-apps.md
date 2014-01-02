<!--
name: Payments API for the collaborative consumption apps
description: Payments API for marketplaces/collaborative consumption apps in Europe
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: Nicaragua, Leon
date_created: 2013-07-18
date_modified: 2013-07-18
date_published: 2013-07-19
headline:
in_language: en
keywords: payments, marketplaces, collaborative consuption, web apps,clojure, mangopay
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/4
canonical_url: http://blog.hashobject.com/payments-api-for-collaborative-consumption-apps
-->
## Intro

We were looking recently for good solution to process payments for
our new app [communi.st](http://communi.st) (more on that soon).

Currently there are several really good companies (both in US and Europe markets) that
may solve that problem for most apps (especially SaaS):

  * [Stripe](https://stripe.com/)
  * [Braintree](https://www.braintreepayments.com/)
  * [Paymill](http://paymill.com/)


But we had few very specific requirements:

  * solution should be ideal for marketplaces
  * it should work in Europe


## Payments for marketplaces


If you are trying to build online marketplace there are basically two types of customers:

  * buyers - people who buy stuff. You want to be able to process their payments
  * sellers - people who sell stuff. They should be able to get earned money out of the marketplace on their personal/business accounts

Online marketplace usually works within following steps:

  1. process payment from buyer
  2. cut procent from transaction as service fee
  3. put money on virtual account of the seller
  4. seller transfers money to his personal account (using e.x. bank wire transfer)


Collaborative consumption apps (think [AirBnB](http://airbnb.com)) have just one additional step:

  1. process payment from buyer
  2. cut procent from transaction as service fee
  3. hold money on virtual escrow account
  4. put money on virtual account of the seller
  5. seller transfers money to his personal account (using e.x. bank wire transfer)

The only difference is that usually in crowdfunding apps sellers will not get money immediately
(on AirBnB owner of the place will get money after you move in, but money itself will be locked on your account
immediately after reservation).



## US vs Europe

Turns out that if your company is based in US there are already few options,
but [Balanced](https://www.balancedpayments.com/) seems to be the best one.
These guys are really amazing. They are building an open company.
Read about [it](http://www.fastcolabs.com/3008944/open-company/why-i-made-my-payments-startup-an-open-company).


But if your company is based in Europe options are much more limited.

After some investigation for us we found new promising solution called [Mangopay](http://www.mangopay.com/).

## Mangopay

Mangopay is product of [Leetchi.com](http://leetchi.com) and they claim to be
>the European leading service for group payments

In general there are two typical apps that you can built on top of their payments:

  * marketplaces and collaborative consumption platforms
  * crowdfunding platforms

And that was exactly what we needed.


## Conclusion

We still not using Mangopay API in production, but so far it looks that it fits our needs.
API itself is well designed and [documentation](http://www.mangopay.com/api-references/)
is full and has good examples.

We even created [Clojure library](http://os.hashobject.com/mangopay/) for it.
