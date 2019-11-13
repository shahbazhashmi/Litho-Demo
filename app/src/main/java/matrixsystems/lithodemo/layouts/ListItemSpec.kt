package matrixsystems.lithodemo.layouts

import android.graphics.Color

import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.widget.Text

import com.facebook.yoga.YogaEdge.ALL
import com.facebook.litho.annotations.Prop



/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
@LayoutSpec
object ListItemSpec {

   /* @JvmStatic
    @OnCreateLayout
    internal fun onCreateLayout(c: ComponentContext): Component {

        return Column.create(c)
            .paddingDip(ALL, 16f)
            .backgroundColor(Color.WHITE)
            .child(
                Text.create(c)
                    .text("Hello world")
                    .textSizeSp(40f)
            )
            .child(
                Text.create(c)
                    .text("Litho tutorial")
                    .textSizeSp(20f)
            )
            .build()
    }*/


    @JvmStatic
    @OnCreateLayout
    fun onCreateLayout(
        c: ComponentContext,
        @Prop color: Int,
        @Prop title: String,
        @Prop subtitle: String
    ): Component {

        return Column.create(c)
            .paddingDip(ALL, 16f)
            .backgroundColor(color)
            .child(
                Text.create(c)
                    .text(title)
                    .textSizeSp(40f)
            )
            .child(
                Text.create(c)
                    .text(subtitle)
                    .textSizeSp(20f)
            )
            .build()
    }
}
