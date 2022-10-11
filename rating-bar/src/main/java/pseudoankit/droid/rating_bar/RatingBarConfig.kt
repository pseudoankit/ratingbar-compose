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
    val iconConfig: RatingBarIconConfig = RatingBarIconConfig(),
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
    @DrawableRes val inactiveIcon: Int,
    @DrawableRes val activeIcon: Int,
    val inactiveColor: Color,
    val activeColor: Color
) {

    constructor(
        width: Dp = DEFAULT_ICON_SIZE,
        height: Dp = DEFAULT_ICON_SIZE,
        @DrawableRes inactiveIcon: Int,
        @DrawableRes activeIcon: Int,
    ) : this(width, height, inactiveIcon, activeIcon, Color.Unspecified, Color.Unspecified)

    constructor(
        width: Dp = DEFAULT_ICON_SIZE,
        height: Dp = DEFAULT_ICON_SIZE,
        @DrawableRes ratingIcon: Int = android.R.drawable.star_off,
        inactiveColor: Color = Color.Gray,
        activeColor: Color = Color.Yellow
    ) : this(width, height, ratingIcon, ratingIcon, inactiveColor, activeColor)
}