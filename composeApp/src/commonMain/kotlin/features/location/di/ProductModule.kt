package features.location.di

import features.location.data.LocationLocalDataSourceImpl
import features.location.data.LocationRepositoryImpl
import features.location.domain.LocationLocalDataSource
import features.location.domain.LocationRepository
import features.location.presentation.LocationViewModel
import org.koin.dsl.module

val locationModule = module {
    single<LocationLocalDataSource> {
        LocationLocalDataSourceImpl(
            db = get()
        )
    }
    single<LocationRepository> {
        LocationRepositoryImpl(
            localDataSource = get(),
            api = get()
        )
    }
    single {
        LocationViewModel(
            locationRepository = get()
        )
    }
}