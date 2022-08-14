package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.drawable

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.annotation.ColorInt
import androidx.annotation.Px
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.Transition.ViewAdapter

internal class DrawableDebugIndicatorTransition(
    private val dataSource: DataSource,
    @Px private val indicatorSize: Int
) : Transition<Drawable> {

    override fun transition(current: Drawable, adapter: ViewAdapter): Boolean {
        val indicatorColor = getIndicatorColor(dataSource)
        var indicatorSize = indicatorSize
        if (indicatorSize == -1) {
            indicatorSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                DEFAULT_INDICATOR_SIZE_DP,
                adapter.view.resources.displayMetrics
            ).toInt()
        }
        adapter.setDrawable(DebugIndicatorDrawable(current, indicatorColor, indicatorSize))
        return true
    }

    @ColorInt
    private fun getIndicatorColor(dataSource: DataSource): Int {
        return when (dataSource) {
            DataSource.LOCAL -> Color.YELLOW
            DataSource.REMOTE -> Color.RED
            DataSource.DATA_DISK_CACHE, DataSource.RESOURCE_DISK_CACHE -> -0xff9901
            DataSource.MEMORY_CACHE -> Color.GREEN
            else -> throw AssertionError("Unhandled enum value $dataSource")
        }
    }

    companion object {
        private const val DEFAULT_INDICATOR_SIZE_DP = 16.0f
    }
}
