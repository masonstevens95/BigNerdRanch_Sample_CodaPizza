package com.bignerdranch.android.codapizza.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.android.codapizza.model.Size


@Composable
fun PizzaSizeDropdown(

){

//    var expanded by rememberSaveable { mutableStateOf<Boolean>(false) }
//    val items = Map<Size>()
//    val disabledValue = "B"
//    var selectedIndex by rememberSaveable { mutableStateOf(0) }
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
////            .weight(1f, fill = true)
//            .background(Color.Blue)
//    ){
//        DropdownMenu(
//            expanded = true,
//            onDismissRequest = { /*TODO*/ }) {
//                items.forEachIndexed { index, s ->
//                    DropdownMenuItem(onClick = {
//                        selectedIndex = index
//                        expanded = false
//                    }) {
//                        val disabledText = if (s == disabledValue) {
//                            " (Disabled)"
//                        } else {
//                            ""
//                        }
//                        Text(text = s + disabledText)
//                    }
//        }
//    }
}