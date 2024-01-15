package com.example.ui.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Stable
class AppTopBarState(
    navHostController: NavHostController,
    scope: CoroutineScope
) {

    init {
        navHostController.currentBackStackEntryFlow
            .distinctUntilChanged()
            .onEach {
                val route = it.destination.route
                currentScreen = getScreen(route)
            }
            .launchIn(scope)
    }

    var currentScreen by mutableStateOf<Screen?>(null)
        private set

    val leadingIcon: ImageVector
        get() = currentScreen?.navigationIcon ?: Icons.Default.Home

    val showLeadingIcon: Boolean
        get() = currentScreen?.showLeadingIcon ?: false

    val showSearchBar: Boolean
        get() = currentScreen?.showSearchBar ?: true

    val title: String
        get() = currentScreen?.title.orEmpty()

    val backgroundColor: Color
        get() = currentScreen?.backgroundColor ?: Color(-4147000)

}