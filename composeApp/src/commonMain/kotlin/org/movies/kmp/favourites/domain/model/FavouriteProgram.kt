package org.movies.kmp.favourites.domain.model

import org.movies.kmp.util.ProgramType

data class FavouriteProgram(
    val id: Int,
    val title: String,
    val image: String,
    val programType: ProgramType
)