package pseudoankit.droid.rating_bar

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import kotlin.math.roundToInt

const val TAG = "dRatingBar"

@Composable
fun RatingBar(
    config: RatingBarConfig = RatingBarConfig()
) {
    var activeIcon by remember { mutableStateOf(0) }
    var iconWidth by remember { mutableStateOf(0) }
    var currentDragAmount by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .height(config.iconConfig.height)
    ) {
        Row(
            modifier = Modifier
                .onSizeChanged { iconWidth = it.width / config.iconCount }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragStart = {
                            currentDragAmount = it.x
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            currentDragAmount += dragAmount

                            val currentIcon = (currentDragAmount / iconWidth).roundToInt()

                            if (currentIcon != activeIcon) {
                                activeIcon = currentIcon
                            }
                        }
                    )
                },
            horizontalArrangement = Arrangement.Center
        ) {
            DrawRatingBarIcons(config, activeIcon) { activeIcon = it }
        }
    }
}