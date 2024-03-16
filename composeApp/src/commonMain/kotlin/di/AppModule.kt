package di

import core.network.networkModule
import features.home.di.homeModule
import features.location.di.locationModule

val appModule = listOf(
    networkModule,
    homeModule,
    locationModule,
)