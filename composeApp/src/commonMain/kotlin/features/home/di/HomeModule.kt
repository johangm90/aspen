package features.home.di

import features.home.data.HomeRepository
import features.home.presentation.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    single {
        HomeRepository(
            locationLocalDataSource = get(),
            api = get()
        )
    }
    single {
        HomeViewModel(
            repository = get()
        )
    }
}