package com.example.ui.topbar

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    private var currentScreen by mutableStateOf<Screen?>(null)

    val showSearchBar: Boolean
        get() = currentScreen?.showSearchBar ?: false

    var title: String
        get() = currentScreen?.title.orEmpty()
        set(value) {
            currentScreen?.title = value
        }
}