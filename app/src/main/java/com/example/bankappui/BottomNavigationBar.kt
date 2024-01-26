package com.example.bankappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import com.example.bankappui.data.BottomNavigation
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Preview
@Composable
fun BottomNavigationBar() {
    NavigationBar(
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed() { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = index == 0,
                    onClick = {
                    }
                )
            }
        }
    }
}











