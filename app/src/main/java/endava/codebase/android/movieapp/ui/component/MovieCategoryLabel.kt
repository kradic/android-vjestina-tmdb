package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    onClick: () -> Unit,
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
    Column(modifier = modifier.width(IntrinsicSize.Max)) {
        if (movieCategoryLabelViewState.isSelected) {
            Text(
                text = text,
                fontSize = 20.sp,
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().clickable { onClick() }
            )
            Box(
                modifier = modifier
                    .height(3.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            )
        } else {
            Text(
                text = text,
                fontSize = 20.sp,
                maxLines = 2,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth().clickable { onClick() }
            )
        }
    }
}

@Preview
@Composable
private fun MovieCategoryPreview() {
    val isChecked = remember { mutableStateOf(false) }

    MovieCategory(
        MovieCategoryLabelViewState(
            itemId = 1,
            isSelected = isChecked.value,
            categoryText = FileRead(textRes = R.string.app_name)
        ),
        onClick = { isChecked.value = !isChecked.value },
    )
}
