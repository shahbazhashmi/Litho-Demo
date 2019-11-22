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
                SingleComponentSection.create(c)
                    .key(i.toString())
                    .component(
                        MovieComponent.create(c)
                            .title("$i. Goku")
                            .imageUrl("https://a1cf74336522e87f135f-2f21ace9a6cf0052456644b80fa06d4f.ssl.cf2.rackcdn.com/images/characters_opt/p-dragon-ball-z-goku.jpg")
                            .build()
                    )
            )
        }
        return builder.build()
    }

}