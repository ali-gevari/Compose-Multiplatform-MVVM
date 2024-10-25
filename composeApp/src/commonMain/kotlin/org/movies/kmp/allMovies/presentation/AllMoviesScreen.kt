package org.movies.kmp.allMovies.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import movieskmp.composeapp.generated.resources.Res
import movieskmp.composeapp.generated.resources.movies_in_theaters
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.movies.kmp.allMovies.domain.model.MovieProgram
import org.movies.kmp.compose.MovieCard

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun AllMoviesScreen(
    onItemClick: (MovieProgram) -> Unit
) {
    val viewModel = koinViewModel<AllMoviesViewModel>()
    val state by viewModel.state.collectAsState()
    AllMoviesContent(state = state, onItemClick)
}

@Composable
fun AllMoviesContent(
    state: AllMoviesViewState,
    onItemClick: (MovieProgram) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = stringResource(Res.string.movies_in_theaters),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .height(360.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(state.moviePrograms) { program ->
                MovieCard(
                    program = program,
                    onClick = onItemClick
                )
            }
        }
    }
}