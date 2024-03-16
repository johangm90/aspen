package core.network

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import features.location.domain.Location

interface AspenAPI {
    @GET("location")
    suspend fun getLocations(): List<Location>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Location
}