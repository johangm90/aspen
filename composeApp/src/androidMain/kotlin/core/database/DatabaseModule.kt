package core.database

import android.content.Context
import com.jgm90.aspen.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual class DatabaseModule(private val context: Context) {
    actual fun getDatabaseModule(): Module = module {
        single {
            AppDatabase(
                driver = DriverFactory(
                    context = context
                ).createDriver()
            )
        }
    }
}