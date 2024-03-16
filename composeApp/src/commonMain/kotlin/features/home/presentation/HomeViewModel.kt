package features.home.presentation

import common.UIComponent
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import features.home.data.HomeRepository
import features.home.data.toPopularModel
import features.home.data.toRecommendedModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class HomeViewModel(
    private val repository: HomeRepository
) : ContainerHost<HomeState, UIComponent>, ViewModel() {
    override val container: Container<HomeState, UIComponent> =
        viewModelScope.container(HomeState())

    init {
        load()
    }

    private fun load() {
        intent {
            runCatching {
                reduce { state.copy(isLoading = true) }
                val locations = repository.getLocations()
                val popularItems = locations.filter { it.isPopular }.map { location ->
                    location.toPopularModel()
                }
                val recommendedItems = locations.filter { it.isRecommended }.map { location ->
                    location.toRecommendedModel()
                }
                reduce {
                    state.copy(
                        isLoading = false,
                        popularItems = popularItems,
                        recommendedItems = recommendedItems
                    )
                }
            }.onFailure {
                reduce { state.copy(isLoading = false) }
            }
        }
    }
}