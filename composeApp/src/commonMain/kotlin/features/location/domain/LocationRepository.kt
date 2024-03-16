package features.location.domain

interface LocationRepository {
    suspend fun getLocations(): List<Location>
    suspend fun getLocation(id: Int): Location
}