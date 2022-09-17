package pseudoankit.droid.rating_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
internal fun RatingBarIcon(
    iconConfig: RatingIconConfig,
    activeIconIndex: Int,
    currentIndex: Int,
    onIconSelected: () -> Unit
) {
    Image(
        painter = painterResource(
            id = getIconResource(activeIconIndex, currentIndex, iconConfig.icons)
        ),
        contentDescription = "Star $currentIndex",
        modifier = Modifier
            .width(iconConfig.width)
            .height(iconConfig.height)
            .clickable { onIconSelected() }
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
