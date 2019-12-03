package matrixsystems.lithodemo.layouts

import android.graphics.Color
import android.graphics.Typeface

import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.fresco.FrescoImage
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text

import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge.*
import com.facebook.yoga.YogaPositionType
import matrixsystems.lithodemo.R


/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
@LayoutSpec
object MovieComponentSpec {

    fun getImageController(imageUrl : String?) = Fresco.newDraweeControllerBuilder()
        .setUri(imageUrl)
        .build()


    @JvmStatic
    @OnCreateLayout
    internal fun onCreateLayout(
        c: ComponentContext,
        @Prop title: String?,
        @Prop imageUrl: String?
    ): Component {

        return Column.create(c)
            .paddingDip(ALL, 8f)
            .backgroundColor(Color.BLACK)
            .child(
                FrescoImage.create(c).controller(getImageController(imageUrl))
                    .placeholderImageRes(R.drawable.movie_placeholder)
                    .placeholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                    .imageAspectRatio(0.66666666666667f)
            )
            .child(
                Text.create(c)
                    .text(title)
                    .textColor(Color.WHITE)
                    .textStyle(Typeface.BOLD)
                    .textSizeSp(12f)
                    .widthPercent(100f)
                    .maxLines(3)
                    .backgroundColor(Color.parseColor("#40000000"))
                    .positionType(YogaPositionType.ABSOLUTE)
                    /**
                     * set text over image to bottom
                     */
                    .positionDip(BOTTOM, 8f)
                    .positionDip(LEFT, 8f)
                    .paddingDip(ALL, 8f)
            )
            .build()
    }

}
