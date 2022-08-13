package dev.abd3lraouf.study.androidimageloadingcomparison.domain

import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.port.UnsplashImagesRepository
import javax.inject.Inject

class GetUnsplashImagesUseCase @Inject constructor(
    private val unsplashImagesRepository: UnsplashImagesRepository
) {
    suspend operator fun invoke(): Result<List<UnsplashImage>> {
        val unsplashImages = unsplashImagesRepository.fetchData()
        return if (unsplashImages.size > 100) {
            Result.failure(Exception("Image list is too large, we need some pagination"))
        } else Result.success(unsplashImages)
    }
}
