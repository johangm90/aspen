import androidx.compose.ui.window.ComposeUIViewController
import core.database.DatabaseModule

fun MainViewController() = ComposeUIViewController {
    App(
        databaseModule = DatabaseModule().getDatabaseModule()
    )
}