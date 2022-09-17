package pseudoankit.droid.rating_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
internal fun RatingBarIcon(
    iconConfig: RatingIconConfig,
    activeIconIndex: Int,
    currentIndex: Int,
    onIconSelected: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Image(
        painter = painterResource(
            id = getIconResource(activeIconIndex, currentIndex, iconConfig.icons)
        ),
        contentDescription = "Star $currentIndex",
        modifier = Modifier
            .width(iconConfig.width)
            .height(iconConfig.height)
            .clickable(
                indication = null,
                interactionSource = interactionSource,
                onClick = onIconSelected
            )
    )
}

private fun getIconResource(
    activeIconIndex: Int,
    currentIconIndex: Int,
    icons: RatingIcons
) = if (currentIconIndex <= activeIconIndex) {
    icons.active
} else {
    icons.inactive
}
