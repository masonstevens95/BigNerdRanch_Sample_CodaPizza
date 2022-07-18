package com.bignerdranch.android.codapizza.ui

import PizzaHeroImage
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.codapizza.R
import com.bignerdranch.android.codapizza.model.Pizza
import com.bignerdranch.android.codapizza.model.Topping
import java.text.NumberFormat

@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier
){
    var pizza by rememberSaveable {
        mutableStateOf(Pizza())
    }

    Column(modifier = modifier) {

        PizzaSizeDropdownList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true),
            pizza = pizza,
            onEditPizza = {pizza = it}
        )

        ToppingsList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true),
            pizza = pizza,
            onEditPizza = {pizza = it}
        )

        OrderButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            pizza = pizza
        )
    }
}

@Composable
private fun PizzaSizeDropdownList(
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit
){
//    Log.d("PizzaSizeDropdownList", "Called PizzaSizeDropdownList")

    var showDropdown by rememberSaveable {
        mutableStateOf(false)

    }

    //Wrapper for dropdown menu
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .size(64.dp)
            .padding(4.dp),
        onClick = { showDropdown = !showDropdown }
    ){

        //sample text
        val sizeStr = stringResource(pizza.size.pizzaSize)

        Text(
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp),
            text = stringResource(R.string.dropdown, sizeStr),
        )

        //When dropdown is opened, show dropdown menu at max width.
        if(showDropdown){
//            Log.d("PizzaSizeDropdownList", "Called showDropdown")
            DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 16.dp),
                expanded = showDropdown,
                onDismissRequest = { showDropdown = false }
            ) {

                //separate component with lazylist and dropdown items
                PizzaSizeDropdown(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onSetPizzaSize = { size ->
                       onEditPizza(pizza.pizzaSize(size))
                    },
                    onDismissRequest = {showDropdown = false}
                )
            }
        }



    }
}

@Composable
private fun ToppingsList (
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit
){
    var toppingBeingAdded by rememberSaveable { mutableStateOf<Topping?>(null)}

    toppingBeingAdded?.let { topping ->
        ToppingPlacementDialog(
            topping = topping,
            onSetToppingPlacement = {placement ->
                onEditPizza(pizza.withTopping(topping, placement))
            },
            onDismissRequest = {
                toppingBeingAdded = null
            }
        )
    }

    LazyColumn(modifier = modifier){

        item {
            PizzaHeroImage(
                pizza = pizza,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(Topping.values()) { topping ->
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {
                    toppingBeingAdded = topping
                }
            )
        }
    }
}

@Composable
private fun OrderButton(
    modifier: Modifier = Modifier,
    pizza : Pizza
){
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        val currencyFormatter = remember {NumberFormat.getCurrencyInstance()}
        val price = currencyFormatter.format(pizza.price)
        Text(
            text = stringResource(R.string.place_order_button, price)
                .toUpperCase(Locale.current)
        )
    }
}