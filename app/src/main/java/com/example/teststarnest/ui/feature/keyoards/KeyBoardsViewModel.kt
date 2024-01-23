package com.example.teststarnest.ui.feature.keyoards

import androidx.lifecycle.*
import com.example.teststarnest.data.enums.*
import com.example.teststarnest.data.model.*
import com.example.teststarnest.data.repository.keyboard.*
import com.example.teststarnest.data.repository.keyboardcategory.*
import com.example.teststarnest.ui.base.*
import com.example.teststarnest.until.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@HiltViewModel
class KeyBoardsViewModel @Inject constructor(
    private val categoryRepository: KeyBoardCategoryRepository,
    private val keyBoardRepository: KeyBoardRepository
) : BaseViewModel() {

    private val _uiStateFlow = MutableStateFlow(KeyBoardUiState())
    val uiStateFlow = _uiStateFlow.asStateFlow()

    internal fun initData() {
        viewModelScope.launch {
            getCategories()
            getData(Constant.DefaultValue.DEFAULT_ALL_TYPE_ID)
        }
    }

    internal fun handleEvent(event: KeyBoardsEvent) {
        viewModelScope.launch {
            when (event) {
                is KeyBoardsEvent.ChoiceCategory -> {
                    getData(event.categoryId)
                }
            }
        }
    }

    private suspend fun getCategories() {
        showLoading(true)
        val categories = mutableListOf(
            KeyBoardCategory(
                id = Constant.DefaultValue.DEFAULT_ALL_TYPE_ID,
                name = "All",
                isSelected = true
            )
        )
        categories.addAll(categoryRepository.getKeyBoardCategories().toMutableList())
        _uiStateFlow.run {
            emit(
                value.copy(
                    categories = categories
                )
            )
        }
        showLoading(false)
    }

    private suspend fun getData(categoryId: Long) {
        val newCategory = _uiStateFlow.value.categories.apply {
            forEach {
                it.isSelected = it.id == categoryId
            }
        }
        _uiStateFlow.emit(
            KeyBoardUiState(
                categories = newCategory
            )
        )
        showLoading(true)
        val keyBoards = keyBoardRepository.getKeyBoards(categoryId)
        _uiStateFlow.run {
            emit(
                value.copy(
                    keyboardNew = keyBoards.filter { it.type == KeyBoardType.WHAT_NEW },
                    keyboardAlsoYouLIke = keyBoards.filter { it.type == KeyBoardType.OTHER },
                )
            )
        }
        showLoading(false)
    }
}

data class KeyBoardUiState(
    val categories: List<KeyBoardCategory> = mutableListOf(),
    val keyboardNew: List<KeyBoard> = mutableListOf(),
    val keyboardAlsoYouLIke: List<KeyBoard> = mutableListOf(),
)
