package pseudoankit.droid.rating_bar.compose

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pseudoankit.droid.rating_bar.util.RatingUtils.ICON_SIZE

data class RatingBarConfig(
    val iconConfig: RatingIconConfig = RatingIconConfig.Vector(),
    val iconSpacing: Dp = 10.dp,
    val iconCount: Int = 5
) {
    val iconsCountRange: IntRange = 1..iconCount
}

sealed class RatingIconConfig(open val width: Dp, open val height: Dp) {
    data class Image(
        override val width: Dp = ICON_SIZE,
        override val height: Dp = ICON_SIZE,
        @DrawableRes val inactive: Int = android.R.drawable.star_off,
        @DrawableRes val active: Int = android.R.drawable.star_on
    ) : RatingIconConfig(width, height)

    data class Vector(
        override val width: Dp = ICON_SIZE,
        override val height: Dp = ICON_SIZE,
        val inactiveColor: Color = Color.Gray,
        val activeColor: Color = Color.Yellow,
        val vector: ImageVector = Icons.Default.Star
    ) : RatingIconConfig(width, height)
}