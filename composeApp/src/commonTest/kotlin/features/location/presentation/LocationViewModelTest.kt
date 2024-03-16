package features.location.presentation

import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.mock
import features.location.domain.LocationRepository
import kotlinx.coroutines.test.runTest
import mock.locationMock
import org.orbitmvi.orbit.test.test
import kotlin.test.Test

class LocationViewModelTest {
    private val locationRepository: LocationRepository = mock()
    private val locationViewModel = LocationViewModel(locationRepository)
    private val singleLocation = locationMock

    @Test
    fun `loadLocation updates state with loading and then with location when successful`() =
        runTest {
            val id = 1
            everySuspend { locationRepository.getLocation(id) } returns singleLocation

            LocationViewModel(locationRepository).test(this, LocationState()) {
                expectInitialState()
                containerHost.loadLocation(id)
                expectState { copy(isLoading = true) }
                expectState { copy(location = singleLocation, isLoading = false) }
            }
        }

    @Test
    fun `loadLocation updates state with loading and then with error when fails`() = runTest {
        val id = 1
        val exceptionMessage = "Error fetching location"
        everySuspend { locationRepository.getLocation(id) } throws Exception(exceptionMessage)

        locationViewModel.test(this, LocationState()) {
            expectInitialState()
            containerHost.loadLocation(id)
            expectState { copy(isLoading = true) }
            expectState { copy(error = exceptionMessage, isLoading = false) }
        }
    }
}
