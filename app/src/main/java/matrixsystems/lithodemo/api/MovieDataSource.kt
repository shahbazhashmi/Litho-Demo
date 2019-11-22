package matrixsystems.lithodemo.api

import androidx.paging.PageKeyedDataSource
import matrixsystems.lithodemo.models.Movie
import matrixsystems.lithodemo.models.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class MovieDataSource : PageKeyedDataSource<Int, Movie>() {
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getMovies(params.key)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.moviesList
                    val key = if (params.key > 1) params.key - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })
    }
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getMovies(FIRST_PAGE)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.moviesList
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })
    }
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getMovies(params.key)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.moviesList
                    val key = params.key + 1
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
        })
    }
    companion object {
        const val PAGE_SIZE = 6
        const val FIRST_PAGE = 1
    }
}