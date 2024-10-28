package org.movies.kmp.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.movies.kmp.search.domain.model.SearchProgram

@Composable
fun SearchCard(
    modifier: Modifier = Modifier,
    program: SearchProgram,
    onClick: (SearchProgram) -> Unit = {}
) {
    Card(
        modifier = modifier
            .size(
                width = 170.dp,
                height = 250.dp
            )
            .clickable { onClick(program) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )
            {
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                )
                Surface(
                    shape = CircleShape,
                    modifier = modifier.align(Alignment.Center)
                ) {
                    CoilImage(
                        imageModel = { program.image },
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        ),
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = program.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = program.programType.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}