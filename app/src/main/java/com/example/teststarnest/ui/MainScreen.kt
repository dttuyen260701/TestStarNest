package com.example.teststarnest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.lifecycle.compose.*
import com.example.teststarnest.designsystem.component.*
import com.example.teststarnest.ui.feature.keyoards.KeyBoardsScreen

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
internal fun MainScreen(
    viewModel: MainViewModel
) {
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    Scaffold { padding ->
        KeyBoardsScreen(
            modifier = Modifier.padding(padding)
        )
        LoadingDialog(isLoading = isLoading)
    }
}
 