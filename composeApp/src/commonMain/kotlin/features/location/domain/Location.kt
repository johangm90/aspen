package features.location.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Int,
    val name: String,
    val description: String,
    @SerialName("image_url")
    val imageUrl: String,
    val rating: Double,
    @SerialName("review_count")
    val reviewCount: Int,
    val price: Int,
    val facilities: List<String>,
    @SerialName("is_popular")
    val isPopular: Boolean,
    @SerialName("has_deal")
    val isRecommended: Boolean,
    @SerialName("is_favorite")
    val isFavorite: Boolean,
    val duration: String,
)
