package org.movies.kmp.allShows.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.movies.kmp.allShows.domain.useCase.GetAllShowsUseCase

class AllShowsViewModel(
    private val getAllShowsUseCase: GetAllShowsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AllShowsViewState())
    val state = _state.asStateFlow()

    init {
        getAllShows()
    }

    private fun getAllShows() {
        viewModelScope.launch {
            getAllShowsUseCase()
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
                .collect { showPrograms ->
                    _state.update {
                        it.copy(showPrograms = showPrograms)
                    }
                }
        }
    }
}