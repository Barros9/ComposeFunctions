package com.barros.composefunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        }
    }
}