package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import endava.codebase.android.movieapp.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(if (isFavorite) R.drawable.favorite_full else R.drawable.favorite_empty),
        contentDescription = "Full/Empty heart",
        contentScale = ContentScale.Crop,
        modifier = modifier.clickable { onClick() }
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    var isFavorite = remember { mutableStateOf(false) }
    FavoriteButton(
        isFavorite = isFavorite.value,
        onClick = { isFavorite.value = !isFavorite.value })
}
