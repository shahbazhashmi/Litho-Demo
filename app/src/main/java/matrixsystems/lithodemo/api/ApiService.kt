package matrixsystems.lithodemo.api

import matrixsystems.lithodemo.BuildConfig
import matrixsystems.lithodemo.models.MovieResponse
import matrixsystems.lithodemo.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
interface ApiService {

    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<UserResponse>

    @GET("movie/top_rated?api_key=${BuildConfig.TMDB_API_KEY}&language=en-US")
    fun getMovies(@Query("page") page: Int): Call<MovieResponse>

}