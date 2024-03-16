package features.home.data

import core.network.AspenAPI
import features.location.domain.Location
import features.location.domain.LocationLocalDataSource

class HomeRepository(
    private val locationLocalDataSource: LocationLocalDataSource,
    private val api: AspenAPI
) {
    suspend fun getLocations(): List<Location> {
        val cachedLocations = locationLocalDataSource.getLocations()
        if (cachedLocations.isNotEmpty()) return cachedLocations
        val newLocations = api.getLocations()
        locationLocalDataSource.addLocations(newLocations)
        return newLocations
    }
}