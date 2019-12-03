## Litho-Demo

### Introduction

The app demonstrates facebook Litho framework with Retrofit, Pagination and TMDB APIs. This repository also has working demo of android paging-library.

<img src="litho_gif.gif?raw=true" width="350px">

<br>

### MovieListActivity

```
class MovieListActivity : AppCompatActivity() {

    private val TAG = "MovieListActivity"

    lateinit var componentContext : ComponentContext
    lateinit var recyclerBinder : RecyclerBinder

    var isLoading = false

    val LOAD_THRESHOLD = 10

    var PAGE = 0
    var TOTAL_PAGES = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        componentContext = ComponentContext(this)

        recyclerBinder = RecyclerBinder.Builder().also {
            it.layoutInfo(GridLayoutInfo(this, 3))
        }.build(componentContext)

        val component = Recycler.create(componentContext)
            .binder(recyclerBinder)
            .onScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val firstLastItemPosition = recyclerBinder.findLastVisibleItemPosition()
                    if (recyclerBinder.getItemCount() - LOAD_THRESHOLD <= firstLastItemPosition
                        && !isLoading && PAGE < TOTAL_PAGES) {
                        loadNextPage()
                    }
                }
            })
            .backgroundColor(Color.BLACK)
            .build()

        setContentView(LithoView.create(componentContext, component))


        loadNextPage()
    }



    fun loadNextPage() {
        isLoading = true
        val call = ApiServiceBuilder.buildService(ApiService::class.java).getMovies(++PAGE)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    TOTAL_PAGES = apiResponse.totalPages!!
                    apiResponse.moviesList?.forEach {
                        recyclerBinder.appendItem(
                            ComponentRenderInfo.create()
                                .component(
                                    MovieComponent.create(componentContext)
                                        .title(it?.title)
                                        .imageUrl(ApiServiceBuilder.THUMBNAIL_IMAGE_URL+it?.posterPath)
                                        .build())
                                .isSticky(true)
                                .build())
                    }

                }
                isLoading = false
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                isLoading = false
            }
        })
    }
}
```