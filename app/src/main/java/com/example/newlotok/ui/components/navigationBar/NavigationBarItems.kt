package com.example.newlotok.ui.components.navigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ControlPoint
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ControlPoint
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import com.example.newlotok.ui.navigation.LotokScreen

val items = listOf(
    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
        route = LotokScreen.HomeScreen.name
    ),
    BottomNavigationItem(
        title = "Shop",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.HomeScreen.name
    ),
    BottomNavigationItem(
        title = "Add",
        selectedIcon = Icons.Filled.ControlPoint,
        unselectedIcon = Icons.Outlined.ControlPoint,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.SignInScreen.name
    ),
    BottomNavigationItem(
        title = "Favourites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.HomeScreen.name
    ),
    BottomNavigationItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasNews = false,
        badgeCount = 45,
        route = LotokScreen.ProfileScreen.name
    )
)