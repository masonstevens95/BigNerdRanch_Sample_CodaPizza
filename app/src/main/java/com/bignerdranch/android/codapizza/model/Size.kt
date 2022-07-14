package com.bignerdranch.android.codapizza.model

import androidx.annotation.StringRes
import com.bignerdranch.android.codapizza.R

enum class Size (
    @StringRes val size: Int
){
    Small(
        size = R.string.small
    ),
    Medium(
        size = R.string.medium
    ),
    Large(
        size = R.string.large
    ),
    ExtraLarge(
        size = R.string.extra_large
    )
}