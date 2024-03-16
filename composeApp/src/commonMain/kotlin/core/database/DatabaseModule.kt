package core.database

import org.koin.core.module.Module

expect class DatabaseModule {
    fun getDatabaseModule(): Module
}