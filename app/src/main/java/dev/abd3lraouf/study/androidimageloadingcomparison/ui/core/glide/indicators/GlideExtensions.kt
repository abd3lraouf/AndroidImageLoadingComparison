@file:JvmName("-KotlinExtensions")

package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.bitmap.BitmapDebugIndicatorTransitionFactory
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.drawable.DrawableDebugIndicatorTransitionFactory

fun GlideBuilder.enableDebugIndicators(): GlideBuilder {
    return setDefaultTransitionOptions(
        Drawable::class.java,
        DrawableTransitionOptions.with(DrawableDebugIndicatorTransitionFactory.DEFAULT)
    ).setDefaultTransitionOptions(
        Bitmap::class.java,
        BitmapTransitionOptions.with(BitmapDebugIndicatorTransitionFactory.DEFAULT)
    )
}

@JvmName("withDebugIndicatorDrawable")
fun <T : RequestBuilder<Drawable>> T.withDebugIndicator(): T {
    @Suppress("UNCHECKED_CAST")
    return transition(DrawableTransitionOptions.with(DrawableDebugIndicatorTransitionFactory.DEFAULT)) as T
}

@JvmName("withDebugIndicatorBitmap")
fun <T : RequestBuilder<Bitmap>> T.withDebugIndicator(): T {
    @Suppress("UNCHECKED_CAST")
    return transition(BitmapTransitionOptions.with(BitmapDebugIndicatorTransitionFactory.DEFAULT)) as T
}
