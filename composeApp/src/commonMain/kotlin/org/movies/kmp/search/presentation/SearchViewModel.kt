package org.movies.kmp.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.movies.kmp.search.domain.useCase.SearchUseCase

class SearchViewModel(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchViewState())
    val state = _state.asStateFlow()

    fun search(query: String) {
        viewModelScope.launch {
            searchUseCase(query)
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
                .collect { searchPrograms ->
                    _state.update {
                        it.copy(searchPrograms = searchPrograms)
                    }
                }
        }
    }
}