package com.example.teststarnest.designsystem.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.*
import com.example.teststarnest.until.Constant.DefaultValue.PADDING_HORIZONTAL_SCREEN

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
fun LoadingDialog(
    title: String? = null,
    isLoading: Boolean = false,
) {
    if (isLoading) {
        Dialog(
            onDismissRequest = { },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(PADDING_HORIZONTAL_SCREEN.dp)
            ) {
                title?.let {
                    Text(title)
                    Spacer(modifier = Modifier.height(PADDING_HORIZONTAL_SCREEN.dp))
                }
                CircularProgressIndicator()
            }
        }
    }
}
