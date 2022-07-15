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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.android.codapizza.model.Size
import com.bignerdranch.android.codapizza.model.Size.*

@Preview
@Composable
fun PizzaSizeDropdownPreview(){
    PizzaSizeDropdown(
        modifier = Modifier
            .fillMaxWidth()
//            .weight(1f, fill = true)
    )
}

@Composable
fun PizzaSizeDropdown(
    modifier: Modifier
){
    LazyColumn(modifier = Modifier.size(200.dp)){
        items(Size.values()) { size ->
            DropdownMenuItem(
                onClick = { /*TODO*/ },
                modifier
            ) {
                Text(
                    text = stringResource(size.pizzaSize),
                    style = MaterialTheme.typography.body1
                )
            }

        }
    }
}