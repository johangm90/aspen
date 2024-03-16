package features.location.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspen.composeapp.generated.resources.Res
import aspen.composeapp.generated.resources.baseline_star_24
import features.location.presentation.component.Facility
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FacilitiesList(
    facilities: List<String>,
) {
    Column {
        Text(
            text = "Facilities",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(facilities.size) { index ->
                Facility(
                    icon = Res.drawable.baseline_star_24,
                    facility = facilities[index]
                )
            }
        }
    }
}