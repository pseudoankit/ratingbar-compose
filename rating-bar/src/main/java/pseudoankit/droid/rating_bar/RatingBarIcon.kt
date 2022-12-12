package pseudoankit.droid.rating_bar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
internal fun RatingBarIcon(
    config: RatingBarIconConfig,
    activeIconIndex: Int,
    currentIconIndex: Int,
    onIconSelected: (Int) -> Unit
) {
    Icon(
        painter = painterResource(
            id = config.getIconResource(activeIconIndex, currentIconIndex)
        ),
        contentDescription = "RatingIcon $currentIconIndex",
        tint = config.getIconColor(activeIconIndex, currentIconIndex),
        modifier = Modifier
            .width(config.width)
            .height(config.height)
            .noRippleClick { onIconSelected(currentIconIndex) },
    )
}