package com.bignerdranch.android.codapizza.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.codapizza.R
import com.bignerdranch.android.codapizza.model.Pizza
import com.bignerdranch.android.codapizza.model.Size
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

    var onClickDropdown by rememberSaveable {
        mutableStateOf(false)

    }

    Column(modifier = modifier) {
        //start of a custom dropdown for pizza sizes, adding to the price.
//        PizzaSizeDropdownMenu(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f, fill = true)
//
//        )


        PizzaSizeDropdown(
            modifer = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true),
            showDropdown = showDropdown
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
private fun PizzaSizeDropdown(
    modifer: Modifier = Modifier,
    onClickDropdown: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp)
            .background(Color.Blue),

        ){
        Text(
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .clickable(onClick = { showDropdown = !showDropdown }),
            text = "Test",
        )
        DropdownMenu(
            expanded = showDropdown,
            onDismissRequest = { showDropdown = false }
        ) {

            LazyColumn(modifier = Modifier) {

            }

            DropdownMenuItem(
                modifier = Modifier
                    .fillMaxWidth(),
//                        .weight(1f, fill = true),
                onClick = { showDropdown = false }
            ) {
                Text(
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp)
                    ,
                    text = "Test item"
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