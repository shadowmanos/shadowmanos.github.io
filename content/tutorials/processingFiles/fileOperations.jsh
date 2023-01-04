//usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA 17+
//DEPS tech.tablesaw:tablesaw-core:0.43.1
//DEPS one.util:streamex:0.8.1

import tech.tablesaw.api.Table
import tech.tablesaw.api.StringColumn
import one.util.streamex.*
import static java.util.stream.Collectors.*