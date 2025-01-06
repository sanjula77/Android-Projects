package com.example.nttest.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NameSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "My Notes",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        Icon(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Add",
            Modifier.size(35.dp)
        )
    }
    Divider(modifier = Modifier.padding(top = 8.dp))
}