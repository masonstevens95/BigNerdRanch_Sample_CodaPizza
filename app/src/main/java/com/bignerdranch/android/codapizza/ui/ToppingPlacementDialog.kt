package com.bignerdranch.android.codapizza.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ToppingPlacementDialog () {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .size(64.dp)
        )
    }
}