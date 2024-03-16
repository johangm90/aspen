package features.home.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import features.home.domain.RecommendedModel
import features.home.presentation.component.RecommendedItem

@Composable
fun RecommendedList(
    recommendedItems: List<RecommendedModel>
) {
    Text(
        text = "Recommended",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.padding(16.dp)
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box {}
        }
        items(recommendedItems.size) { index ->
            RecommendedItem(
                data = recommendedItems[index],
                onClick = {}
            )
        }
        item {
            Box {}
        }
    }
}