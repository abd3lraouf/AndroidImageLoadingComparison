package dev.abd3lraouf.study.androidimageloadingcomparison.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.port.UnsplashImagesRepository
import dev.abd3lraouf.study.androidimageloadingcomparison.utils.parseJson
import dev.abd3lraouf.study.androidimageloadingcomparison.utils.readFile
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class UnsplashImagesRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val defaultDispatcher: CoroutineDispatcher
) : UnsplashImagesRepository {

    override suspend fun fetchData(): List<UnsplashImage> {
        return coroutineScope {
            val unsplashImages = async(defaultDispatcher) {
                context.readFile("unsplash_images.json").parseJson()
            }
            doNetworkCall()
            unsplashImages.await()
        }
    }

    private suspend fun doNetworkCall() = delay(Random.nextLong(100, 2000))
}
