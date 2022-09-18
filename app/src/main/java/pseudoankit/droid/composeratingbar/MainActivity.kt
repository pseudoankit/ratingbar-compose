package pseudoankit.droid.composeratingbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pseudoankit.droid.composeratingbar.ui.theme.ComposeRatingBarTheme
import pseudoankit.droid.rating_bar.compose.RatingBar
import pseudoankit.droid.rating_bar.compose.RatingBarConfig
import pseudoankit.droid.rating_bar.compose.RatingIconConfig

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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Rating with image")
            RatingBar(
                config = RatingBarConfig(
                    iconConfig = RatingIconConfig.Image(
                        inactive = android.R.drawable.btn_star_big_off,
                        active = android.R.drawable.star_on
                    )
                )
            )
        }
    }
}