package com.example.newlotok.ui.components.navigationBar

import androidx.compose.foundation.layout.size
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
import com.example.lotok.ui.theme.GrayNav
import com.example.lotok.ui.theme.RedPrimary

@Composable
fun MyNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
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
