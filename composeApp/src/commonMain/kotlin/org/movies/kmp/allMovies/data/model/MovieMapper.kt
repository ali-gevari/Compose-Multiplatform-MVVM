package org.movies.kmp.allMovies.data.model

import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.util.Constant.IMAGE_BASE_URL

fun List<MovieDto>.mapList() : List<MovieProgram> {
    return this.map {
        MovieProgram (
            id = it.id,
            title = it.title,
            image = IMAGE_BASE_URL + it.posterPath
        )
    }
}