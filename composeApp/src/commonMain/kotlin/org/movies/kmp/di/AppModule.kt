package org.movies.kmp.di

import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.movies.kmp.allMovies.di.allMoviesModules

val appModule = module {
    single { provideClient() }
}

fun initializeKoin() {
    startKoin {
        modules(
            appModule,
            allMoviesModules
        )
    }
}