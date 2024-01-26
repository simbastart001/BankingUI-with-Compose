package com.example.bankappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappui.data.Card
import com.example.bankappui.ui.theme.BlueEnd
import com.example.bankappui.ui.theme.BlueStart
import com.example.bankappui.ui.theme.GreenEnd
import com.example.bankappui.ui.theme.GreenStart
import com.example.bankappui.ui.theme.OrangeEnd
import com.example.bankappui.ui.theme.OrangeStart
import com.example.bankappui.ui.theme.PurpleEnd
import com.example.bankappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "**** **** **** 1234",
        cardName = "Credit",
        balance = 10000.00,
        color = getColor(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "**** **** **** 5562",
        cardName = "Business",
        balance = 963600.00,
        color = getColor(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "**** **** **** 6354",
        cardName = "Debit",
        balance = 86400.00,
        color = getColor(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "**** **** **** 7724",
        cardName = "Savings",
        balance = 324000.00,
        color = getColor(GreenStart, GreenEnd)
    )
)

fun getColor(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}


@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index = index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTERCARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPadding)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardType,
                modifier = Modifier
                    .width(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}