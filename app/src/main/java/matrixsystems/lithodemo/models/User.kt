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
data class User(
    @SerializedName("avatar")
    var avatar: String? = "",
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("first_name")
    var firstName: String? = "",
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("last_name")
    var lastName: String? = ""
) : Parcelable