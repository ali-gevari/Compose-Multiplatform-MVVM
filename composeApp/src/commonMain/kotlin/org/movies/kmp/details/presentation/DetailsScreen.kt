package org.movies.kmp.details.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

@Composable
internal fun DetailsScreen(
    programId: Int? = 0
) {

    val id = remember(programId) { programId ?: "Unknown ID" }

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Text(id.toString())
    }
}