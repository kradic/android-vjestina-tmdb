package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
)
{
    Surface(
        modifier = modifier
            .background(color = Color.White)
            .clip(shape = RectangleShape),
    )
    {
        Column(
        )
        {
            Text(
                text = crewmanViewState.name,
                fontSize = 20.sp,
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(top = 1.dp, start = 1.dp, end = 5.dp)
            )
            Text(
                text = crewmanViewState.jobTitle,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(start = 1.dp, bottom = 1.dp)
            )
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