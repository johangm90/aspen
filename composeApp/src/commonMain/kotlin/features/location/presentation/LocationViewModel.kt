package features.location.presentation

import common.UIComponent
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import features.location.domain.LocationRepository
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class LocationViewModel(
    private val locationRepository: LocationRepository,
) : ContainerHost<LocationState, UIComponent>, ViewModel() {
    override val container: Container<LocationState, UIComponent> =
        viewModelScope.container(LocationState())

    fun loadLocation(locationId: Int) {
        intent {
            runCatching {
                reduce { state.copy(isLoading = true) }
                val location = locationRepository.getLocation(locationId)
                reduce { state.copy(location = location, isLoading = false) }
            }.onFailure {
                reduce { state.copy(error = it.message ?: "Unknown error", isLoading = false) }
            }
        }
    }
}