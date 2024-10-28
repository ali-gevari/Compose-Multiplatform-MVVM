package org.movies.kmp.allShows.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import movieskmp.composeapp.generated.resources.Res
import movieskmp.composeapp.generated.resources.airing_tv_series
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.movies.kmp.allShows.domain.model.ShowProgram
import org.movies.kmp.compose.ShowCard

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun AllShowsScreen(
    onItemClick: (ShowProgram) -> Unit
) {
    val viewModel = koinViewModel<AllShowsViewModel>()
    val state by viewModel.state.collectAsState()
    AllShowsContent(state = state, onItemClick)
}

@Composable
fun AllShowsContent(
    state: AllShowsViewState,
    onItemClick: (ShowProgram) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = stringResource(Res.string.airing_tv_series),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier
                .padding(vertical = 8.dp)
                .height(220.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.showPrograms) { showProgram ->
                ShowCard(
                    program = showProgram,
                    onClick = onItemClick
                )
            }
        }
    }
}