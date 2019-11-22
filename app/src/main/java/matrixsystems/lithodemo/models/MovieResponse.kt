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
data class MovieResponse(
    @SerializedName("page")
    var page: Int? = 0,
    @SerializedName("results")
    var moviesList: List<Movie?>? = listOf(),
    @SerializedName("total_pages")
    var totalPages: Int? = 0,
    @SerializedName("total_results")
    var totalResults: Int? = 0
) : Parcelable