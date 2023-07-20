package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R

val imageUrls = listOf(
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
    "https://source.unsplash.com/random/400x300?9",
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InstagramPhotoGrid() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3), // 3 items per row
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(imageUrls.size) { index ->
                InstagramPhotoItem(imageUrl = imageUrls[index])
            }
        }
    }
}

@Composable
fun InstagramPhotoItem(imageUrl: String) {
    Card(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(R.drawable.sample_avatar),
            contentDescription = "Instagram Photo",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}