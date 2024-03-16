package features.home.presentation.view

import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppNavBar(
    navItems: List<String>
) {
    var selectedItem by remember { mutableIntStateOf(0) }
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
                selected = index == selectedItem,
                onClick = { selectedItem = index }
            )
        }
    }
}