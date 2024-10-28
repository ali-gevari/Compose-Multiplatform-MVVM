package org.movies.kmp.search.domain.model

import kotlinx.serialization.Serializable
import org.movies.kmp.util.ProgramType

@Serializable
data class SearchProgram(
    val id: Int,
    val title: String,
    val image: String,
    val programType: ProgramType
)