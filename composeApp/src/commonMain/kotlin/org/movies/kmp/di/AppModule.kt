package org.movies.kmp.di

import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.movies.kmp.accountStates.di.accountStatesModules
import org.movies.kmp.allMovies.di.allMoviesModules
import org.movies.kmp.allShows.di.allShowsModules
import org.movies.kmp.credits.di.creditsModules
import org.movies.kmp.details.di.detailsModules
import org.movies.kmp.favourites.di.favouritesModules
import org.movies.kmp.search.di.searchModules
import org.movies.kmp.toggleFavourite.di.toggleFavouriteModules

val appModule = module {
    single { provideClient() }
}

fun initializeKoin() {
    startKoin {
        modules(
            appModule,
            allMoviesModules,
            allShowsModules,
            searchModules,
            detailsModules,
            creditsModules,
            accountStatesModules,
            toggleFavouriteModules,
            favouritesModules
        )
    }
}