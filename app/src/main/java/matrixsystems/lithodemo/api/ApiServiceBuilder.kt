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
    private const val URL = "https://reqres.in/api/"
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