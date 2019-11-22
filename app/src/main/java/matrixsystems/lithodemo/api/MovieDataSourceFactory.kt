package matrixsystems.lithodemo.api

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import matrixsystems.lithodemo.models.Movie

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class MovieDataSourceFactory  : DataSource.Factory<Int, Movie>() {
    val movieLiveDataSource = MutableLiveData<MovieDataSource>()
    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource()
        movieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}