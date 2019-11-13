package matrixsystems.lithodemo.layouts

import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection

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
                SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(ListItem.create(c).build())
            )
        }
        return builder.build()
    }
}
