package endava.codebase.android.movieapp.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import endava.codebase.android.movieapp.R

sealed class MovieCategoryLabelTextViewState()
class FileRead(val textRes: Int) : MovieCategoryLabelTextViewState()
class TextValue(val text: String) : MovieCategoryLabelTextViewState()

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

@Composable
fun MovieCategory(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    modifier: Modifier = Modifier,
) {
    val text: String = when (movieCategoryLabelViewState.categoryText) {
        is FileRead -> {
            stringResource(movieCategoryLabelViewState.categoryText.textRes)
        }
        is TextValue -> {
            movieCategoryLabelViewState.categoryText.text
        }
    }

    if (movieCategoryLabelViewState.isSelected) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            maxLines = 2,
            fontWeight = FontWeight.Bold,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
    } else {
        Text(text = text, fontSize = 20.sp, maxLines = 2, color = Color.Gray, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
private fun MovieCategoryPreview() {
    MovieCategory(
        MovieCategoryLabelViewState(
            itemId = 1,
            isSelected = true,
            categoryText = FileRead(textRes = R.string.app_name)/*TextValue(text = "Movie")*/
        )
    )
}
