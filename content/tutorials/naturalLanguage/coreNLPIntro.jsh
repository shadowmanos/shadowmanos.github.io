//usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA 17+
//DEPS edu.stanford.nlp:stanford-corenlp:4.5.1
//DEPS edu.stanford.nlp:stanford-corenlp:4.5.1:models
//DEPS org.slf4j:slf4j-simple:1.7.30
//DEPS tech.tablesaw:tablesaw-core:0.43.1

import edu.stanford.nlp.simple.*
import tech.tablesaw.api.Table
import tech.tablesaw.api.StringColumn

System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "OFF");
