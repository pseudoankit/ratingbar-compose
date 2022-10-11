package pseudoankit.droid.composeratingbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pseudoankit.droid.composeratingbar.ui.theme.ComposeRatingBarTheme
import pseudoankit.droid.rating_bar.RatingBar
import pseudoankit.droid.rating_bar.RatingBarConfig
import pseudoankit.droid.rating_bar.RatingBarIconConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRatingBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RatingWithDifferentActiveAndInActiveIcon()
        Spacer(modifier = Modifier.height(10.dp))
        RatingWithSameIconAndDifferentColor()
        Spacer(modifier = Modifier.height(10.dp))
        RatingWithDifferentIconAndDifferentColor()
    }
}

@Composable
fun RatingWithDifferentActiveAndInActiveIcon() {
    var ratingIcon by remember { mutableStateOf(0) }
    Text(text = "Different active and inactive icon without color")
    RatingBar(
        config = RatingBarConfig(
            iconConfig = RatingBarIconConfig(
                inactiveIcon = android.R.drawable.btn_star_big_off,
                activeIcon = android.R.drawable.star_on
            ),
            activeIconIndex = ratingIcon
        ),
    ) {
        ratingIcon = it
    }
}

@Composable
fun RatingWithSameIconAndDifferentColor() {
    var ratingIcon by remember { mutableStateOf(0) }
    Text(text = "Same active and inactive icon but different color")
    RatingBar(
        config = RatingBarConfig(
            iconConfig = RatingBarIconConfig(
                ratingIcon = android.R.drawable.btn_star_big_off,
                activeColor = Color.Yellow,
                inactiveColor = Color.Gray
            ),
            activeIconIndex = ratingIcon
        ),
    ) {
        ratingIcon = it
    }
}

@Composable
fun RatingWithDifferentIconAndDifferentColor() {
    var ratingIcon by remember { mutableStateOf(0) }
    Text(text = "Different active and inactive icon also different color")
    RatingBar(
        config = RatingBarConfig(
            iconConfig = RatingBarIconConfig(
                inactiveIcon = android.R.drawable.btn_star_big_off,
                activeColor = Color.Yellow,
                inactiveColor = Color.Gray,
                activeIcon = android.R.drawable.ic_dialog_email
            ),
            activeIconIndex = ratingIcon
        ),
    ) {
        ratingIcon = it
    }
}