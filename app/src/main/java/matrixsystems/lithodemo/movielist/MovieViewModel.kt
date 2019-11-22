package matrixsystems.lithodemo.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import matrixsystems.lithodemo.api.MovieDataSource
import matrixsystems.lithodemo.api.UserDataSource
import matrixsystems.lithodemo.api.MovieDataSourceFactory
import matrixsystems.lithodemo.models.Movie

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class MovieViewModel  : ViewModel() {
    var userPagedList: LiveData<PagedList<Movie>>
    private var liveDataSource: LiveData<MovieDataSource>
    init {
        val itemDataSourceFactory = MovieDataSourceFactory()
        liveDataSource = itemDataSourceFactory.movieLiveDataSource
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()
        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}