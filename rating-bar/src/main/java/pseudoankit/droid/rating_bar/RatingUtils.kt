package pseudoankit.droid.rating_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

val DEFAULT_ICON_SIZE = 50.dp

private fun isActive(activeIndex: Int, currentIndex: Int) = currentIndex <= activeIndex

fun RatingBarIconConfig.getIconColor(
    activeIconIndex: Int, currentIconIndex: Int
) = if (isActive(activeIconIndex, currentIconIndex)) {
    activeIcon.color
} else {
    inactiveIcon.color
}

fun RatingBarIconConfig.getIconResource(
    activeIndex: Int, currentIndex: Int
) = if (isActive(activeIndex, currentIndex)) {
    activeIcon.icon
} else {
    inactiveIcon.icon
}

fun Modifier.noRippleClick(onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}