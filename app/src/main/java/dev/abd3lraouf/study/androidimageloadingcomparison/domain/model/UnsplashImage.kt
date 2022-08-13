package dev.abd3lraouf.study.androidimageloadingcomparison.domain.model

import com.google.gson.annotations.SerializedName

data class UnsplashImage(
    @SerializedName(value = "id")
    val id: String,
    @SerializedName(value = "author")
    val author: String,
    @SerializedName(value = "download_url")
    val url: String
) {
    companion object {
        val Empty = UnsplashImage(id = "", author = "", url = "dummy-url-for-picasso")

        fun makeFakeItems(count: Int): List<UnsplashImage> = (0 until count).map { Empty }
    }
}
