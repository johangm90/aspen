package features.explore

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import features.home.presentation.HomeScreen

class ExploreScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        ExploreContent(
            onClickExplore = {
                navigator.push(HomeScreen())
            }
        )
    }
}
