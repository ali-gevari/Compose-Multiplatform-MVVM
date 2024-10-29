package org.movies.kmp.credits.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Credit(
    val cast: List<Person>,
    val crew: List<Person>,
)

@Serializable
data class Person(
    val id: Int,
    val originalName: String,
    val profilePath: String
)