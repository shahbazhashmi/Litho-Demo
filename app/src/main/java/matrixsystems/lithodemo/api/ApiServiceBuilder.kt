package matrixsystems.lithodemo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
object ApiServiceBuilder {
    // Base URL
    private const val URL = "https://api.themoviedb.org/3/"

    // Image URL
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w200"
    const val THUMBNAIL_IMAGE_URL = "https://image.tmdb.org/t/p/w92"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(logger)
    // Create Retrofit Builder
    private val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
    // Create Retrofit Instance
    private val retrofit = builder.build()
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}