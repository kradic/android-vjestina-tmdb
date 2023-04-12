package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

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
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White,
        elevation = 10.dp,
    )
    {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(model = actorCardViewState.imageUrl,
                contentDescription = "Actor",
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1f))
            Spacer(
                modifier = Modifier.height(10.dp))
            Text(
                text = actorCardViewState.name,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            Text(
                text = actorCardViewState.character,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                )
            Spacer(modifier = Modifier.height(10.dp)
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
        ), modifier = Modifier.size(width = 200.dp, height = 330.dp)
    )
}
