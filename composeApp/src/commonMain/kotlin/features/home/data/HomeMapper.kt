package features.home.data

import features.home.domain.PopularModel
import features.home.domain.RecommendedModel
import features.location.domain.Location

fun Location.toPopularModel() = PopularModel(
    id = id,
    title = name,
    imageUrl = imageUrl,
    rating = rating,
    isFavorite = isFavorite
)

fun Location.toRecommendedModel() = RecommendedModel(
    title = name,
    imageUrl = imageUrl,
    duration = duration
)