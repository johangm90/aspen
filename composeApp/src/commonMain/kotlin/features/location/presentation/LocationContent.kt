package features.location.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import features.location.domain.Location
import features.location.presentation.view.FacilitiesList
import features.location.presentation.view.FooterSection
import features.location.presentation.view.HeaderSection
import features.location.presentation.view.LocationDetails

@Composable
fun LocationContent(
    location: Location,
    onBack: () -> Unit
) {
    Scaffold(
        bottomBar = {
            FooterSection(
                price = location.price,
                modifier = Modifier.padding(16.dp)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                HeaderSection(
                    imageUrl = location.imageUrl,
                    onLike = { },
                    onBack = onBack
                )
                Spacer(modifier = Modifier.padding(16.dp))
                LocationDetails(location = location)
                FacilitiesList(facilities = location.facilities)
            }
        }
    }
}