package ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.montserrat
import aspen.composeapp.generated.resources.montserrat_bold
import aspen.composeapp.generated.resources.montserrat_italic
import aspen.composeapp.generated.resources.montserrat_light
import aspen.composeapp.generated.resources.montserrat_medium
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getTypography(): Typography {
    val monserrat = FontFamily(
        Font(Res.font.montserrat),
        Font(Res.font.montserrat_bold, FontWeight.Bold),
        Font(Res.font.montserrat_italic, FontWeight.Normal),
        Font(Res.font.montserrat_light, FontWeight.Light),
        Font(Res.font.montserrat_medium, FontWeight.Medium)
    )
    return Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    )
}