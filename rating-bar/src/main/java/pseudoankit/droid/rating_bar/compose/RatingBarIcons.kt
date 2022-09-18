package pseudoankit.droid.rating_bar.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pseudoankit.droid.rating_bar.compose.rating_bar_icon.CreateRatingIconWithImage
import pseudoankit.droid.rating_bar.compose.rating_bar_icon.CreateRatingIconWithVector

@Composable
internal fun DrawRatingBarIcons(
    config: RatingBarConfig,
    activeIndex: Int,
    onIconSelected: (Int) -> Unit
) {
    config.iconsCountRange.forEach { currentIndex ->

        RatingBarIcon(config.iconConfig, activeIndex, currentIndex) {
            onIconSelected(currentIndex)
        }

        Spacer(modifier = Modifier.width(config.iconSpacing))
    }
}

@Composable
internal fun RatingBarIcon(
    iconConfig: RatingIconConfig, activeIndex: Int, currentIndex: Int, onIconSelected: () -> Unit
) {
    when (iconConfig) {
        is RatingIconConfig.Vector -> {
            CreateRatingIconWithVector(activeIndex, currentIndex, iconConfig, onIconSelected)
        }
        is RatingIconConfig.Image -> {
            CreateRatingIconWithImage(activeIndex, currentIndex, iconConfig, onIconSelected)
        }
    }
}
