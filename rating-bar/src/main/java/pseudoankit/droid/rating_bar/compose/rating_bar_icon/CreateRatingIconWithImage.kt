package pseudoankit.droid.rating_bar.compose.rating_bar_icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import pseudoankit.droid.rating_bar.compose.RatingIconConfig
import pseudoankit.droid.rating_bar.util.RatingUtils

@Composable
internal fun CreateRatingIconWithImage(
    activeIndex: Int,
    currentIndex: Int,
    iconConfig: RatingIconConfig.Image,
    onIconSelected: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Image(
        painter = painterResource(
            id = getImageResource(activeIndex, currentIndex, iconConfig)
        ),
        contentDescription = "Star $currentIndex",
        modifier = Modifier
            .width(iconConfig.width)
            .height(iconConfig.height)
            .clickable(
                indication = null, interactionSource = interactionSource, onClick = onIconSelected
            )
    )
}

private fun getImageResource(
    activeIndex: Int, currentIndex: Int, icons: RatingIconConfig.Image
) = if (RatingUtils.isActive(activeIndex, currentIndex)) {
    icons.active
} else {
    icons.inactive
}