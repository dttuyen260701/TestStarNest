package com.example.teststarnest.data.model

import androidx.room.*
import androidx.room.ForeignKey.Companion.CASCADE
import com.example.teststarnest.data.enums.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = KeyBoardCategory::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = CASCADE
        )
    ]
)
data class KeyBoard(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo val categoryId: Long = 0L,
    @ColumnInfo val previewIcon: Int = 0,
    @ColumnInfo val type: KeyBoardType = KeyBoardType.OTHER
)
