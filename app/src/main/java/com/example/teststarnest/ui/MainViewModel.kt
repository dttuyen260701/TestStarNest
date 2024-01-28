package com.example.teststarnest.ui

import androidx.lifecycle.*
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
                    "theme_1.png",
                    "theme_2.png",
                    "theme_3.png",
                    "theme_4.png",
                    "theme_5.png",
                    "theme_6.png",
                    "theme_7.png",
                    "theme_8.png",
                    "theme_9.png",
                    "theme_10.png",
                    "theme_11.png",
                    "theme_12.png",
                    "theme_13.png",
                    "theme_14.png",
                    "theme_15.png",
                    "theme_16.png",
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
            setFirstInitData(true)
            showLoading(false)
        }
    }
}