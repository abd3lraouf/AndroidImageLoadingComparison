package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.GetUnsplashImagesUseCase
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getUnsplashImagesUseCase: GetUnsplashImagesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UnsplashImagesUiState>(UnsplashImagesUiState.IDLE)
    val uiState: StateFlow<UnsplashImagesUiState> = _uiState

    fun fetchData() {
        _uiState.value = UnsplashImagesUiState.Loading
        viewModelScope.launch {
            val result: Result<List<UnsplashImage>> = getUnsplashImagesUseCase()
            _uiState.value = when {
                result.isSuccess -> UnsplashImagesUiState.Success(result.getOrDefault(emptyList()))
                else -> UnsplashImagesUiState.Error(result.exceptionOrNull().toString())
            }
        }
    }
}
