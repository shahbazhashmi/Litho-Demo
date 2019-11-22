package matrixsystems.lithodemo.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import matrixsystems.lithodemo.api.UserDataSource
import matrixsystems.lithodemo.api.UserDataSourceFactory
import matrixsystems.lithodemo.models.User

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class UserViewModel : ViewModel() {
    var userPagedList: LiveData<PagedList<User>>
    private var liveDataSource: LiveData<UserDataSource>
    init {
        val itemDataSourceFactory = UserDataSourceFactory()
        liveDataSource = itemDataSourceFactory.userLiveDataSource
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()
        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}