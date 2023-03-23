package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

data class ActorCardViewState(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,
)
{
    Card(
        Modifier
            .size(width = 200.dp, height = 330.dp)
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
        elevation = 10.dp
        )
        {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.height(160.dp).background(Color.White)
            )
            {
                Image(
                    painter = rememberAsyncImagePainter(model = actorCardViewState.imageUrl),
                    contentDescription = "Actor",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                                .height(220.dp)
                                .fillMaxWidth()
                )
                Text(
                    text = actorCardViewState.name,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 50.dp)
                )
                Text(
                    text = actorCardViewState.character,
                    textAlign = TextAlign.Left,
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, end = 20.dp),
                )
            }
        }
}

@Preview
@Composable
private fun ActorCardPreview() {
    ActorCard(
        ActorCardViewState(
        id = 1,
        name = "Robert Downey Jr.",
        character = "Tony Stark/Iron Man",
        imageUrl = "https://www.themoviedb.org/t/p/w200/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"
    ))
}