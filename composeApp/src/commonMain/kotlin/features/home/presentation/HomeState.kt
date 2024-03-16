package features.home.presentation

import features.home.domain.PopularModel
import features.home.domain.RecommendedModel

data class HomeState(
    val popularItems: List<PopularModel> = emptyList(),
    val recommendedItems: List<RecommendedModel> = emptyList(),
    val isLoading: Boolean = false
)
