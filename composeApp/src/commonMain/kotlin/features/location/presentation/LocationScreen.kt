package features.location.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

        if (state.isLoading) {
            Text("Loading...")
        }
        if (state.error.isNotEmpty()) {
            Text("Error: ${state.error}")
        }

        state.location?.let {
            Scaffold { paddingValues ->
                Box(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    LocationContent(
                        location = it,
                        onBack = { navigator.pop() }
                    )
                }
            }
        }
    }
}