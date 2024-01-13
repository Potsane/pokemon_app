package com.example.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    fun computation(): CoroutineDispatcher
}