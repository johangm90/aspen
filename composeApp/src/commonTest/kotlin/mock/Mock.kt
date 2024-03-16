package mock

import features.location.domain.Location

val locationMock = Location(
    id = 1,
    name = "Test Location",
    description = "Test Description",
    imageUrl = "https://test.com/image.jpg",
    rating = 4.5,
    reviewCount = 100,
    price = 100,
    facilities = listOf("Facility 1", "Facility 2"),
    isPopular = true,
    isRecommended = true,
    isFavorite = true,
    duration = "3N/2D"
)