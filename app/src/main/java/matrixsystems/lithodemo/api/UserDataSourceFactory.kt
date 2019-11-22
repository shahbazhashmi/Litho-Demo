package matrixsystems.lithodemo.api

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import matrixsystems.lithodemo.models.User

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class UserDataSourceFactory : DataSource.Factory<Int, User>() {
    val userLiveDataSource = MutableLiveData<UserDataSource>()
    override fun create(): DataSource<Int, User> {
        val userDataSource = UserDataSource()
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }
}