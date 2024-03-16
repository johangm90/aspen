package features.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import features.location.presentation.LocationScreen
import org.koin.compose.koinInject

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinInject<HomeViewModel>()
        val state by viewModel.container.stateFlow.collectAsState()

        HomeContent(
            popularItems = state.popularItems,
            recommendedItems = state.recommendedItems,
            onLocationClick = { locationId ->
                navigator.push(LocationScreen(locationId))
            }
        )
    }
}
