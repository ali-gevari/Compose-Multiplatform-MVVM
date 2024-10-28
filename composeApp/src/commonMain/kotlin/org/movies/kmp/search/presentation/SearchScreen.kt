package org.movies.kmp.search.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import movieskmp.composeapp.generated.resources.Res
import movieskmp.composeapp.generated.resources.search
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.movies.kmp.compose.SearchCard
import org.movies.kmp.search.domain.model.SearchProgram

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun SearchScreen(
    onItemClick: (SearchProgram) -> Unit
) {
    val viewModel = koinViewModel<SearchViewModel>()
    val state by viewModel.state.collectAsState()
    SearchContent(
        state = state,
        search = viewModel::search,
        onItemClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(
    state: SearchViewState,
    search: (String) -> Unit = {},
    onItemClick: (SearchProgram) -> Unit
) {
    var active by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        Modifier.fillMaxWidth()
    ) {
        DockedSearchBar(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            query = query,
            onQueryChange = {
                query = it
                active = it.isNotEmpty()
            },
            onSearch = {
                keyboard?.hide()
                search(it)
                active = false
            },
            active = false,
            onActiveChange = { active = it },
            placeholder = { Text(stringResource(Res.string.search)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
        ) { }
    }
    AnimatedVisibility(
        visible = state.searchPrograms.isNotEmpty(),
        enter = scaleIn(
            initialScale = 0.5f,
            animationSpec = tween(durationMillis = 500)
        ) + fadeIn(animationSpec = tween(durationMillis = 500)),
        exit = scaleOut(
            targetScale = 0.5f,
            animationSpec = tween(durationMillis = 500)
        ) + fadeOut(animationSpec = tween(durationMillis = 500))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 170.dp),
                modifier = Modifier
                    .padding(vertical = 8.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp
            ) {
                items(state.searchPrograms) { program ->
                    SearchCard(program = program, onClick = onItemClick)
                }
            }
        }
    }
}