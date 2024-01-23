package com.example.teststarnest.data.model

import androidx.room.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Entity
data class KeyBoardCategory(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo val name: String = "",
    var isSelected: Boolean = false
)
