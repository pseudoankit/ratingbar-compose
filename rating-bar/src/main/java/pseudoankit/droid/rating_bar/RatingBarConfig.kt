package pseudoankit.droid.rating_bar

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 *
 */
data class RatingBarConfig(
    val activeIconIndex: Int = 0,
    val iconConfig: RatingBarIconConfig = RatingBarIconConfig.Default,
    val iconCount: Int = 5,
    val iconSpacing: Dp = 8.dp,
) {
    val iconsCountRange: IntRange = 1..iconCount
}

data class RatingBarIcon(
    val color: Color = Color.Unspecified,
    @DrawableRes val icon: Int = android.R.drawable.star_off
)

data class RatingBarIconConfig(
    val width: Dp = DEFAULT_ICON_SIZE,
    val height: Dp = DEFAULT_ICON_SIZE,
    val inactive: RatingBarIcon,
    val active: RatingBarIcon
) {
    companion object {
        val Default = RatingBarIconConfig(
            inactive = RatingBarIcon(color = Color.Gray),
            active = RatingBarIcon(color = Color.Yellow)
        )
    }
}