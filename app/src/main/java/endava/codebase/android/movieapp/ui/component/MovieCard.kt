package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

data class MovieCardViewState(
    val imageUrl: String?,
    val isFavorite: Boolean,
)

@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = movieCardViewState.imageUrl),
            contentDescription = "Movie",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )
        FavoriteButton(
            isFavorite = movieCardViewState.isFavorite,
            onClick,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    val isChecked = remember { mutableStateOf(false) }
    MovieCard(
        MovieCardViewState(
            imageUrl = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            isFavorite = isChecked.value,
        ),
        onClick = { isChecked.value = !isChecked.value },
        modifier = Modifier.size(width = 200.dp, height = 330.dp)
    )
}
