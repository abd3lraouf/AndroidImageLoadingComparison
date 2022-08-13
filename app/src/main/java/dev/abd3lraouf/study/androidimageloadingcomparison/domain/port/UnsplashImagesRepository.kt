package dev.abd3lraouf.study.androidimageloadingcomparison.domain.port

import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

interface UnsplashImagesRepository {
    suspend fun fetchData(): List<UnsplashImage>
}
