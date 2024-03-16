package features.home.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import features.home.presentation.component.CategoryItem

@Composable
fun CategoryList(
    categories: List<String>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Box { }
        }
        items(categories.size) { index ->
            CategoryItem(
                title = categories[index],
                selected = index == 0,
                onClick = {}
            )
        }
        item {
            Box { }
        }
    }
}