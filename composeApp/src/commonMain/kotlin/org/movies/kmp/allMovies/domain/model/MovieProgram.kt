package org.movies.kmp.allMovies.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieProgram(
    val id: Int,
    val title: String,
    val image: String
)