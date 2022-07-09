package com.barros.composefunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.barros.composefunctions.ui.composables.SwipeButton
import com.barros.composefunctions.ui.theme.ComposeFunctionsTheme

@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFunctionsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SwipeButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(24.dp),
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.ArrowForward,
                                modifier = Modifier.size(60.dp),
                                contentDescription = null
                            )
                        },
                        text = "Swipe",
                        onSwipe = {
                            println("Swipe right")
                        }
                    )
                }
            }
        }
    }
}