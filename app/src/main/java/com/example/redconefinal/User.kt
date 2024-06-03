package com.example.redconefinal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String? = null,
    val datetime: String? = null,
    val Location: String? = null,
    val image: String? = null
) : Parcelable
