package pseudoankit.droid.rating_bar.util

import androidx.compose.ui.unit.dp

internal object RatingUtils {
    val ICON_SIZE = 50.dp

    fun isActive(activeIndex: Int, currentIndex: Int) = currentIndex <= activeIndex

}