package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.drawable

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.appcompat.graphics.drawable.DrawableWrapper

@SuppressLint("RestrictedApi")
internal class DebugIndicatorDrawable(
    drawable: Drawable,
    @ColorInt indicatorColor: Int,
    @Px private val indicatorSize: Int
) : DrawableWrapper(drawable) {
    private val currentMatrix = Matrix()
    private val inverseMatrix = Matrix()
    private val paint = Paint()
    private val triangle: Path

    init {
        paint.color = indicatorColor
        triangle = createTriangle(indicatorSize.toFloat())
    }

    @SuppressLint("CanvasSize")
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val saveCount = canvas.save()

        // Set transformation matrix to identity
        canvas.concat(currentMatrix)
        currentMatrix.invert(inverseMatrix)
        canvas.concat(inverseMatrix)
        canvas.translate((canvas.width - indicatorSize).toFloat(), 0.0f)
        canvas.drawPath(triangle, paint)
        canvas.restoreToCount(saveCount)
    }

    private fun createTriangle(size: Float): Path {
        val path = Path()
        path.moveTo(0.0f, 0.0f)
        path.lineTo(size, 0.0f)
        path.lineTo(size, size)
        path.close()
        return path
    }
}
