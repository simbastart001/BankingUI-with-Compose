package com.example.bankappui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.GetApp
import androidx.compose.material.icons.rounded.Start
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bankappui.data.Finance
import com.example.bankappui.ui.theme.BlueStart
import com.example.bankappui.ui.theme.GreenStart
import com.example.bankappui.ui.theme.OrangeStart
import com.example.bankappui.ui.theme.PurpleStart
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

val finances = listOf(
    Finance(
        icon = Icons.Rounded.Start,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.CreditCard,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.Calculate,
        name = "Finance\nAnalytics",
        background = GreenStart
    ),
    Finance(
        icon = Icons.Rounded.GetApp,
        name = "My\nTransactions",
        background = PurpleStart
    )
)

@Preview
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(finances.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(
    index: Int
) {
    val finance = finances[index]
    var lastPaddingItem = 0.dp
    if (index == finances.size - 1) {
        lastPaddingItem = 16.dp
    }
    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingItem)) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(130.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
            )
        }
    }
}








