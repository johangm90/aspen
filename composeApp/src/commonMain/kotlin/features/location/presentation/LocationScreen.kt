package features.location.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.koinInject

data class LocationScreen(
    private val locationId: Int
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: LocationViewModel = koinInject()
        val state by viewModel.container.stateFlow.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.loadLocation(locationId)
        }

        state.location?.let { location ->
            LocationContent(
                location = location,
                onBack = { navigator.pop() }
            )
        }
    }
}