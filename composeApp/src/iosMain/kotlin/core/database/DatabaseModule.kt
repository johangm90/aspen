package core.database

import com.jgm90.aspen.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual class DatabaseModule {
    actual fun getDatabaseModule(): Module = module {
        single { AppDatabase(driver = DriverFactory().createDriver()) }
    }
}