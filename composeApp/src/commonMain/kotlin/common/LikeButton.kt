package common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.baseline_favorite_24
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LikeButton(
    buttonSize: ButtonSize = ButtonSize.Medium,
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLike: () -> Unit
) {
    val size = when (buttonSize) {
        ButtonSize.Small -> 20.dp
        ButtonSize.Medium -> 32.dp
        ButtonSize.Large -> 48.dp
    }
    val padding = when (buttonSize) {
        ButtonSize.Small -> 4.dp
        ButtonSize.Medium -> 8.dp
        ButtonSize.Large -> 12.dp
    }
    Box(
        modifier = modifier
            .shadow(4.dp, CircleShape)
            .clip(CircleShape)
            .background(Color.White)
            .clickable(onClick = onLike)
    ) {
        Icon(
            painter = if (isLiked) {
                painterResource(Res.drawable.baseline_favorite_24)
            } else {
                painterResource(Res.drawable.baseline_favorite_24)
            },
            tint = if (isLiked) {
                Color.Red
            } else {
                Color.Gray
            },
            contentDescription = null,
            modifier = Modifier
                .size(size)
                .padding(padding)
        )
    }
}

enum class ButtonSize {
    Small, Medium, Large
}