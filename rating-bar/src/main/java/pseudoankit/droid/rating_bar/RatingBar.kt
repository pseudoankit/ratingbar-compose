package pseudoankit.droid.rating_bar

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import kotlin.math.roundToInt

@Composable
fun RatingBar(
    config: RatingBarConfig = RatingBarConfig(),
    onIconSelected: (newActiveIndex: Int) -> Unit
) {
    var iconWidth by remember { mutableStateOf(0) }
    var currentDragAmount by remember { mutableStateOf(0f) }

    fun updateSelectedRatingIcon(iconIndex: Int) {
        if (iconIndex == config.activeIconIndex) return
        onIconSelected(iconIndex)
    }

    // wrapped with box with width as wrap content, to ensure row width calculation is not affected
    Box {
        Row(modifier = Modifier
            .onSizeChanged { iconWidth = it.width / config.iconCount }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(onDragStart = {
                    currentDragAmount = it.x
                }, onHorizontalDrag = { _, dragAmount ->
                    currentDragAmount += dragAmount

                    val iconIndex = ((currentDragAmount / iconWidth) + .4f).roundToInt()
                    updateSelectedRatingIcon(iconIndex)
                })
            }, horizontalArrangement = Arrangement.Center
        ) {
            RatingBarIcons(config, ::updateSelectedRatingIcon)
        }
    }
}

@Composable
private fun RatingBarIcons(
    config: RatingBarConfig, onIconSelected: (newActiveIndex: Int) -> Unit
) {
    config.iconsCountRange.forEach { currentIconIndex ->
        Spacer(modifier = Modifier.width(config.iconSpacing))
        RatingBarIcon(
            config = config.iconConfig,
            activeIconIndex = config.activeIconIndex,
            currentIconIndex = currentIconIndex,
            onIconSelected = onIconSelected
        )
    }
}
