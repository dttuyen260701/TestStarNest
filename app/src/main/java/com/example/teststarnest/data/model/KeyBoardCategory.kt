package com.example.teststarnest.data.model

import androidx.room.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Entity
data class KeyBoardCategory(
    @PrimaryKey val id: String = "",
    @ColumnInfo val name: String = "",
    val isSelected: Boolean = false
)
