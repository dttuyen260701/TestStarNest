package com.example.teststarnest.data.model

import androidx.annotation.*
import androidx.room.*
import com.example.teststarnest.data.enums.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Entity
data class KeyBoard(
    @PrimaryKey(autoGenerate = true) val id: String = "",
    @ColumnInfo(name = "category_id") val categoryId: String = "",
    @ColumnInfo(name = "preview_icon") @DrawableRes val previewIcon: Int = 0,
    @ColumnInfo(name = "Key_board_type") val type: KeyBoardType = KeyBoardType.OTHER,
    @ColumnInfo(name = "Key_board_color") val color: KeyBoardColor = KeyBoardColor.BLACK
)
