package features.location.data

import core.network.AspenAPI
import dev.mokkery.MockMode
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import features.location.domain.LocationLocalDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import mock.locationMock
import kotlin.test.Test
import kotlin.test.assertEquals


class LocationRepositoryImplTest {
    private val mockLocalDataSource: LocationLocalDataSource = mock(MockMode.autofill)
    private val mockApi: AspenAPI = mock()
    private val locationRepository = LocationRepositoryImpl(mockLocalDataSource, mockApi)
    private val locationList = listOf(locationMock)
    private val singleLocation = locationMock

    @Test
    fun `getLocations returns cached locations when available`() = runTest {
        everySuspend { mockLocalDataSource.getLocations() } returns locationList

        val result = locationRepository.getLocations()

        assertEquals(locationList, result)
    }

    @Test
    fun `getLocations fetches new locations when cache is empty`() = runTest {
        everySuspend { mockLocalDataSource.getLocations() } returns emptyList()
        everySuspend { mockApi.getLocations() } returns locationList

        val result = locationRepository.getLocations()

        assertEquals(locationList, result)
    }

    @Test
    fun `getLocation returns cached location when available`() = runTest {
        val id = 1
        everySuspend { mockLocalDataSource.getLocation(id) } returns singleLocation

        val result = locationRepository.getLocation(id)

        assertEquals(singleLocation, result)
    }

    @Test
    fun `getLocation fetches new location when cache is empty`() = runTest {
        val id = 1
        everySuspend { mockLocalDataSource.getLocation(id) } returns null
        everySuspend { mockApi.getLocation(id) } returns singleLocation

        val result = locationRepository.getLocation(id)

        assertEquals(singleLocation, result)
    }
}