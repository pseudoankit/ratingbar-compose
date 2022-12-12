package pseudoankit.droid.rating_bar

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * configuration for rating bar
 * @param[activeIconIndex] index of rating icon to be highlighted initially
 * activeIconIndex == zero indicated no icons will highlighted
 * activeIconIndex should be in range 0..iconCount
 * @param[iconCount] count of rating icon to show
 * @param[iconSpacing] spacing between two rating icon
 */
@Immutable
data class RatingBarConfig(
    val activeIconIndex: Int = 0,
    val iconConfig: RatingBarIconConfig = RatingBarIconConfig(),
    val iconCount: Int = 5,
    val iconSpacing: Dp = 8.dp,
) {
    val iconsCountRange: IntRange = 1..iconCount
}


/**
 * configuration for rating bar icon
 * @param[width] width of each icon
 * @param[height] height of each icon
 * @param[inactiveIcon] icon configuration for unselected icon
 * @param[activeIcon] icon configuration for selected icon
 */
@Immutable
data class RatingBarIconConfig(
    val width: Dp = DEFAULT_ICON_SIZE,
    val height: Dp = DEFAULT_ICON_SIZE,
    val inactiveIcon: RatingBarIcon,
    val activeIcon: RatingBarIcon
) {

    /**
     * @param[width] width of each icon
     * @param[height] height of each icon
     * @param[ratingIcon] drawable for a rating icon
     * @param[inactiveColor] color of icon when inactive
     * @param[activeColor] color of icon when active
     */
    constructor(
        width: Dp = DEFAULT_ICON_SIZE,
        height: Dp = DEFAULT_ICON_SIZE,
        @DrawableRes ratingIcon: Int = android.R.drawable.star_off,
        inactiveColor: Color = Color.Gray,
        activeColor: Color = Color.Yellow
    ) : this(
        width = width,
        height = height,
        activeIcon = RatingBarIcon(color = activeColor, icon = ratingIcon),
        inactiveIcon = RatingBarIcon(color = inactiveColor, icon = ratingIcon)
    )

    /**
     * @param[width] width of each icon
     * @param[height] height of each icon
     * @param[inactiveIcon] drawable for rating icon when inactive
     * @param[activeIcon] drawable for rating icon when active
     */
    constructor(
        width: Dp = DEFAULT_ICON_SIZE,
        height: Dp = DEFAULT_ICON_SIZE,
        @DrawableRes inactiveIcon: Int,
        @DrawableRes activeIcon: Int,
    ) : this(
        width = width,
        height = height,
        activeIcon = RatingBarIcon(icon = activeIcon, color = Color.Unspecified),
        inactiveIcon = RatingBarIcon(icon = inactiveIcon, color = Color.Unspecified)
    )
}

/**
 * configuration of each rating bar icon
 * @param[color] color of a icon
 * @param[icon] drawable resource for a icon
 */
data class RatingBarIcon(
    val color: Color,
    @DrawableRes val icon: Int
)
