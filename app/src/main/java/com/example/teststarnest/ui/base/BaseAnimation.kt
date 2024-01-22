package com.example.teststarnest.ui.base

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
internal fun <T>transactionColor(
    state: T,
    condition: (T) -> Boolean,
    defaultColor: Color,
    changedColor: Color
): State<Color> {
    val transition = updateTransition(state, label = "")
    return transition.animateColor(
        transitionSpec = {
            spring(
                stiffness = 50f,
                dampingRatio = 2f
            )
        },
        label = ""
    ) {
        if (condition(it)) changedColor else defaultColor
    }
}