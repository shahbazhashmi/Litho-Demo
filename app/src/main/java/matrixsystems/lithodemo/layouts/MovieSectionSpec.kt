package matrixsystems.lithodemo.layouts

import android.graphics.Color
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection

/**
 * Created by Shahbaz Hashmi on 2019-11-21.
 */
@GroupSectionSpec
object MovieSectionSpec {


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
                        MovieComponent.create(c)
                            .title("$i. Goku")
                            .imageUrl("https://pbs.twimg.com/profile_images/1053055123193122816/IUwo6l_Q_400x400.jpg")
                            .build()
                    )
            )
        }
        return builder.build()
    }

}