package org.movies.kmp.util

fun String.programTypeToEnum(): ProgramType = enumValues<ProgramType>().find {
    it.name.equals(this, ignoreCase = true)
} ?: ProgramType.Unknown