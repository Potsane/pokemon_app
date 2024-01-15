package com.example.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: String,
    val name: String,
    val avatarUrl: String,
    var backgroundColor: Int = 0
) : Parcelable