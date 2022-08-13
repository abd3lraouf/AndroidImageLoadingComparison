package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list

import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

sealed class UnsplashImagesUiState {
    object IDLE : UnsplashImagesUiState()
    object Loading : UnsplashImagesUiState()
    data class Error(val errorMessage: String) : UnsplashImagesUiState()
    data class Success(val data: List<UnsplashImage>) : UnsplashImagesUiState()
}
