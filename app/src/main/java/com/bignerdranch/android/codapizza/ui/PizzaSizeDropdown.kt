package com.bignerdranch.android.codapizza.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.codapizza.R
import com.bignerdranch.android.codapizza.model.Size
import com.bignerdranch.android.codapizza.model.Size.*
import com.bignerdranch.android.codapizza.model.ToppingPlacement
import java.text.NumberFormat

@Preview
@Composable
fun PizzaSizeDropdownPreview(){
    PizzaSizeDropdown(
        modifier = Modifier
            .fillMaxWidth(),
        onSetPizzaSize = {},
        onDismissRequest = {}
    )
}

@Composable
fun PizzaSizeDropdown(
    modifier: Modifier,
    onSetPizzaSize: (size: Size) -> Unit,
    onDismissRequest: () -> Unit
){
    LazyColumn(modifier = Modifier.size(200.dp)){
        items(Size.values()) { size ->
            DropdownMenuItem(
                onClick = {
                    onSetPizzaSize(size)
                    onDismissRequest()
                  },
                modifier
            ) {
                val sizeStr = stringResource(size.pizzaSize)
                val currencyFormatter = remember { NumberFormat.getCurrencyInstance()}
                val price = currencyFormatter.format(size.pizzaPrice)
                Text(
                    text = stringResource(R.string.size_prompt, sizeStr, price),
                    style = MaterialTheme.typography.body1
                )
            }

        }
    }
}