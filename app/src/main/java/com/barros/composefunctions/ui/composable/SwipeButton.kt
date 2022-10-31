@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)

package com.barros.composefunctions.ui.composable

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barros.composefunctions.ui.theme.ComposeFunctionsTheme
import kotlin.math.roundToInt

@Composable
fun SwipeButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    backgroundColor: Color = Color.White,
    borderStroke: BorderStroke = BorderStroke(2.dp, Color.Black),
    elevation: Dp = 8.dp,
    icon: @Composable () -> Unit,
    text: String,
    textStyle: TextStyle = TextStyle(Color.Black, 20.sp),
    onSwipe: () -> Unit
) {
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val textAlpha by animateFloatAsState(
        if (swipeableState.offset.value > 10f) (1 - swipeableState.progress.fraction) else 1f
    )

    if (swipeableState.isAnimationRunning) {
        DisposableEffect(Unit) {
            onDispose {
                if (swipeableState.currentValue == 1) {
                    onSwipe()
                }
            }
        }
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        color = backgroundColor,
        border = borderStroke,
        elevation = elevation
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            var iconSize by remember { mutableStateOf(IntSize.Zero) }
            val maxWidth = with(LocalDensity.current) {
                this@BoxWithConstraints.maxWidth.toPx() - iconSize.width
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                textAlign = TextAlign.End,
                text = text,
                style = textStyle.copy(color = textStyle.color.copy(alpha = textAlpha))
            )
            Box(
                modifier = Modifier
                    .onGloballyPositioned {
                        iconSize = it.size
                    }
                    .swipeable(
                        state = swipeableState,
                        anchors = mapOf(
                            0f to 0,
                            maxWidth to 1
                        ),
                        thresholds = { _, _ -> FractionalThreshold(0.9f) },
                        orientation = Orientation.Horizontal
                    )
                    .offset {
                        IntOffset(swipeableState.offset.value.roundToInt(), 0)
                    }
            ) {
                icon()
            }
        }
    }
}

@Preview
@Composable
fun SwipeButtonPreview() {
    ComposeFunctionsTheme {
        Surface {
            SwipeButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                icon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        modifier = Modifier.size(56.dp),
                        contentDescription = null
                    )
                },
                text = "Swipe",
                onSwipe = {}
            )
        }
    }
}