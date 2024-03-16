package features.location.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import features.location.domain.Location
import features.location.presentation.component.Rating

@Composable
fun LocationDetails(
    location: Location
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = location.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                )
            )
            TextButton(
                onClick = { }
            ) {
                Text("Show map")
            }
        }
        Rating(rating = location.rating, numberOfReviews = location.reviewCount)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "${location.description}...",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(450),
                color = Color(0xFF3A544F),
            )
        )
        TextButton(
            onClick = { }
        ) {
            Text(
                text = "Read more",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                )
            )
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
    }
}