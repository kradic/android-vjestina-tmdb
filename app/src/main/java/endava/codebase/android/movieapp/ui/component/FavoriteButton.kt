package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import endava.codebase.android.movieapp.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Box(contentAlignment = Alignment.TopStart) {
        Box(contentAlignment = Alignment.Center) {
            Checkbox(
                checked = isFavorite,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.alpha(0f)
            )
            Image(
                painterResource(if (isFavorite) R.drawable.favorite_full else R.drawable.favorite_empty),
                contentDescription = "Full/empty heart",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    val isChecked = remember { mutableStateOf(true) }

    FavoriteButton(isFavorite = isChecked.value, onCheckedChange = { isChecked.value = it })
}