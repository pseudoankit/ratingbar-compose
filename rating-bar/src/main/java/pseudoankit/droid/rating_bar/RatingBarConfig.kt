package pseudoankit.droid.rating_bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class RatingBarConfig(
    val iconConfig: RatingIconConfig = RatingIconConfig(),
    val padding: PaddingValues = PaddingValues(all = 5.dp),
    val iconSpacing: Dp = 10.dp,
    val iconCount: Int = 5
) {
    val iconsCountRange: IntRange = 1..iconCount
}

data class RatingIconConfig(
    val width: Dp = 50.dp,
    val height: Dp = 50.dp,
    val icons: RatingIcons = RatingIcons()
)

data class RatingIcons(
    @DrawableRes val inactive: Int = android.R.drawable.star_off,
    @DrawableRes val active: Int = android.R.drawable.star_on
)
