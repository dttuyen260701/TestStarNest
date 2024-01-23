package com.example.teststarnest.ui.feature.keyoards

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.hilt.navigation.compose.*
import androidx.lifecycle.compose.*
import com.example.teststarnest.R
import com.example.teststarnest.designsystem.component.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Composable
internal fun KeyBoardsScreen(
    modifier: Modifier = Modifier,
    viewModel: KeyBoardsViewModel = hiltViewModel()
) {
    viewModel.run {
        val uiState by uiStateFlow.collectAsStateWithLifecycle()
        KeyBoardsContent(
            modifier = modifier,
            uiState = uiState,
            handleEvent = ::handleEvent
        )
    }
}

@Composable
private fun KeyBoardsContent(
    modifier: Modifier = Modifier,
    uiState: KeyBoardUiState,
    handleEvent: (KeyBoardsEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MarginVertical(24)
        Text(
            text = stringResource(id = R.string.themes_title),
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        MarginVertical(24)
        ListCategory(
            categories = uiState.categories,
            onCategoryClick = {
                handleEvent(KeyBoardsEvent.ChoiceCategory(it.id))
            }
        )
        MarginVertical(20)
        ListKeyBoard(
            title = stringResource(id = R.string.what_new_title),
            keyboards = uiState.keyboardNew,
            onKeyBoardClick = {

            }
        )
        MarginVertical(20)
        ListKeyBoard(
            title = stringResource(id = R.string.you_may_also_like),
            isHorizontalView = false,
            keyboards = uiState.keyboardNew,
            onKeyBoardClick = {

            }
        )
    }
}
