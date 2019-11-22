package matrixsystems.lithodemo.models
import android.annotation.SuppressLint
import android.os.Parcelable

import kotlinx.android.parcel.Parcelize

import com.google.gson.annotations.SerializedName


/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class UserResponse(
    @SerializedName("data")
    var `data`: List<User?>? = listOf(),
    @SerializedName("page")
    var page: Int? = 0,
    @SerializedName("per_page")
    var perPage: Int? = 0,
    @SerializedName("total")
    var total: Int? = 0,
    @SerializedName("total_pages")
    var totalPages: Int? = 0
) : Parcelable
