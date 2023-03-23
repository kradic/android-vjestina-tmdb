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
    val id: Int,
    val title: String,
    val overview: String,
    val imageUrl: String?,
    val isFavorite: Boolean,
)

@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier.size(width = 200.dp, height = 330.dp)
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = movieCardViewState.imageUrl),
            contentDescription = "Movie",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(200.dp, 220.dp)

        )
        FavoriteButton(isFavorite = movieCardViewState.isFavorite,onCheckedChange)
    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    val isChecked = remember { mutableStateOf(false) }
    MovieCard(
        MovieCardViewState(
            id = 5,
            title = "Spider-Man: No Way Home",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            imageUrl = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            isFavorite = isChecked.value,
        ),
        onCheckedChange = { isChecked.value = it }
    )
}
