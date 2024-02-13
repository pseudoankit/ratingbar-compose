# Library to create ratingbar in compose

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.pseudoankit/rating-bar/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pseudoankit/rating-bar)

<img src="https://user-images.githubusercontent.com/54987308/195987064-0797e8b7-9a0e-4eb1-ac41-23478f5e1c8b.gif" width="185" height="400"/>

# Getting Started

Add the dependency in your build.gradle
```
dependencies { implementation 'io.github.pseudoankit:rating-bar:<version 🔝>' }
```

# Usage
```
    var ratingIconIndex by remember { mutableStateOf(0) }
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
        ratingIconIndex = activeRatingIndex
    }
```
