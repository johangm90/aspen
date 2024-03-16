package features.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import common.BadgeBox
import common.ButtonSize
import common.LikeButton
import features.home.domain.PopularModel
import features.location.presentation.components.Rating

@Composable
fun PopularItem(
    data: PopularModel,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = 180.dp, height = 240.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = data.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BadgeBox {
                Text(
                    text = data.title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                BadgeBox {
                    Rating(
                        rating = data.rating,
                        iconSize = 16.dp,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                LikeButton(
                    buttonSize = ButtonSize.Small,
                    isLiked = data.isFavorite
                ) { }
            }
        }
    }
}