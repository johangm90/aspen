package features.home.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import common.presentation.component.LocationButton

@Composable
fun HeaderSection(
    onLocationClick: (locationId: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column {
            Text(
                text = "Explore",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            )
            Text(
                text = "Aspen",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(500),
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        LocationButton("Aspen, USA") { }
    }
}