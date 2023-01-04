---
title: Play with Stanford CoreNLP's Simple API
description: English grammar with Java instead of a universal translator
draft: false
---

### Core what now?

[CoreNLP](https://stanfordnlp.github.io/CoreNLP/) is a Natural Language Processing library written in Java by some
lovely people at Stanford University and available under a GPL or commercial license. You can build Java applications
with it, use it through a REST API from any language or invoke through your OS command line. CoreNLP recently introduced
an alternative [Simple API](https://stanfordnlp.github.io/CoreNLP/simple.html) which is simple and concise and ideal for
a REPL.
To run these commands make sure you have [installed j'bang](https://github.com/maxandersen/jbang#installation) and then
at your terminal do:

```bash
jbang -i https://github.com/shadowmanos/shadowmanos.github.io/blob/main/content/tutorials/naturalLanguage/coreNLPIntro.jsh
```

### Documents, sentences and words

Let's start by creating
a [Document](https://nlp.stanford.edu/nlp/javadoc/javanlp/index.html?edu/stanford/nlp/simple/Document.html) with
appropriate sample text for starting our journey.

```jshelllanguage
var text = new Document("Space: the final frontier. These are the voyages of the starship Enterprise. Its continuing mission: to explore strange new worlds, to seek out new life and new civilizations, to boldly go where no one has gone before!")
```

The simplest processing we can do here is split the document
into [sentences](https://nlp.stanford.edu/nlp/javadoc/javanlp/index.html?edu/stanford/nlp/simple/Sentence.html) and a
sentence into words. Note that it splits documents on punctuation like '.' and '!' if followed by a space, and it
retains the punctuation in the resulting sentences. It doesn't split on ',' or ':'. It splits sentences to words on
whitespace and includes punctuation marks as words. With CoreNLP we can usually get a list of results with the plural
form of a method e.g. `sentences()` or get a specific element with the singular form, and a 0-based index
e.g. `sentence(1)`. Try:

```jshelllanguage
text.sentences().size()
```

```text
3
```

and

```jshelllanguage
var sentence = text.sentence(1)
```

We'll use the `sentence` variable later.

```jshelllanguage
sentence.word(1)
```

```text
are
```

### Lemmas

While speaking, we don't always use the basic, root form of a word like "go" but other grammatically appropriate forms
like "goes" or "went". The basic, root form is called [lemma](https://simple.wikipedia.org/wiki/Lemma_(linguistics)),
and it's obvious from this example we can't always just take a substring of a word to find a lemma. We can easily find
lemmas with CoreNLP with the `lemma()` method. For example the lemma of "are", second word of second sentence is "be":

```jshelllanguage
sentence.lemma(1)
```

```text
be
```

To get the lemma of a single word make a sentence out of it e.g.

```jshelllanguage
new Sentence("went").lemma(0)
```

```text
go
```

### Parts of speech

CoreNLP will do its best to guess whether a word is a verb, noun, adjective etc. That is a **P**art **O**f **S**peech
tag and you can learn more about these [here](https://en.wikipedia.org/wiki/Part_of_speech) and see a neat list of
potential tags at [Penn tree bank](https://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html). You
loved grammar at school didn't you? To get POS tags for all words in the second sentence:

```jshelllanguage
sentence.posTags()
```

```text
[DT, VBP, DT, NNS, IN, DT, NNP, NNP, .]
```

The POS tags are in the same order as words in the sentence, which can be confusing. So lets print words and their tags
in pairs. A nice library for that purpose is [Tablesaw](https://jtablesaw.github.io/tablesaw/gettingstarted) and has
been included for your convenience  :

```jshelllanguage
Table.create("\n").
    addColumns(
        StringColumn.create("Words", sentence.words()),
        StringColumn.create("POS tags", sentence.posTags()))
```

```text
   Words     |  POS tags  |
---------------------------
      These  |        DT  |
        are  |       VBP  |
        the  |        DT  |
    voyages  |       NNS  |
         of  |        IN  |
        the  |        DT  |
   starship  |       NNP  |
 Enterprise  |       NNP  |
          .  |         .  |

```

### Graphs of word relationships

Now that we know that "final" is an adjective and "frontier" a noun, we'd like to know the relationships between words,
that the adjective "final" modifies the noun "frontier" specifically in the sentence.
A [Parse Tree](https://en.wikipedia.org/wiki/Parse_tree) is a good way to represent these relationships. With CoreNLP we
get the constituency parse tree by calling the `parse()` method on a sentence.

```jshelllanguage
sentence.parse().pennPrint()
```

```text
(ROOT
  (S
    (NP (DT These))
    (VP (VBP are)
      (NP
        (NP (DT the) (NNS voyages))
        (PP (IN of)
          (NP (DT the) (NNP starship) (NNP Enterprise)))))
    (. .)))
```

The output includes the words in original text, their POS tags for terminal (leaf) nodes and non terminal categories
like VP (verb phrase) or NP (noun phrase) for non terminal (non leaf) nodes.
Check [here](https://en.wikipedia.org/wiki/Parse_tree)) for meaning of VP, NP etc.

We may also obtain a [Semantic Dependency](https://en.wikipedia.org/wiki/Dependency_grammar#Semantic_dependencies) graph
of a sentence:

```jshelllanguage
sentence.dependencyGraph()
```

```text
-> voyages/NNS (root)
  -> These/DT (nsubj)
  -> are/VBP (cop)
  -> the/DT (det)
  -> Enterprise/NNP (nmod:of)
    -> of/IN (case)
    -> the/DT (det)
    -> starship/NNP (compound)
  -> ./. (punct)
```

For each node we get the original word, the POS tag and a relation according
to [Universal Dependency v1](http://universaldependencies.org/docsv1/u/dep/all.html)

### Coreference Resolution

In some sentences or documents two different words may refer to the same entity. CoreNLP can
perform [Coreference Resolution](https://en.wikipedia.org/wiki/Coreference#Coreference_resolution) by calling `coref()`
on a `Document` or `Sentence`. Unfortunately coreference resolution is a challenging task and algorithms are not as
accurate as POS tagging or parsing. This shows some failed and some successful resolutions:

```jshelllanguage
new Document("To all Starfleet personel, this is the Captain. It is my sad duty to inform you that a member of the crew, Ensign Sito Jaxa has been lost in the line of duty. She was the finest example of a Starfleet officer and a young woman of remarkable courage and strength of character. Her loss will be deeply felt by all who knew her. Picard out.").coref()
```

```text
{5=CHAIN5-["this" in sentence 1, "It" in sentence 2], 23=CHAIN23-["She" in sentence 3, "Her" in sentence 4, "her" in sentence 4]}
```

CHAIN4 is maybe wrong as I am not sure "this" and "It" refer to the same thing. The other chain is incomplete, as "
Ensign Sito Jaxa", "member" should be in the chain. And it missed a chain with "Captain", "my" and "Picard".

### Named Entity Recognition

Apart from words like verbs and nouns a sentence may contain named entities that we should identify to extract useful
information from our text. [Named Entity Recognition](https://en.wikipedia.org/wiki/Named-entity_recognition) may be
unsuccessful if the entity, and the related word are missing from
the [corpus](https://en.wikipedia.org/wiki/Text_corpus) used to train the model the NER tagging algorithm is using. For
English, the algorithm depends a lot on the first letter being uppercase. CoreNLP performs NER tagging by calling
the `nerTags` method:

```jshelllanguage
var iAmCaptain = new Sentence("I'm Captain Jean-Luc Picard, of the Federation Starship Enterprise")

    Table.create("\n").
        addColumns(
            StringColumn.create("Words", iAmCaptain.words()),
            StringColumn.create("NER tags", iAmCaptain.nerTags()))
```

```text
      Words     |    NER tags    |
-------------------------------
          I  |             O  |
         'm  |             O  |
    Captain  |         TITLE  |
       Jean  |        PERSON  |
          -  |        PERSON  |
        Luc  |        PERSON  |
     Picard  |        PERSON  |
          ,  |             O  |
         of  |             O  |
        the  |             O  |
 Federation  |  ORGANIZATION  |
   Starship  |  ORGANIZATION  |
 Enterprise  |  ORGANIZATION  |
```

The current tokenizer in CoreNLP splits the captain's name in 4 words "Jean", "-", "Luc" and "Picard", hence 4 _PERSON_
tags. "Starship" is probably more of a VEHICLE than an ORGANIZATION, so the training corpus probably didn't contain this
term. "Captain" would still be identified as "TITLE" even if it was typed as "captain". Another example:

```jshelllanguage
var ensignSito = new Sentence("Ensign Sito Jaxa has been lost in the line of duty")

    Table.create("\n").
        addColumns(
            StringColumn.create("Words", ensignSito.words()),
            StringColumn.create("NER tags", ensignSito.nerTags()))
```

```text
 Words   |  NER tags  |
-----------------------
 Ensign  |    PERSON  |
   Sito  |    PERSON  |
   Jaxa  |    PERSON  |
    has  |         O  |
   been  |         O  |
   lost  |         O  |
     in  |         O  |
    the  |         O  |
   line  |         O  |
     of  |         O  |
   duty  |         O  |
```

Here it successfully recognized "Sito" and "Jaxa" as names of a person despite these names probably being imaginary.

### Sentiment Analysis

This is a text categorisation task, an estimate if a sentence conveys a positive, negative or neutral sentiment. The
underlying model used by CoreNLP is based on movie reviews. If a sentence pertains to a different domain, with different
vocabulary or is rather nuanced, results can be very inaccurate. We get the sentiment of a sentence by calling
the `sentiment` method:

```jshelllanguage
new Sentence("The war is going very badly for the Federation... far worse than is generally known").sentiment()
```

```text
NEGATIVE
```

Some other examples, with (maybe) debatable results:

```jshelllanguage
var sentences = List.of(
    "Live long and prosper",
    "It's dead Jim",
    "We seek peaceful coexistence",
    "It's a good day to die")

    var sentiments = sentences.stream().
        map(Sentence::new).
        map(Sentence::sentiment).
        map(SentimentClass::toString).
        toList()

    Table.create("\n").
        addColumns(
            StringColumn.create("Senntence", sentences),
            StringColumn.create("Sentiment", sentiments))
```

```text
          Senntence            |  Sentiment  |
----------------------------------------------
        Live long and prosper  |    NEUTRAL  |
                It's dead Jim  |   NEGATIVE  |
 We seek peaceful coexistence  |    NEUTRAL  |
       It's a good day to die  |    NEUTRAL  |
```