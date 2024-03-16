package features.location.presentation

import features.location.domain.Location

data class LocationState(
    val isLoading: Boolean = false,
    val locations: List<Location> = emptyList(),
    val location: Location? = null,
    val error: String = ""
)
