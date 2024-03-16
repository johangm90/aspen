package core.network

import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    val ktorfit = ktorfit {
        baseUrl("https://qgvvl.wiremockapi.cloud/")
        httpClient(HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
        })
    }
    single { ktorfit.create<AspenAPI>() }
}