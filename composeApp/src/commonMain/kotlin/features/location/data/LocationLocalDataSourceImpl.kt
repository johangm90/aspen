package features.location.data

import com.jgm90.aspen.AppDatabase
import features.location.domain.Location
import features.location.domain.LocationLocalDataSource

class LocationLocalDataSourceImpl(
    db: AppDatabase,
) : LocationLocalDataSource {
    private val locationQueries = db.locationQueries

    override fun getLocations(): List<Location> {
        return locationQueries.getAll().executeAsList().map { locationEntity ->
            locationEntity.toLocation()
        }
    }

    override fun getLocation(id: Int): Location? {
        return locationQueries.getById(id.toLong()).executeAsOneOrNull()?.toLocation()
    }

    override suspend fun addLocation(location: Location) {
        locationQueries.insert(
            name = location.name,
            description = location.description,
            image_url = location.imageUrl,
            rating = location.rating,
            review_count = location.reviewCount.toLong(),
            price = location.price.toLong(),
            facilities = location.facilities.joinToString(", "),
            is_popular = if (location.isPopular) 1 else 0,
            has_deal = if (location.isRecommended) 1 else 0,
            is_favorite = if (location.isFavorite) 1 else 0,
            duration = location.duration
        )
    }

    override suspend fun addLocations(locations: List<Location>) {
        locationQueries.transaction {
            locations.forEach { location ->
                locationQueries.insert(
                    name = location.name,
                    description = location.description,
                    image_url = location.imageUrl,
                    rating = location.rating,
                    review_count = location.reviewCount.toLong(),
                    price = location.price.toLong(),
                    facilities = location.facilities.joinToString(", "),
                    is_popular = if (location.isPopular) 1 else 0,
                    has_deal = if (location.isRecommended) 1 else 0,
                    is_favorite = if (location.isFavorite) 1 else 0,
                    duration = location.duration
                )
            }
        }
    }

    override suspend fun updateLocation(location: Location) {
        locationQueries.update(
            name = location.name,
            description = location.description,
            image_url = location.imageUrl,
            rating = location.rating,
            review_count = location.reviewCount.toLong(),
            price = location.price.toLong(),
            facilities = location.facilities.joinToString(", "),
            is_popular = if (location.isPopular) 1 else 0,
            has_deal = if (location.isRecommended) 1 else 0,
            is_favorite = if (location.isFavorite) 1 else 0,
            duration = location.duration,
            id = location.id.toLong()
        )
    }

    override suspend fun deleteLocation(id: Int) {
        locationQueries.delete(id.toLong())
    }
}