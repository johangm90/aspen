package features.home.domain

data class PopularModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val rating: Double,
    val isFavorite: Boolean
)
