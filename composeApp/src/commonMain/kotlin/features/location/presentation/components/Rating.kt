package features.location.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.baseline_star_24
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Rating(
    rating: Double,
    iconSize: Dp = 24.dp,
    iconTint: Color = Color(0xFFDF9652),
    textStyle: TextStyle = TextStyle.Default,
    numberOfReviews: Int? = null,
    modifier: Modifier = Modifier
) {
    val text = if (numberOfReviews == null) {
        "$rating"
    } else {
        "$rating ($numberOfReviews reviews)"
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.baseline_star_24),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(iconSize)
        )
        Text(
            text = text,
            style = textStyle,
            modifier = modifier.padding(start = 8.dp)
        )
    }
}