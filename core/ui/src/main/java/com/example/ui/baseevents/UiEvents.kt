package com.example.ui.baseevents

sealed class UiEvents {
    data object Loading : UiEvents()
    data object Success : UiEvents()
    data object Error : UiEvents()
}