package org.movies.kmp.search.data.model

import org.movies.kmp.allMovies.data.model.MovieDto
import org.movies.kmp.allShows.data.model.ShowDto
import org.movies.kmp.search.domain.model.SearchProgram
import org.movies.kmp.util.Constant.IMAGE_BASE_URL
import org.movies.kmp.util.ProgramType

fun List<MovieDto>.mapToSearchProgramList(): List<SearchProgram> {
    return this.map {
        SearchProgram(
            id = it.id,
            title = it.title,
            image = IMAGE_BASE_URL + it.posterPath,
            programType = ProgramType.Movie
        )
    }
}

fun List<ShowDto>.mapToSearchProgramList(): List<SearchProgram> {
    return this.map {
        SearchProgram(
            id = it.id,
            title = it.title,
            image = IMAGE_BASE_URL + it.posterPath,
            programType = ProgramType.TV
        )
    }
}