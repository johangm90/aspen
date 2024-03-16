package com.jgm90.aspen

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import core.database.DatabaseModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true,
                databaseModule = DatabaseModule(this).getDatabaseModule()
            )
        }
    }
}