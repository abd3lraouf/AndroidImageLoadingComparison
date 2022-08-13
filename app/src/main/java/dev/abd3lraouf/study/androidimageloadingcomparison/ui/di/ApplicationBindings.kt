package dev.abd3lraouf.study.androidimageloadingcomparison.ui.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.abd3lraouf.study.androidimageloadingcomparison.data.UnsplashImagesRepositoryImpl
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.port.UnsplashImagesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationBindings {

    @Binds
    @Singleton
    abstract fun bindUnsplashImagesRepository(impl: UnsplashImagesRepositoryImpl): UnsplashImagesRepository
}
