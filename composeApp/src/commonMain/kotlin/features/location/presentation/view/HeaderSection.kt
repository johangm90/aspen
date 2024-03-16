package features.location.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import common.presentation.component.BackButton
import common.presentation.component.ButtonSize
import common.presentation.component.LikeButton

@Composable
fun HeaderSection(
    imageUrl: String,
    onLike: () -> Unit,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = imageUrl,
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
        ) { onLike() }
    }
}