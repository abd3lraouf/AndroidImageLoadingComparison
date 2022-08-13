package dev.abd3lraouf.study.androidimageloadingcomparison.utils

import android.content.Context
import com.google.gson.Gson
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

fun Context.readFile(fileName: String): String =
    assets.open(fileName).bufferedReader().use { it.readText() }

fun String.parseJson(): List<UnsplashImage> =
    Gson().fromJson(this, Array<UnsplashImage>::class.java).toList()
