package features.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.cover
import common.presentation.component.PrimaryButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ExploreContent(
    onClickExplore: () -> Unit
) {
    Box() {
        Image(
            painter = painterResource(Res.drawable.cover),
            contentDescription = "Splash",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Aspen",
            style = TextStyle(
                fontSize = 96.sp,
                //fontFamily = FontFamily(Font(Res.font.hiatus)),
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 9.86.sp,
            ),
            modifier = Modifier.align(Alignment.TopCenter).offset(y = 96.dp)
        )
        Column(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterStart).offset(y = 128.dp)
        ) {
            Text(
                text = "Plan your",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                ),
            )
            Text(
                text = "Luxurious\nVacation",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                ),
            )
        }
        PrimaryButton(
            text = "Explore",
            onClick = onClickExplore,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-24).dp)
        )
    }
}