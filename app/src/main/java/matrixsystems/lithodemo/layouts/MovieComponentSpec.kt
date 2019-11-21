package matrixsystems.lithodemo.layouts

import android.graphics.Color

import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text

import com.facebook.yoga.YogaEdge.ALL

/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
@LayoutSpec
object MovieComponentSpec {

    @JvmStatic
    @OnCreateLayout
    internal fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String,
        @Prop imageUrl: String
    ): Component {

        return Column.create(c)
            .paddingDip(ALL, 16f)
            .backgroundColor(Color.WHITE)
            .child(
                Text.create(c)
                    .text(title)
                    .textSizeSp(40f)
            )
            .child(
                Text.create(c)
                    .text(imageUrl)
                    .textSizeSp(20f)
            )
            .build()
    }

}
