package matrixsystems.lithodemo.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.row_user.view.*
import matrixsystems.lithodemo.R
import matrixsystems.lithodemo.models.User

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class UserAdapter : PagedListAdapter<User, UserAdapter.UserViewHolder>(USER_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_user, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }
    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.user_avatar
        private val userName = view.user_name
        private val userEmail = view.user_email
        fun bind(user: User) {
            userName.text = user.firstName + " " + user.lastName
            userEmail.text = user.email
            imageView.controller = getImageController(user.avatar!!)
        }

        fun getImageController(imageUrl : String) = Fresco.newDraweeControllerBuilder()
            .setUri(imageUrl)
            .build()
    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                newItem == oldItem
        }
    }
}