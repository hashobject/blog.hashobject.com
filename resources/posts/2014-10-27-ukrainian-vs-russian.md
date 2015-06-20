---
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
---

## Intro

After leaving Ukraine 4 years ago I was often asked by people whether Ukrainian and Russian languages are the same?
Initially I didn’t have good intuition to answer that question since I’m (as lot of Ukrainians) bi-lingual - I can speak, think, read, write in both languages.
Then I realized that it’s very difficult question if you ask Ukrainians. But it’s much easier if you ask Russians. Most Russians wouldn’t be able to even understand Ukrainian without big effort. Lots of words would be unfamiliar, pronunciation would be different etc.

## Political context

Many things happened in Ukraine in the last year (since November 2013). Before, we were taught through media and education that Russians are the “closest” nation to Ukraine - "they are our brothers" - and Ukrainian is the closest language to Russian. It smells like Russian propaganda to me now. They definitely had an interest to spred such information, but was that information true? I started to have serious doubts. Especially after living in the Balkans region for two years of my life, visiting Poland and Czech Republic I started to notice many similarities between those languages and Ukrainian.


## Investigation

So I had some questions and some doubts over the years about my previous beliefs. I teamed up with [Maryna](twitter.com/m_aleksandrova) and we decided to write simple program that will calculate programmatically how close are Ukrainian and Russian languages.

We started with the simplest approach:

  1. find dictionary with Ukrainian and Russian words
  2. transliterate those words to neutral alphabet (we transliterated to English)
  3. find how manu words are would be the same from two dictionaries

We initially decided to use pronunciation as the rule for transliteration.
That was important because Ukrainian letter "е" written the same way as Russian "е" but they sound very different.
In fact Russian "е" would be replaced with two sounds ("йе") in Ukrainian.

Our progam was simple but we were still shocked with the result.
We used Ukrainian dictionary with *110180* words, Russian dictionary with *170335* words.
And we found that only **9193** (approximately **8.4%** of all Ukrainian words) have the same transliteration.

Obviosly after some improvements to the algorithms that number will go up. Also some changes might drive those numbers down. E.x. word "milk" spelled same way in both languages, but they are prononced very different:
"малако" in Russian and "молоко" in Ukrainian. But even at this point I doubt that
Ukrainian and Russian languages are super similar (I mean Serbian and Croatian type of similarity).

You can find our [code](http://github/hashobject/ukr-vs-rus) on github.


## Next

How research have to be improved:

  1. [Levenshtein distance](http://en.wikipedia.org/wiki/Levenshtein_distance) between words may be calculated. It's interesting to find how many words are different with just one or two sounds. E.x. word "sun" - in Russian it's spelled "солнце", while in Ukrainian "сонце", but pronunciation of both words is the same (In Russian you just skip that additional "л" in the middle).
  2. ideally, meaning of the word should be taken into account. Some words are spelled in both languages same way, but have different meaning. E.x. words "неделя" in Russian and "неділя" in Ukrainian - both of them sounds very similar, but Russian word means "week", while Ukrainian means "Sunday".
  3. similar research can be done for other languages. E.x. how close are Ukrainian and Polish, Ukrainian and Croatian and in the future e.x. Spanish and Portuguese.

Also comparison of dictionaries is not exclusive metric for comparing languages. If you want to improve research you can take grammar rules into account, maybe something else. It feels like a good topic for scientific research. If somebody did it I would like to read about results and see the code.



## Conclusion

A lot of things can be accomplished using simple programming skills. We can get answers for questions that bugged us for years, we can destroy myths and find truths. There is another [research](http://elms.wordpress.com/2008/03/04/lexical-distance-among-languages-of-europe/) that shows that Ukrainian is much closer to Polish than to Russian.
I don't have any formal prove for that but to be honest the result doesn't surprise me. My intuition about "distance" between two languages changed a lot.
Eventually I would like to see open source tool kit that can programmatically calculate distance between any two languages. If you know someone who is working on that - let me know.
