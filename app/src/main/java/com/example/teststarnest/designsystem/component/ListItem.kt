package com.example.teststarnest.designsystem.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.example.teststarnest.R
import com.example.teststarnest.data.model.*
import com.example.teststarnest.until.Constant.DefaultValue.PADDING_HORIZONTAL_SCREEN

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
internal fun ListCategory(
    modifier: Modifier = Modifier,
    categories: List<KeyBoardCategory>,
    onCategoryClick: (KeyBoardCategory) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(PADDING_HORIZONTAL_SCREEN.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        categories.forEach {
            ItemCategory(
                category = it,
                onItemClick = onCategoryClick
            )
        }
    }
}

@Composable
internal fun ListKeyBoard(
    modifier: Modifier = Modifier,
    title: String,
    isHorizontalView: Boolean = true,
    keyboards: List<KeyBoard>,
    onKeyBoardClick: (KeyBoard) -> Unit
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = PADDING_HORIZONTAL_SCREEN.dp),
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground
    )
    MarginVertical(16)
    if (isHorizontalView) {
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(
                count = (keyboards.size + 1) / 2,
                key = { "keyboard hori ${keyboards.getOrNull(it)?.id}" }
            ) {
                Column {
                    keyboards.getOrNull(it * 2)?.let { keyboard ->
                        ItemKeyBoard(
                            keyBoard = keyboard,
                            onItemClick = onKeyBoardClick
                        )
                    }
                    MarginVertical(16)
                    keyboards.getOrNull(it * 2 + 1)?.let { keyboard ->
                        ItemKeyBoard(
                            keyBoard = keyboard,
                            onItemClick = onKeyBoardClick
                        )
                    }
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp),
        ) {
            for (i in 0..keyboards.size / 2) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    keyboards.getOrNull(i * 2)?.let { keyboard ->
                        ItemKeyBoard(
                            keyBoard = keyboard,
                            onItemClick = onKeyBoardClick
                        )
                    }
                    MarginHorizontal(10)
                    keyboards.getOrNull(i * 2 + 1)?.let { keyboard ->
                        ItemKeyBoard(
                            keyBoard = keyboard,
                            onItemClick = onKeyBoardClick
                        )
                    }
                }
                MarginVertical(10)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListKeyBoard() {
    Column {
        ListKeyBoard(
            title = stringResource(id = R.string.what_new_title),
            keyboards = listOf(
                KeyBoard(
                    id = 1L,
                    categoryId = 1L,
                    previewIcon = "theme_1.png"
                ),
                KeyBoard(
                    id = 123L,
                    categoryId = 1L,
                    previewIcon = "theme_2.png"
                ),
                KeyBoard(
                    id = 1231L,
                    categoryId = 1L,
                    previewIcon = "theme_3.png"
                ),
                KeyBoard(
                    id = 12321L,
                    categoryId = 1L,
                    previewIcon = "theme_4.png"
                ),
                KeyBoard(
                    id = 1232561L,
                    categoryId = 1L,
                    previewIcon = "theme_5.png"
                )
            ),
            onKeyBoardClick = {

            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListCategories() {
    ListCategory(
        categories = listOf(
            KeyBoardCategory(
                id = 1L,
                name = "All",
                isSelected = true
            ),
            KeyBoardCategory(
                id = 12L,
                name = "Galaxy",
                isSelected = true
            ),
            KeyBoardCategory(
                id = 123L,
                name = "Animals"
            ),
            KeyBoardCategory(
                id = 1234L,
                name = "Funny"
            )
        ),
        onCategoryClick = {

        }
    )
}
