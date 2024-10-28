package org.movies.kmp.allShows.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ShowProgram(
    val id: Int,
    val title: String,
    val image: String
)