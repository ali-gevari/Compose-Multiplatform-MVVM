package org.movies.kmp.allShows.data.model

import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.util.Constant.IMAGE_BASE_URL

fun List<ShowDto>.mapList() : List<ShowProgram> {
    return this.map {
        ShowProgram (
            id = it.id,
            title = it.title,
            image = IMAGE_BASE_URL + it.posterPath
        )
    }
}