package dev.abd3lraouf.study.androidimageloadingcomparison

import android.app.Application
import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PicassoModule.init(this)
    }
}

class PicassoModule {
    companion object {
        fun init(application: Context) {
            Picasso.Builder(application)
                .indicatorsEnabled(true)
                .downloader(OkHttp3Downloader(application))
                .apply { Picasso.setSingletonInstance(build()) }
        }
    }
}
