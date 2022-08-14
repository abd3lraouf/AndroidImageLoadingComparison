package dev.abd3lraouf.study.androidimageloadingcomparison.utils

import android.content.res.Resources

val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()
