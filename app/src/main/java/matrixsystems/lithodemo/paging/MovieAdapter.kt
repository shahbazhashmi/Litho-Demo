package matrixsystems.lithodemo.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.row_user.view.*
import matrixsystems.lithodemo.R
import matrixsystems.lithodemo.api.ApiServiceBuilder
import matrixsystems.lithodemo.models.Movie

/**
 * Created by Shahbaz Hashmi on 2019-11-22.
 */
class MovieAdapter : PagedListAdapter<Movie, MovieAdapter.MovieViewHolder>(USER_COMPARATOR) {

    private val TAG = "MovieAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_user, parent, false)
        return MovieViewHolder(view)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }
    }
    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.user_avatar
        private val userName = view.user_name
        private val userEmail = view.user_email
        fun bind(user: Movie) {
            userName.text = user.title
            userEmail.text = user.overview
            val imageUrl = ApiServiceBuilder.IMAGE_URL+user.posterPath!!
            imageView.controller = getImageController(imageUrl)
            Log.d(TAG, "image : $imageUrl")
        }

        fun getImageController(imageUrl : String) = Fresco.newDraweeControllerBuilder()
            .setUri(imageUrl)
            .build()
    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                newItem == oldItem
        }
    }
}