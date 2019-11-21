package matrixsystems.lithodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import matrixsystems.lithodemo.layouts.ListSection
import matrixsystems.lithodemo.layouts.MovieSection

class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this);

        //val component = ListItem.create(context).build()
        val component = RecyclerCollectionComponent.create(context)
            .disablePTR(true)
            .section(MovieSection.create(SectionContext(context)).build())
            .build()

        setContentView(LithoView.create(context, component));
    }
}
