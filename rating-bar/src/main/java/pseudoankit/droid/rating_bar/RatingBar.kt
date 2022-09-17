package pseudoankit.droid.rating_bar

import android.util.Log
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
    var activeIconIndex by remember { mutableStateOf(0) }
    var iconWidth by remember { mutableStateOf(0) }
    var finalDragAmt by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .height(config.iconConfig.height)
    ) {
        Row(
            modifier = Modifier
                .onSizeChanged { iconWidth = it.width / config.iconCount }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragCancel = {},
                        onDragEnd = {},
                        onDragStart = {
                            finalDragAmt = it.x
                        },
                        onHorizontalDrag = { _, dragAmount ->

                            finalDragAmt += dragAmount
                            Log.d("$TAG Dragging", "DragAmount: $finalDragAmt")

                            val iconIdx = (finalDragAmt / iconWidth).roundToInt()
                            Log.d(TAG, "dragIconIdx: $iconIdx")

                            if (iconIdx != activeIconIndex) {
                                activeIconIndex = iconIdx
                            }
                        }
                    )
                },
            horizontalArrangement = Arrangement.Center
        ) {
            DrawRatingBarIcons(config, activeIconIndex) { activeIconIndex = it }
        }
    }
}