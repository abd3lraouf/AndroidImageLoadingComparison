package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.bitmap

import android.graphics.Bitmap
import androidx.annotation.Px
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.TransitionFactory
import dev.abd3lraouf.study.androidimageloadingcomparison.utils.toPx

class BitmapDebugIndicatorTransitionFactory(
    @Px private val indicatorSize: Int
) : TransitionFactory<Bitmap> {
    init {
        require(indicatorSize > 0) { "indicatorSize must be greater than 0, but was $indicatorSize" }
    }

    override fun build(dataSource: DataSource, isFirstResource: Boolean): Transition<Bitmap> {
        return BitmapDebugIndicatorTransition(dataSource, indicatorSize)
    }

    companion object {
        val DEFAULT = BitmapDebugIndicatorTransitionFactory(16.toPx)
    }
}
