package pseudoankit.droid.rating_bar

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import kotlin.math.roundToInt

/**
 * rating bar for compose
 * @param[config] rating bar configuration
 * @param[onIconSelected] callback when active rating icon is changed with current selected rating index as parameter
 * activeIndex would be in range 1..iconCount from config
 */
@Composable
fun RatingBar(
    config: RatingBarConfig = RatingBarConfig(),
    onIconSelected: (activeIndex: Int) -> Unit
) {
    var activeIconIndex by remember(config.activeIconIndex) { mutableStateOf(config.activeIconIndex) }
    var iconWidth by remember { mutableStateOf(0) }
    var currentDragAmount by remember { mutableStateOf(0f) }

    fun updateSelectedRatingIcon(iconIndex: Int) {
        if (iconIndex == activeIconIndex) return

        Log.d(TAG, "UpdateSelectedRatingIcon: selected: $iconIndex, active : $activeIconIndex")

        activeIconIndex = iconIndex
        onIconSelected(iconIndex)
    }

    // wrapped with box with width as wrap content, to ensure row width calculation is not affected
    Box {
        Row(
            modifier = Modifier
                .onSizeChanged { iconWidth = it.width / config.iconCount }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragStart = { offset ->
                            currentDragAmount = offset.x
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            currentDragAmount += dragAmount

                            val iconIndex = (currentDragAmount / iconWidth).roundToInt()
                            updateSelectedRatingIcon(iconIndex)
                        }
                    )
                },
            horizontalArrangement = Arrangement.Center
        ) {
            RatingBarIcons(config, activeIconIndex) { updateSelectedRatingIcon(it) }
        }
    }
}

@Composable
private fun RatingBarIcons(
    config: RatingBarConfig,
    activeIconIndex: Int,
    onIconSelected: (Int) -> Unit
) {
    config.iconsCountRange.forEach { currentIndex ->
        RatingBarIcon(config.iconConfig, activeIconIndex, currentIndex) {
            onIconSelected(currentIndex)
        }
        if (currentIndex != config.iconsCountRange.last) {
            Spacer(modifier = Modifier.width(config.iconSpacing))
        }
    }
}