package org.movies.kmp.favourites.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import movieskmp.composeapp.generated.resources.Res
import movieskmp.composeapp.generated.resources.favourites
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.movies.kmp.compose.FavouriteCard
import org.movies.kmp.favourites.domain.model.FavouriteProgram

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun FavouritesScreen(
    padding: PaddingValues,
    onItemClick: (FavouriteProgram) -> Unit
) {
    val viewModel = koinViewModel<FavouritesViewModel>()
    val state by viewModel.state.collectAsState()
    FavouritesContent(padding = padding, state = state, onItemClick)
}

@Composable
fun FavouritesContent(
    padding: PaddingValues,
    state: FavouritesViewState,
    onItemClick: (FavouriteProgram) -> Unit
) {
    Column(
        modifier = Modifier.padding(top = padding.calculateTopPadding())
    ) {
        Text(
            text = stringResource(Res.string.favourites),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp)
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 170.dp),
            modifier = Modifier
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp
        ) {
            items(state.allFavourites) { program ->
                FavouriteCard(program = program, onClick = onItemClick)
            }
        }
    }
}