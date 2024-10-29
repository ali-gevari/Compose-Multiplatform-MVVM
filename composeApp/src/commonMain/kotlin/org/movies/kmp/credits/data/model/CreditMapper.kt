package org.movies.kmp.credits.data.model

import org.movies.kmp.credits.domain.model.Credit
import org.movies.kmp.credits.domain.model.Person
import org.movies.kmp.util.Constant.IMAGE_BASE_URL

fun CreditDto.mapToCredit(): Credit =
    Credit(
        cast = this.cast.mapToCast(),
        crew = this.crew.mapToCrew()
    )

private fun List<CastDto>.mapToCast(): List<Person> {
    return this.map {
        Person(
            id = it.id,
            originalName = it.originalName,
            profilePath = IMAGE_BASE_URL + it.profilePath
        )
    }
}

private fun List<CrewDto>.mapToCrew(): List<Person> {
    return this.map {
        Person(
            id = it.id,
            originalName = it.originalName,
            profilePath = IMAGE_BASE_URL + it.profilePath
        )
    }
}