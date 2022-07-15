package com.bignerdranch.android.codapizza.model

import androidx.annotation.StringRes
import com.bignerdranch.android.codapizza.R

enum class Size (
    @StringRes val pizzaSize: Int
){
    Small(
        pizzaSize = R.string.small
    ),
    Medium(
        pizzaSize = R.string.medium
    ),
    Large(
        pizzaSize = R.string.large
    ),
    ExtraLarge(
        pizzaSize = R.string.extra_large
    )
}