package com.example.ui.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(appBarState: AppTopBarState) {

    val title = @Composable { Text(text = appBarState.title) }

    if (appBarState.showSearchBar) {
        MediumTopAppBar(
            title = title,
            actions = {
                SearchBar(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        )
    }
}