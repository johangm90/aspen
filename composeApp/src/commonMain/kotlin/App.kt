import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import di.appModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import features.explore.ExploreScreen
import ui.theme.AspenTheme

@Composable
@Preview
fun App(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    databaseModule: Module
) {
    KoinApplication(application = {
        modules(appModule + databaseModule)
    }) {
        AspenTheme(darkTheme = darkTheme, dynamicColor = dynamicColor) {
            Navigator(ExploreScreen()) { navigator ->
                FadeTransition(navigator = navigator)
            }
        }
    }
}