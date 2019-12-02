package matrixsystems.lithodemo.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import matrixsystems.lithodemo.api.UserDataSource
import matrixsystems.lithodemo.api.MovieDataSourceFactory
import matrixsystems.lithodemo.models.Movie

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class MovieViewModel  : ViewModel() {
    var moviePagedList: LiveData<PagedList<Movie>>
    init {
        val itemDataSourceFactory = MovieDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()
        moviePagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}