package com.bignerdranch.android.codapizza.model

import android.os.Parcelable
import com.bignerdranch.android.codapizza.model.ToppingPlacement.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pizza (
    val toppings: Map<Topping, ToppingPlacement> = emptyMap(),
    val size: Size = Size.Large
) : Parcelable {

    val price: Double
        get() = size.pizzaPrice + toppings.asSequence()
            .sumOf { (_, toppingPlacement) ->
                when (toppingPlacement){
                    Left, Right -> 0.5
                    All -> 1.0
                }
            }

    fun pizzaSize(size: Size): Pizza{
        return copy(
            size = size
        )
    }

    fun withTopping(topping: Topping, placement: ToppingPlacement?): Pizza {
        return copy(
            toppings = if (placement == null){
                toppings - topping
            }else{
                toppings + (topping to placement)
            }
        )
    }
}