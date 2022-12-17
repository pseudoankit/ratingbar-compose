Library to use ratingbar in compose

<img src="https://user-images.githubusercontent.com/54987308/195987064-0797e8b7-9a0e-4eb1-ac41-23478f5e1c8b.gif" width="185" height="400"/>

**To use the library follow the below steps**

Add it in your root build.gradle at the end of repositories
```
allprojects {
    repositories { 
	maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency
```
dependencies { implementation 'com.github.pseudoankit:RatingBarCompose:v1.2' }
```

Implementation
```
    var ratingIcon by remember { mutableStateOf(0) }
    RatingBar(
        config = RatingBarConfig(
            iconConfig = RatingBarIconConfig(
                ratingIcon = android.R.drawable.btn_star_big_off,
                activeColor = Color.Yellow,
                inactiveColor = Color.Gray
            ),
            activeIconIndex = ratingIcon
        ),
    ) { activeRatingIndex -> 
        // TODO
    }
```
