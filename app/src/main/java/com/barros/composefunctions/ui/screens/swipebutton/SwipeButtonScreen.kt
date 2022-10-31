package com.barros.composefunctions.ui.screens.swipebutton

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.barros.composefunctions.R
import com.barros.composefunctions.ui.composable.SwipeButton

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
fun SwipeButtonScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.swipe_button)) },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { paddingValue ->
        SwipeButton(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(paddingValue)
                .padding(24.dp),
            borderStroke = BorderStroke(2.dp, MaterialTheme.colors.secondary),
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            icon = {
                Icon(
                    modifier = Modifier.size(56.dp),
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,
                )
            },
            text = "Swipe",
            textStyle = TextStyle(MaterialTheme.colors.primaryVariant, 24.sp),
            onSwipe = { println("Swipe right") }
        )
    }
}