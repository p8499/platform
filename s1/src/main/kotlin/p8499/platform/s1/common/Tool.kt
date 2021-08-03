package p8499.platform.s1.common

fun String.escapeSQL() = replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%")
