package com.bignerdranch.android.codapizza.model

import androidx.annotation.StringRes
import com.bignerdranch.android.codapizza.R

enum class Size (
    @StringRes val pizzaSize: Int,
    val pizzaPrice: Double
){
    Small(
        pizzaSize = R.string.small,
        pizzaPrice = 7.99
    ),
    Medium(
        pizzaSize = R.string.medium,
        pizzaPrice = 8.99
    ),
    Large(
        pizzaSize = R.string.large,
        pizzaPrice = 9.99
    ),
    ExtraLarge(
        pizzaSize = R.string.extra_large,
        pizzaPrice = 10.99
    )
}