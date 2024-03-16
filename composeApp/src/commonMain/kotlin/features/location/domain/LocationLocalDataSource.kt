package features.location.domain

interface LocationLocalDataSource {
    fun getLocations(): List<Location>
    fun getLocation(id: Int): Location?
    suspend fun addLocation(location: Location)
    suspend fun addLocations(locations: List<Location>)
    suspend fun updateLocation(location: Location)
    suspend fun deleteLocation(id: Int)
}