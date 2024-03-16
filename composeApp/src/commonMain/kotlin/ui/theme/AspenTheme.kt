package ui.theme

import androidx.compose.runtime.Composable

@Composable
expect fun AspenTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)