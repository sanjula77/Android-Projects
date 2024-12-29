package com.example.lazylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(MainActivity.items) { index, item ->
            ColumnItems(item = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ColumnItems(item: Item) {
    Column(modifier = Modifier
        .height(250.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
            painter = painterResource(id = item.imageResId),
            contentDescription = item.title,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            fontWeight = FontWeight.SemiBold
        )
    }
}