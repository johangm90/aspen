package features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.LocationButton
import common.SearchField
import features.home.domain.PopularModel
import features.home.domain.RecommendedModel
import features.home.presentation.components.CategoryItem
import features.home.presentation.components.PopularItem
import features.home.presentation.components.RecommendedItem

@Composable
fun HomeContent(
    popularItems: List<PopularModel>,
    recommendedItems: List<RecommendedModel>,
    onLocationClick: (locationId: Int) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navItems = listOf("Home", "Tickets", "Favorites", "Profile")
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .shadow(2.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            ) {
                navItems.forEachIndexed { index, title ->
                    val icon = when (title) {
                        "Home" -> Icons.Default.Home
                        "Tickets" -> Icons.Default.Email
                        "Favorites" -> Icons.Default.Favorite
                        "Profile" -> Icons.Default.Person
                        else -> error("Invalid title")
                    }
                    NavigationBarItem(
                        icon = { Icon(icon, contentDescription = null) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = Color(0xFFB8B8B8),
                            indicatorColor = Color.Transparent
                        ),
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Column {
                    Text(
                        text = "Explore",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                        )
                    )
                    Text(
                        text = "Aspen",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight(500),
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                LocationButton("Aspen, USA") { }
            }
            SearchField(
                onSearch = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            val categories = listOf("Location", "Hotels", "Food", "Adventure", "Events")
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
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}