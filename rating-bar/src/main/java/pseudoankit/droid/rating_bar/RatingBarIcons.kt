package pseudoankit.droid.rating_bar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun DrawRatingBarIcons(
    config: RatingBarConfig,
    activeIconIndex: Int,
    onIconSelected: (Int) -> Unit
) {
    config.iconsCountRange.forEach { currentIndex ->

        RatingBarIcon(config.iconConfig, activeIconIndex, currentIndex) {
            onIconSelected(currentIndex)
        }

        Spacer(modifier = Modifier.width(config.iconSpacing))
    }
}
