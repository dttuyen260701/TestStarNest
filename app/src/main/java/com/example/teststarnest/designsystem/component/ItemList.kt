package com.example.teststarnest.designsystem.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.example.teststarnest.R
import com.example.teststarnest.data.model.*
import com.example.teststarnest.designsystem.theme.*
import com.example.teststarnest.ui.base.*
import com.example.teststarnest.until.Constant.DefaultValue.PADDING_HORIZONTAL_SCREEN

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
internal fun ItemCategory(
    modifier: Modifier = Modifier,
    category: KeyBoardCategory,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    textColorSelected: Color = Color.White,
    bgColor: Color = MaterialTheme.colorScheme.background,
    bgColorSelected: List<Color> = listOf(HotPink, AtomicTangerine),
    onItemClick: (KeyBoardCategory) -> Unit
) {
    category.run {
        val textColorAnimation by transactionColor(
            state = isSelected,
            condition = { isSelected },
            defaultColor = textColor,
            changedColor = textColorSelected
        )
        val bgColorAnimation by transactionColor(
            state = isSelected,
            condition = { isSelected },
            defaultColor = bgColor,
            changedColor = bgColorSelected.firstOrNull() ?: Color.Green
        )
        val bgColorSecondAnimation by transactionColor(
            state = isSelected,
            condition = { isSelected },
            defaultColor = bgColor,
            changedColor = bgColorSelected.getOrNull(1) ?: Color.Green
        )
        val bgGradient = Brush.verticalGradient(
            colors = listOf(bgColorAnimation, bgColorSecondAnimation),
        )
        Text(
            text = name, style = MaterialTheme.typography.titleMedium.copy(
                color = textColorAnimation,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    bgGradient,
                    shape = RoundedCornerShape(14.dp)
                )
                .clickable {
                    onItemClick(this@run)
                }
                .padding(horizontal = 8.dp, vertical = 5.dp)
                .then(modifier))
    }
}

@Composable
internal fun ItemKeyBoard(
    modifier: Modifier = Modifier,
    keyBoard: KeyBoard,
    onItemClick: (KeyBoard) -> Unit
) {
    val roundedCornerShape = RoundedCornerShape(14.dp)
    val configuration = LocalConfiguration.current
    val itemWith = configuration.screenWidthDp / 2 - PADDING_HORIZONTAL_SCREEN - 5
    Image(
        painter = painterResource(id = keyBoard.previewIcon),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .width(itemWith.dp)
            .aspectRatio(498f/360f)
            .clip(roundedCornerShape)
            .clickable {
                onItemClick(keyBoard)
            }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewItemKeyBoard() {
    ItemKeyBoard(
        keyBoard = KeyBoard(
            id = 1L,
            categoryId = 0L,
            previewIcon = R.drawable.theme_1
        ),
        onItemClick = {}
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewItemKeyBoardCategory() {
    ItemCategory(
        category = KeyBoardCategory(
            id = 1L,
            name = "Galaxy",
            isSelected = false
        ),
        onItemClick = {

        }
    )
}

