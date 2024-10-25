package org.movies.kmp.allMovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.movies.kmp.allMovies.domain.useCase.GetAllMoviesUseCase

class AllMoviesViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AllMoviesViewState())
    val state = _state.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            getAllMoviesUseCase()
                .onStart {
                    _state.update {
                        it.copy(isLoading = true)
                    }
                }
                .catch { error ->
                    _state.update {
                        it.copy(error = error.message)
                    }
                }
                .onCompletion {
                    _state.update {
                        it.copy(isLoading = false)
                    }
                }
                .collect { moviePrograms ->
                    _state.update {
                        it.copy(moviePrograms = moviePrograms)
                    }
                }
        }
    }
}