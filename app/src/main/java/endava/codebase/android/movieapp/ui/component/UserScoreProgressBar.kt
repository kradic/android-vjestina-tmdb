package endava.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScoreProgressBar(grade: Float) {
    Box(contentAlignment = Alignment.Center)
    {
        val tempGrade: String = grade.toString()
        Text(text = tempGrade, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
        ) {
            drawArc(
                color = Color(android.graphics.Color.parseColor("#ccffcc")),
                startAngle = 180f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset(x = 10.dp.toPx(), y = 10.dp.toPx()),
                style = Stroke(width = 12.dp.toPx()),
                size = Size(width = 80.dp.toPx(), height = 80.dp.toPx()),
            )
            drawArc(
                color = Color.Green,
                startAngle = 180f,
                sweepAngle = (grade / 10) * -360,
                useCenter = false,
                topLeft = Offset(x = 10.dp.toPx(), y = 10.dp.toPx()),
                style = Stroke(width = 12.dp.toPx()),
                size = Size(width = 80.dp.toPx(), height = 80.dp.toPx()),
            )
        }
    }
}

@Preview
@Composable
private fun UserScoreProgressBarPreview(){
    UserScoreProgressBar(grade = 7.5f)
}
