<!--
name: Ukrainian-vs-Russain
description: Are Ukrainian and Russian are the same language?
author: Anton Podviaznikov
author_email: anton@hashobject.com
author_url: http://twitter.com/podviaznikov
author_github: podviaznikov
author_twitter: podviaznikov
author_avatar: /images/anton-avatar.png
location: San Francisco, USA
date_created: 2014-10-27
date_modified: 2014-10-27
date_published: 2014-10-27
headline:
in_language: en
keywords: history, politics, ukraine, education
discussion_url: https://github.com/hashobject/blog.hashobject.com/issues/19
canonical_url: http://blog.hashobject.com/ukrainian-vs-russian
-->

## Intro

After leaving Ukraine 4 years ago I was often asked by people whether Ukrainian and Russian languages are the same?
Initially I didn’t have good intuition to answer that question since I’m (as lot of Ukrainians) bi-lingual - I can speak, think, read, write in both languages.
Than I realized that it’s very difficult question if you ask Ukrainian. But it’s much easier if you ask Russian. Most Russians wouldn’t be able even understand Ukrainian without big effort. A lot of words would be unfamiliar, pronunciation would be different etc.

## Political context

Many things happened in Ukraine in the last year (since November 2013). Before we were taught through media and education that Russians are the “closest” nation to Ukraine. It smelled like Russian propaganda to me.
It made sense that Russians were spreading that information but was that true? I had serious doubts. Especially after living in the Balkans region for two years of my life, visiting Poland and Czech Republic I started to noticed pretty big
similarities between those languages and Ukrainian.


## Investigation

So I had some questions and some doubts over the years about my previous beliefs. I teamed up with [Maryna](twitter.com/m_aleksandrova) and we decided to write simple program that will calculate programmatically how close are Ukrainian and Russian languages.

We started with the most simple possible approach:

  1. find dictionary with Ukrainian and Russian words
  2. transliterate those words to neutral alphabet (we transliterated to English)
  3. find how manu words are would be the same from two dictionaries

We initially decided to use pronunciation as the rule for transliteration.
That was important because Ukrainian letter "е" spelled in the same way as Russian "е" but they sound very different.
In fact Russian "е" would be replaced with two sounds in Ukrainian "йе".

Our progam was simple but we were still shocked with the result.
We used Ukrainian dictionary with *110180* words, Russian dictionary with *170335* words.
We found out that only **9193** or approximately **8.4%** from all Ukrainian words.

Obviosly after some improvements to the algorithms that number will go up. But even at this point I doubpt that
Ukrainian and Russian languages are super similar (Serbian and Croatian type similar).

You can find our [code](http://github/hashobject/ukr-vs-rus) on github.


## Next

How research should be improved:

  1. we should calculate levenstein distance between words too. Most words would be almost the same and the difference would be just in one sound.
  2. ideally we should take meaning of the word into the account. Some words are spelled in Ukrainian and Russian in same way but have different meaning
  3. I would like to make similar research for other languages. E.x. how close are Ukrainian and Polish, Ukrainian and Croatian and in the future e.x. Spanish and Portuguese.

Also differences dictionaries is not exclusive metric for comparing languages. If you want to improve research you can take into account grammar rules and maybe something more. It feels for me like a good PhD research topic. If somebody did it I would like to read about results and see the code.



## Conclusion

A lot of things can be accomplished using simple programming skills. We can get answers for questions that bugged as for years, we can destroy myths and find truths. There is another [research](http://elms.wordpress.com/2008/03/04/lexical-distance-among-languages-of-europe/) that shows that Ukrainian is much closer to Polish that to Russian.
I don't have any formal prove for that but to be honest that result wouldn't surpise me. My intuition about "distance" between two languages changed a lot.
Eventually I would like to see open source tool kit that can programmatically calculate distance between any two languages. If you know someone who is working on that - let me know.
