package features.home.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import features.home.domain.PopularModel
import features.home.presentation.component.PopularItem

@Composable
fun PopularList(
    popularItems: List<PopularModel>,
    onLocationClick: (locationId: Int) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
                onClick = { },
            ) {
                Text(
                    text = "See all",
                    fontSize = 12.sp
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Box {}
            }
            items(popularItems.size) { index ->
                PopularItem(
                    data = popularItems[index],
                    onClick = { onLocationClick(popularItems[index].id) }
                )
            }
            item {
                Box {}
            }
        }
    }
}