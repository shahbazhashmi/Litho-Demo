package matrixsystems.lithodemo.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movie_list.*
import matrixsystems.lithodemo.R

class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        val adapter = MovieAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemViewModel = ViewModelProviders.of(this)
            .get(MovieViewModel::class.java)
        itemViewModel.moviePagedList.observe(this, Observer {
            adapter.submitList(it)
        })
        recyclerView.adapter = adapter
    }
}
