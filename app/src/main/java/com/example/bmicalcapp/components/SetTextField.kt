package com.example.bmicalcapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SetTextField(
    value:String,
    onValueChange:(String) -> Unit,
    label:String,
    placeholder:String,
){
    Text(
        text = label,
        color= Color.Red,
        fontWeight = FontWeight.Bold,
    )
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
    )
}