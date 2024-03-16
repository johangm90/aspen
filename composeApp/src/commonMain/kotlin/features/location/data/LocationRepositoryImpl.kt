package features.location.data

import core.network.AspenAPI
import features.location.domain.Location
import features.location.domain.LocationLocalDataSource
import features.location.domain.LocationRepository

class LocationRepositoryImpl(
    private val localDataSource: LocationLocalDataSource,
    private val api: AspenAPI,
) : LocationRepository {
    override suspend fun getLocations(): List<Location> {
        val cachedLocations = localDataSource.getLocations()
        if (cachedLocations.isNotEmpty()) return cachedLocations
        val newLocations = api.getLocations()
        localDataSource.addLocations(newLocations)
        return newLocations
    }

    override suspend fun getLocation(id: Int): Location {
        val cachedLocation = localDataSource.getLocation(id)
        if (cachedLocation != null) return cachedLocation
        val newLocation = api.getLocation(id)
        localDataSource.addLocation(newLocation)
        return newLocation
    }
}