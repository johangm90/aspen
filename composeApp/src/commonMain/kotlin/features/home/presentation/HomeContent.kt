package features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.presentation.component.SearchField
import features.home.domain.PopularModel
import features.home.domain.RecommendedModel
import features.home.presentation.view.AppNavBar
import features.home.presentation.view.CategoryList
import features.home.presentation.view.HeaderSection
import features.home.presentation.view.PopularList
import features.home.presentation.view.RecommendedList

@Composable
fun HomeContent(
    popularItems: List<PopularModel>,
    recommendedItems: List<RecommendedModel>,
    onLocationClick: (locationId: Int) -> Unit
) {
    val navItems = listOf("Home", "Tickets", "Favorites", "Profile")
    Scaffold(
        bottomBar = {
            AppNavBar(navItems = navItems)
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(it)
        ) {
            HeaderSection(onLocationClick = onLocationClick)
            SearchField(
                onSearch = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            val categories = listOf("Location", "Hotels", "Food", "Adventure", "Events")
            CategoryList(categories)
            PopularList(popularItems, onLocationClick)
            RecommendedList(recommendedItems)
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}