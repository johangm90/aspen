package features.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import common.BadgeBox
import features.home.domain.RecommendedModel

@Composable
fun RecommendedItem(
    data: RecommendedModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(164.dp)
            .shadow(1.dp, RoundedCornerShape(16.dp))
            .border(4.dp, Color(0xFFF4F4F4), RoundedCornerShape(16.dp))
            .background(Color.White)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = data.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 160.dp, height = 90.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(
                text = data.title,
                style = TextStyle(
                    color = Color(0xFF232323),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = null,
                    tint = Color(0xFF84ABE4),
                )
                Text(
                    text = "Hot Deal",
                    style = TextStyle(
                        color = Color(0xFF3A544F),
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400)
                    )
                )
            }
        }
        BadgeBox(
            color = Color(0xFF3A544F),
            border = BorderStroke(2.dp, Color.White),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = (-16).dp, y = 12.dp)
        ) {
            Text(
                text = data.duration,
                color = Color.White,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600)
                )
            )
        }
    }
}