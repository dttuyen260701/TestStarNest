package com.example.teststarnest.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

abstract class BaseViewModel : ViewModel() {
    companion object {
        private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    }

    protected suspend fun showLoading(isLoading: Boolean) {
        _isLoading.emit(isLoading)
    }

    internal val isLoading = _isLoading.asStateFlow()
}