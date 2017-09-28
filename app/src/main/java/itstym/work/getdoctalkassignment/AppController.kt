package itstym.work.getdoctalkassignment

import android.app.Application
import android.text.TextUtils
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley


/**
 * Created by itstym on 29/9/17.
 */


class AppController : Application() {

    private var mRequestQueue: RequestQueue? = null
    private var mImageLoader: ImageLoader? = null

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    val requestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {

                Log.v("Application context ",applicationContext.toString())
                mRequestQueue = Volley.newRequestQueue(applicationContext)
            }

            return mRequestQueue!!
        }


    fun <T> addToRequestQueue(req: Request<T>, tag: String) {
        // set the default tag if tag is empty
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.tag = TAG
        requestQueue.add(req)
    }

    fun cancelPendingRequests(tag: Any) {
        if (mRequestQueue != null) {
            mRequestQueue!!.cancelAll(tag)
        }
    }

    companion object {

        val TAG = AppController::class.java
                .simpleName

        var mInstance:AppController?=null

        fun getInstance():AppController{

            if (mInstance==null){
                mInstance= AppController()
                return AppController()
            }
            return mInstance!!
        }
    }
}