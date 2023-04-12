package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class CrewmanViewState(
    val id: Int,
    val name: String,
    val jobTitle: String,
)

@Composable
fun CrewmanView(
    crewmanViewState: CrewmanViewState,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = RectangleShape,
        color = Color.White,
        modifier = modifier
    ) {
        Column {
            Text(
                text = crewmanViewState.name,
                fontSize = 20.sp,
                maxLines = 2,
                fontWeight = FontWeight.Bold
            )
            Text(text = crewmanViewState.jobTitle, fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Preview
@Composable
private fun CrewmanPreview() {
    CrewmanView(
        CrewmanViewState(
            id = 1,
            name = "Jon Favreau",
            jobTitle = "Director"
        )
    )
}
