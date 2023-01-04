---
title: Process file contents line by line
description: Add, remove, modify and process lines of a text or binary file with Java
draft: true
---

### First line

Following on [File operations](fileOperations.md) where we managed whole files, we now want to manage the contents of a
text or binary file with some form of tabular data.
To run these commands make sure you have [installed j'bang](https://github.com/maxandersen/jbang#installation) and then
at your terminal do:

```bash
jbang -i https://raw.githubusercontent.com/shadowmanos/shadowmanos.github.io/main/content/tutorials/processingFiles/fileOperations.jsh
```

For text files this could be a comma separated list of data items in each line (a CSV format). E.g. the actor name,
character name, series abbreviation and number of seasons of first 2 Star Trek Series:

```csv
Patrick Stewart,Jean-Luc Pickard,NG,7
Willian Shatner,James Kirk,TOS,3
```

A binary file could have a known count of known size numbers in each line without delimiters. E.g. The start year 1966,
end year 1967 and number of episodes 29 of first season of Star Trek the Original Series in binary with sizes 16bit,
16bit, 8bit:

```text
00000111 10101110 00000111 10111001 00011101
```

Some text and binary files have been included in this repo for this tutorial. Before next steps a `Path` variable
referring to where you git cloned this repo. Easy way to do the latter in Intellij: go to Project pane on the left,
highlight the root folder of the project (by default _explore-data-with-a-java-repl_), right-click and choose _Copy Path
-> Absolute Path_, then paste within double quotes: `var repoPath = Path.of("")`. You can then get folders with text and
binary files:

```jshelllanguage
var processingFiles = repoPath.resolve("tutorials").resolve("processingFiles")
    var textFolder = processingFiles.resolve("data").resolve("text")
    var binaryFolder = processingFiles.resolve("data").resolve("binary")
```

### Read text file line by line

The simplest things to do is read the whole file in a `String` or a list of `String`

```jshelllanguage
var kirkFile = textFolder.resolve("kirk.txt")
    var kirkText = Files.readString(kirkFile)
    var kirkLines = Files.readAllLines(kirkFile)
```

While these are simple and indeed performant for small files, we may get memory/performance issues with larger files. In
such cases it's preferable to obtain a `Stream` of lines as `String`, and apply a method to each line, and
collect/aggregate:

```jshelllanguage
Files.lines(kirkFile).
    mapToInt(line -> line.length()).
    max().
    getAsInt()
```

That gives us the length of the longest line. The file will be released/closed after completion.

### Read binary file block by block