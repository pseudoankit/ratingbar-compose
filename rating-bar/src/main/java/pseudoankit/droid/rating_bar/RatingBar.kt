package pseudoankit.droid.rating_bar

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize

@Composable
fun RatingBar(
    config: RatingBarConfig = RatingBarConfig()
) {
    var activeIconIndex by remember { mutableStateOf(0) }
    var rowWidth by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .createRatingBarModifier(config) { rowWidth = it.width }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {},
                    onDragCancel = {},
                    onDragStart = {},
                    onHorizontalDrag = { _, dragAmount: Float ->
                        //Log.d("RatingBar", "RatingBar: $dragAmount")
                    }
                )
            },
        horizontalArrangement = Arrangement.Center
    ) {
        DrawRatingBarIcons(config, activeIconIndex) { activeIconIndex = it }
    }
}

private fun Modifier.createRatingBarModifier(
    config: RatingBarConfig,
    onSizeChanged: (IntSize) -> Unit
) = this
    .height(config.iconConfig.height)
    .padding(paddingValues = config.padding)
    .onSizeChanged(onSizeChanged)