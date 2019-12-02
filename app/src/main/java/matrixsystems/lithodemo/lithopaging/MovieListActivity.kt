package matrixsystems.lithodemo.lithopaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import matrixsystems.lithodemo.layouts.MovieSection
import com.facebook.litho.sections.widget.*



class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this);

        val recyclerConfiguration = GridRecyclerConfiguration.create().numColumns(3).build()

        val component = RecyclerCollectionComponent.create(context)
            .disablePTR(true)
            .section(MovieSection.create(SectionContext(context)).build())
            .recyclerConfiguration(recyclerConfiguration)
            .build()

        setContentView(LithoView.create(context, component));
    }
}
