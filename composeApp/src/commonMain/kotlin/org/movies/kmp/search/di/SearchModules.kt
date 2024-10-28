package org.movies.kmp.search.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.movies.kmp.search.data.remote.SearchApi
import org.movies.kmp.search.data.repository.SearchRepositoryImpl
import org.movies.kmp.search.domain.repository.SearchRepository
import org.movies.kmp.search.domain.useCase.SearchUseCase
import org.movies.kmp.search.presentation.SearchViewModel

val searchModules = module {
    single { SearchApi(get()) }
    single<SearchRepository> { SearchRepositoryImpl(searchApi = get()) }
    single { SearchUseCase(get()) }
    viewModel { SearchViewModel(get()) }
}