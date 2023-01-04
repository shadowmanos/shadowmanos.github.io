---
title: Explore data with Java
description: Play with data interactively with a Java REPL, be as cool as the Python kids
draft: false
---

Here I am documenting for my (and hopefully your) benefit, my attempts to use a
Java [REPL](https://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop) for retrieving, processing, and
recording all sorts of data. I am using Java at work, and it's not worth switching to a whole different ecosystem e.g.
Python, or bothering with Intellij/maven/gradle projects for such tasks.

I am using [j'bang](https://github.com/maxandersen/jbang) to start a Java REPL, with installation
instructions [here](https://github.com/maxandersen/jbang#installation). With j'bang we can use a `*.jsh` file with any
dependencies and imports required for a session, so I've prepared one for each blog post. Do have a look at the commands
inside these files, you'll need them to do your own thing after I've inspired you with my posts.

These posts are written in random order based on my daily needs, this isn't some course you have to follow in order.
But, I am doing my best to group them by affinity below:

### Contents

1. [Natural Language Processing]({{< ref "naturalLanguageProcessing" >}})
2. [File reading and writing]({{< ref "processingFiles" >}})
