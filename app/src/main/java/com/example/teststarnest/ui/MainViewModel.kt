package com.example.teststarnest.ui

import androidx.lifecycle.*
import com.example.teststarnest.*
import com.example.teststarnest.data.enums.*
import com.example.teststarnest.data.model.*
import com.example.teststarnest.data.repository.keyboard.*
import com.example.teststarnest.data.repository.keyboardcategory.*
import com.example.teststarnest.ui.base.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoryRepository: KeyBoardCategoryRepository,
    private val keyBoardRepository: KeyBoardRepository
) : BaseViewModel() {
    init {
        viewModelScope.launch {
            showLoading(true)
            val categories = categoryRepository.getKeyBoardCategories()
            if (categories.isEmpty()) {
                categoryRepository.insertCategories(
                    KeyBoardCategory(
                        name = "Galaxy"
                    ),
                    KeyBoardCategory(
                        name = "Animal"
                    ),
                    KeyBoardCategory(
                        name = "Funny"
                    )
                )
                val themes = listOf(
                    R.drawable.theme_1,
                    R.drawable.theme_2,
                    R.drawable.theme_3,
                    R.drawable.theme_4,
                    R.drawable.theme_5,
                    R.drawable.theme_6,
                    R.drawable.theme_7,
                    R.drawable.theme_8,
                    R.drawable.theme_9,
                    R.drawable.theme_10,
                    R.drawable.theme_11,
                    R.drawable.theme_12,
                    R.drawable.theme_13,
                    R.drawable.theme_14,
                    R.drawable.theme_15,
                    R.drawable.theme_16
                )

                val categoriesNew = categoryRepository.getKeyBoardCategories()
                val keyboards = mutableListOf<KeyBoard>()
                categoriesNew.forEachIndexed { indexCategory, category ->
                    themes.forEachIndexed { index, theme ->
                        keyboards.add(
                            KeyBoard(
                                categoryId = category.id,
                                previewIcon = theme,
                                type = if ((indexCategory < 2 && index < 6) || (indexCategory == 2 && index > 9)) {
                                    KeyBoardType.WHAT_NEW
                                } else {
                                    KeyBoardType.OTHER
                                }
                            )
                        )
                    }
                }
                keyBoardRepository.insertKeyBoards(*(keyboards.toTypedArray()))
            }
            showLoading(false)
        }
    }
}