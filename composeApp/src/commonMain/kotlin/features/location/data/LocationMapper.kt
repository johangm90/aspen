package features.location.data

import com.jgm90.aspen.LocationEntity
import features.location.domain.Location

fun LocationEntity.toLocation() = Location(
    id = id.toInt(),
    name = name,
    description = description,
    imageUrl = image_url,
    rating = rating,
    reviewCount = review_count.toInt(),
    price = price.toInt(),
    facilities = facilities.split(", "),
    isPopular = is_popular.toInt() == 1,
    isRecommended = has_deal.toInt() == 1,
    isFavorite = is_favorite.toInt() == 1,
    duration = duration
)