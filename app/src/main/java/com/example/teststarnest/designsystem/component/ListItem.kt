package com.example.teststarnest.designsystem.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.example.teststarnest.R
import com.example.teststarnest.data.model.*
import com.example.teststarnest.designsystem.theme.*
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
internal fun ColumnScope.ListKeyBoard(
    modifier: Modifier = Modifier,
    title: String,
    isHorizontalView: Boolean = true,
    categories: List<KeyBoard>,
    onKeyBoardClick: (KeyBoard) -> Unit
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Brown
    )
    MarginVertical(16)
    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(
            count = categories.size,
            key = { "keyboard $it" }
        ) {
            ItemKeyBoard(
                keyBoard = categories.getOrNull(it) ?: KeyBoard(),
                onItemClick = onKeyBoardClick
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListKeyBoard() {
    Column {
        ListKeyBoard(
            title = stringResource(id = R.string.what_new_title),
            categories = listOf(
                KeyBoard(
                    id = "123",
                    categoryId = "12",
                    previewIcon = R.drawable.theme_1
                ),
                KeyBoard(
                    id = "123",
                    categoryId = "121",
                    previewIcon = R.drawable.theme_2
                ),
                KeyBoard(
                    id = "1232",
                    categoryId = "123",
                    previewIcon = R.drawable.theme_3
                ),
                KeyBoard(
                    id = "12321",
                    categoryId = "123",
                    previewIcon = R.drawable.theme_4
                ),
                KeyBoard(
                    id = "12321",
                    categoryId = "123",
                    previewIcon = R.drawable.theme_5
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
                id = "1",
                name = "All",
                isSelected = true
            ),
            KeyBoardCategory(
                id = "12",
                name = "Galaxy",
                isSelected = true
            ),
            KeyBoardCategory(
                id = "123",
                name = "Animals"
            ),
            KeyBoardCategory(
                id = "1234",
                name = "Funny"
            )
        ),
        onCategoryClick = {

        }
    )
}
