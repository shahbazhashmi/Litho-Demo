package matrixsystems.lithodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.widget.Text

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = ComponentContext(this)

        val component = Text.create(context)
            .text("Hello World new")
            .textSizeDip(50f)
            .build()

        setContentView(LithoView.create(context, component))
    }
}
