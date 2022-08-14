package dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.indicators.enableDebugIndicators

@GlideModule
class GlideAppModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.enableDebugIndicators()
    }
}
