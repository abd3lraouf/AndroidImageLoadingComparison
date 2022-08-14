package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.drawable

import android.graphics.drawable.Drawable
import androidx.annotation.Px
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.TransitionFactory
import dev.abd3lraouf.study.androidimageloadingcomparison.utils.toPx

class DrawableDebugIndicatorTransitionFactory(
    @Px private val indicatorSize: Int
) : TransitionFactory<Drawable> {
    init {
        require(indicatorSize > 0) { "indicatorSize must be greater than 0, but was $indicatorSize" }
    }

    override fun build(dataSource: DataSource, isFirstResource: Boolean): Transition<Drawable> {
        return DrawableDebugIndicatorTransition(dataSource, indicatorSize)
    }

    companion object {
        val DEFAULT = DrawableDebugIndicatorTransitionFactory(16.toPx)
    }
}
