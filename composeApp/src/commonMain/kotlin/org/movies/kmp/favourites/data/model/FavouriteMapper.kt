package org.movies.kmp.favourites.data.model

import org.movies.kmp.allMovies.data.model.MovieDto
import org.movies.kmp.allShows.data.model.ShowDto
import org.movies.kmp.favourites.domain.model.FavouriteProgram
import org.movies.kmp.util.Constant.IMAGE_BASE_URL
import org.movies.kmp.util.ProgramType

fun List<MovieDto>.mapMoviesToFavouriteProgram(): List<FavouriteProgram> = map { movie ->
    FavouriteProgram(
        id = movie.id,
        title = movie.title,
        image = IMAGE_BASE_URL + movie.posterPath,
        programType = ProgramType.Movie
    )
}

fun List<ShowDto>.mapShowsToFavouriteProgram(): List<FavouriteProgram> = map { show ->
    FavouriteProgram(
        id = show.id,
        title = show.title,
        image = IMAGE_BASE_URL + show.posterPath,
        programType = ProgramType.TV
    )
}