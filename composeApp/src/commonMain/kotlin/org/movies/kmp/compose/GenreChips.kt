package org.movies.kmp.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GenreChips(
    modifier: Modifier = Modifier, genre: String
) {
    Box(modifier = modifier) {
        ElevatedAssistChip(
            onClick = { },
            label = {
                Text(
                    text = genre,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        )
    }
}