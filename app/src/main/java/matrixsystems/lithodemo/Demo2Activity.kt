package matrixsystems.lithodemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.Text
import matrixsystems.lithodemo.layouts.ListItem
import matrixsystems.lithodemo.layouts.ListSection

/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
class Demo2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = ComponentContext(this);

        //val component = ListItem.create(context).build()
        val component = RecyclerCollectionComponent.create(context)
            .disablePTR(true)
            .section(ListSection.create(SectionContext(context)).build())
            .build()

        setContentView(LithoView.create(context, component));
    }
}
