package com.example.newlotok.ui.components.navigationBar

import android.util.Log
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.newlotok.ui.navigation.LotokScreen
import com.example.newlotok.ui.theme.GrayNav
import com.example.newlotok.ui.theme.RedPrimary

@Composable
fun MyNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onAddPostClicked: String = "",
){
    NavigationBar {
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        var previousIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    Log.d("seleced item", selectedItemIndex.toString())
                    if(selectedItemIndex == 2){
                        item.route = onAddPostClicked
                    }
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if(index == selectedItemIndex) RedPrimary
                        else GrayNav,
                        modifier = modifier.then(
                            if(item.title == "Add") modifier.size(42.dp)
                            else modifier
                        )
                    )
                },
                label = {
                    if(item.title != "Add") Text(text = item.title)
                },
            )
        }
    }
}
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
