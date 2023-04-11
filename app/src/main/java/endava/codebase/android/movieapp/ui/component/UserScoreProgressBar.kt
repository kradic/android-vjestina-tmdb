package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScoreProgressBar(
    grade: Float,
    size: Int,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    )
    {
        val tempGrade: String = grade.toString()
        Text(
            text = tempGrade,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = (size / 5).sp
        )
        Canvas(modifier = Modifier
            .offset(x = 10.dp, y = 10.dp)) {
            drawArc(
                color = Color(android.graphics.Color.parseColor("#ccffcc")),
                startAngle = 180f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 12.dp.toPx()),
                size = Size(width = (size - 20).dp.toPx(), height = (size - 20).dp.toPx())
            )
            drawArc(
                color = Color.Green,
                startAngle = 180f,
                sweepAngle = (grade / 10) * -360,
                useCenter = false,
                style = Stroke(width = 12.dp.toPx()),
                size = Size(width = (size - 20).dp.toPx(), height = (size - 20).dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun UserScoreProgressBarPreview() {
    val size: Int = 100
    UserScoreProgressBar(
        grade = 7.5f,
        size = size,
        modifier = Modifier
            .size(size = size.dp)
    )
}
