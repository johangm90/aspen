package features.location.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.baseline_arrow_forward_24
import aspen.composeapp.generated.resources.baseline_star_24
import coil3.compose.AsyncImage
import common.BackButton
import common.ButtonSize
import common.LikeButton
import common.PrimaryButton
import features.location.domain.Location
import features.location.presentation.components.Facility
import features.location.presentation.components.Rating
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LocationContent(
    location: Location,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = location.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .height(340.dp)
                )
                BackButton(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .offset(y = 4.dp)
                ) { onBack() }
                LikeButton(
                    buttonSize = ButtonSize.Large,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(y = 24.dp, x = (-16).dp),
                    isLiked = true
                ) { }
            }
            Spacer(modifier = Modifier.padding(16.dp))
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
            Text(
                text = "Facilities",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(location.facilities.size) { index ->
                    Facility(
                        icon = Res.drawable.baseline_star_24,
                        facility = location.facilities[index]
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Price",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                        )
                    )
                    Text(
                        text = "$${location.price}",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF2DD7A4),
                        )
                    )
                }
                PrimaryButton(
                    text = "Book Now",
                    trailingIcon = {
                        Icon(
                            painter = painterResource(Res.drawable.baseline_arrow_forward_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    onClick = { }
                )
            }
        }
    }
}