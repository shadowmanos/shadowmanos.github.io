---
title: File operations
description: Find, copy, move/rename and delete files with Java
draft: false
---

### Pre-filing

We'll see some simple one line examples on operations on files themselves without modifying contents. We'll just use
standard Java classes.
To run these commands make sure you have [installed j'bang](https://github.com/maxandersen/jbang#installation) and then
at your terminal do:

```bash
jbang -i https://github.com/shadowmanos/explore-data-with-java/blob/master/tutorials/processingFiles/fileOperations.jsh
```

### List folders and files

First step is always to create
a [Path](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Path.html) that represents a path to
a file or folder, and in many ways supersedes the
older [File](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html) class. To create one from
scratch, pass a `String` with the path. E.g. to make a `Path` out of your home folder:

```jshelllanguage
var home = Path.of(System.getProperty("user.home"))
```

The following will list names of all non-hidden files only in your home folder without going into subfolders (we are
making use of [StreamEx](https://github.com/amaembo/streamex)):

```jshelllanguage
StreamEx.of(Files.walk(home, 1)).
    map(Path::toFile).
    filter(File::isFile).
    remove(File::isHidden).
    map(File::getName).
    toList()
``` 

[walk()](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Files.html#walk(java.nio.file.Path,int,java.nio.file.FileVisitOption...))
will traverse (depth-first) the path going into folders up to the specified depth. 1 means only current folder.

To recursively search for files by name, try the following:

```jshelllanguage
var someFile = StreamEx.of(Files.walk(home)).
    map(Path::toFile).
    filter(File::isFile).
    filterBy(File::getName, "someText.txt").
    findFirst().
    get()
```

Note that with `first()` you can get a new `Path` representing a folder, and use it as a basis for future searches:

```jshelllanguage
var pictures = StreamEx.of(Files.walk(home, 1)).
    map(Path::toFile).
    filter(File::isDirectory).
    filterBy(File::getName, "Pictures").
    findFirst().
    map(File::toPath).
    get()
```

You may list files in the "Pictures" folder (that we found above), sorted by when they were last modified, like this:

```jshelllanguage
StreamEx.of(Files.walk(pictures, 1)).
    map(Path::toFile).
    filter(File::isFile).
    sortedBy(File::lastModified).
    toList()
```

We may want to filter files per the parent folder. For example, count Java source files ignoring files containing tests,
in a multi-project source code folder. These will be in subfolders of more than one folder named `src/main/java` (
slashes may be the other way around in other operating systems).

```jshelllanguage
StreamEx.of(Files.walk(home)).
    map(Path::toFile).
    filter(File::isFile).
    filter(f -> f.getAbsolutePath().contains("src/main/java")).
    filter(f -> f.getName().endsWith(".java")).
    count()
```

Another useful op would be to find duplicates across different folders by name:

```jshelllanguage
var fileCounts = StreamEx.of(Files.walk(home)).
    map(Path::toFile).
    filter(File::isFile).
    groupingBy(File::getName, counting())
    var duplicates = EntryStream.of(fileCounts).
        filterValues(count -> count > 1).
        keys().
        toList()
```

### Size matters

To get the size of a file in bytes:

```jshelllanguage
someFile.length()
```

The above is not useful for folders. To get the size of all files in a folder we need to iterate over them:

```jshelllanguage
StreamEx.of(Files.walk(pictures, 1)).
    map(Path::toFile).
    filter(File::isFile).
    mapToLong(File::length).
    sum()
```

From any file, you can get usage and size information for the whole disk:

```jshelllanguage
someFile.getFreeSpace()
    someFile.getUsableSpace()
    someFile.getTotalSpace()
```

Expect usable space to be less than free space

### Modify files

To create a new empty folder:

```jshelllanguage
var someFolder = pictures.resolve("someFolder")
    someFolder.toFile().mkdir()
```

To create a new empty file:

```jshelllanguage
var someText = someFolder.resolve("someText.txt").toFile()
    someText.createNewFile()
```

you can chain two `resolve` calls, but you have to create a folder before creating a file within it.

We can rename and/or move a file by:

```jshelllanguage
var movedFile = pictures.resolve("someFileMovedToDocs.txt").toFile()
    someText.renameTo(movedFile)
```

This method takes a `File` argument and since the file is under a different folder, it was moved as well as renamed. So
it's similar to Unix [mv](https://en.wikipedia.org/wiki/Mv) command. If you now type `someText` to inspect the variable,
you'll see it still refers to the original path `$HOME/Pictures/someFolder/someText.txt` that no longer exists.
Consequently, if you try to rename `someText` again it will fail and return `false`. We can re-create this file if we
want, in the original folder, with the same command as above.

If we wanted to copy instead, keeping the original file:

```jshelllanguage
var copiedFile = Files.copy(someText.toPath(), someFolder.resolve("copyOfSomeText.txt")).toFile()
```

If you regret copying the file, to get rid of it:

```jshelllanguage
copiedFile.delete()
```
