package com.example.bankui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankui.Data.currency
import com.example.bankui.ui.theme.GreenStart

val currencies = listOf(
    currency(
        name = "USD",
        buy = 12.0f,
        sell = 45.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "EUR",
        buy = 13.5f,
        sell = 50.0f,
        icon = Icons.Rounded.Euro
    ),
    currency(
        name = "GBP",
        buy = 14.2f,
        sell = 55.0f,
        icon = Icons.Rounded.CurrencyPound
    ),
    currency(
        name = "JPY",
        buy = 0.11f,
        sell = 0.15f,
        icon = Icons.Rounded.CurrencyYen
    ),
    currency(
        name = "AUD",
        buy = 9.0f,
        sell = 30.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "CAD",
        buy = 10.0f,
        sell = 35.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "CHF",
        buy = 15.0f,
        sell = 60.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "CNY",
        buy = 1.8f,
        sell = 3.5f,
        icon = Icons.Rounded.CurrencyYen
    ),
    currency(
        name = "INR",
        buy = 0.12f,
        sell = 0.22f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "NZD",
        buy = 8.5f,
        sell = 28.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "SGD",
        buy = 10.5f,
        sell = 38.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "HKD",
        buy = 1.5f,
        sell = 4.0f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "ZAR",
        buy = 0.6f,
        sell = 1.2f,
        icon = Icons.Rounded.AttachMoney
    ),
    currency(
        name = "KRW",
        buy = 0.008f,
        sell = 0.012f,
        icon = Icons.Rounded.CurrencyYen
    ),
    currency(
        name = "MXN",
        buy = 0.5f,
        sell = 2.0f,
        icon = Icons.Rounded.AttachMoney
    )
)

@Preview
@Composable
fun CurrencySection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (isVisible) {
                            Icons.Rounded.KeyboardArrowUp
                        } else {
                            Icons.Rounded.KeyboardArrowDown
                        }
                    }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Show more",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Text(
                text = "Currencies",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )
        if (isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val boxWithConstraintsScope = this
                val with = boxWithConstraintsScope.maxWidth / 3
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .width(with),
                            text = "Currency",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier
                                .width(with),
                            text = "Buy",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                        Text(
                            modifier = Modifier
                                .width(with),
                            text = "Sell",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(currencies.size) { index ->
                            CurrencyItem(
                                index = index,
                                width = 0.dp
                            )
                        }
                    }
                }
            }
        }
    }
}}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencies[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Currency Icon and Name
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .size(32.dp)
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = currency.icon,
                    contentDescription = "${currency.name} Icon",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = currency.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Text(
            text = "$ ${currency.buy}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "$ ${currency.sell}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1f)
        )
    }
}
