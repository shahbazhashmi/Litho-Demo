package matrixsystems.lithodemo.layouts

import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection
import android.graphics.Color



/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
@GroupSectionSpec
object ListSectionSpec {

    @JvmStatic
    @OnCreateChildren
    internal fun onCreateChildren(c: SectionContext): Children {
        val builder = Children.create()

        for (i in 0..31) {
            builder.child(
                /*SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(ListItem.create(c).build())*/
                SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(
                        ListItem.create(c)
                            .color(if (i % 2 == 0) Color.WHITE else Color.LTGRAY)
                            .title("$i. Hello, world!")
                            .subtitle("Litho tutorial")
                            .build()
                    )
            )
        }
        return builder.build()
    }
}
