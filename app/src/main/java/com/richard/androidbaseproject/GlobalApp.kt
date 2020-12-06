import android.content.Context
import android.support.multidex.MultiDexApplication

/**
 * 程序入口
 */
class GlobalApp : MultiDexApplication(){

    var mContext: Context? = null

    override fun onCreate() {
        super.onCreate()
        mContext = this

    }

}