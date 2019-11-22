package matrixsystems.lithodemo.api

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

}