package org.movies.kmp.details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import movieskmp.composeapp.generated.resources.Res
import movieskmp.composeapp.generated.resources.cast
import movieskmp.composeapp.generated.resources.crew
import movieskmp.composeapp.generated.resources.genres
import movieskmp.composeapp.generated.resources.production
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.movies.kmp.compose.Banner
import org.movies.kmp.compose.CastCrewCard
import org.movies.kmp.compose.GenreChips
import org.movies.kmp.compose.ProductionCompanyCard
import org.movies.kmp.credits.presentation.CreditsViewState
import org.movies.kmp.util.ProgramType
import org.movies.kmp.util.programTypeToEnum

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun DetailsScreen(
    navController: NavController,
    programId: Int? = 0,
    programType: String? = "",
) {
    val id = remember(programId) { programId ?: 0 }
    val type = remember(programType) { programType ?: "Unknown Type" }.programTypeToEnum()
    val viewModel = koinViewModel<DetailsViewModel>()
    val detailsState by viewModel.detailsState.collectAsState()
    val creditsState by viewModel.creditsState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getDetails(id, type)
    }
    ProgramDetailsContent(
        navController = navController,
        detailsState = detailsState,
        creditsState = creditsState,
        id = id,
        type = type
    )
}

@Composable
fun ProgramDetailsContent(
    navController: NavController,
    detailsState: DetailsViewState,
    creditsState: CreditsViewState,
    id: Int,
    type: ProgramType
) {
    Column {
        Row(
            modifier = Modifier
                .height(80.dp)
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier.size(36.dp),
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = detailsState.details.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 1
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                modifier = Modifier.size(36.dp),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = if (true) // Replace `true` with your condition
                        Icons.Filled.Favorite
                    else
                        Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite Toggle",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        LazyColumn {
            item {
                Banner(url = detailsState.details.backdrop)
            }
            item {
                Text(
                    text = detailsState.details.overview,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                Text(
                    text = stringResource(Res.string.genres),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(detailsState.details.genres) { genre ->
                        GenreChips(genre = genre)
                    }
                }
            }
            item {
                Text(
                    text = stringResource(Res.string.production),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)

                ) {
                    items(detailsState.details.productionCompany) { company ->
                        ProductionCompanyCard(productionCompany = company)
                    }
                }
            }
            item {
                Text(
                    text = stringResource(Res.string.cast),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)

                ) {
                    items(creditsState.credit.cast) { cast ->
                        CastCrewCard(
                            name = cast.originalName, image = cast.profilePath
                        )
                    }
                }
            }
            item {
                Text(
                    text = stringResource(Res.string.crew),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp)

                ) {
                    items(creditsState.credit.crew) { cast ->
                        CastCrewCard(
                            name = cast.originalName, image = cast.profilePath
                        )
                    }
                }
            }
        }
    }
}