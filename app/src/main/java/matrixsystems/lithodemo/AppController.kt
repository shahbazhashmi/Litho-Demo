package matrixsystems.lithodemo

import android.app.Application
import com.facebook.soloader.SoLoader

/**
 * Created by Shahbaz Hashmi on 2019-11-13.
 */
class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)
    }

}