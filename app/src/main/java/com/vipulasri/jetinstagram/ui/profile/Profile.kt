package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun InstagramProfilePage() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            Profile()
        }
    }
}

@Composable
fun Profile() {
    Column {
        Row(horizontalArrangement = Arrangement.Start) {
            BackButton()
            Text(
                text = currentUser.username,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 12.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row() {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 0.dp)
            ) {
                StoryImage(currentUser.image)
                Spacer(modifier = Modifier.width(16.dp))
                ProfileStats()
            }
        }
        Row(
            horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(start = 12.dp)
        ) {
            basicInfo(
                "Andrea kba",
                "Soyez toujours heureux 1 Thessaloniciens 5:16"
            )
        }

        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(start = 12.dp, top = 16.dp)) {
            seeTranslation()
        }
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(start = 12.dp)) {
            followedBy()
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp)
        ) {
            FollowingButton(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            MessageButton(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(6.dp))
            FollowButton()
        }
        Row(horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp)) {
            ArchivesStories()
        }

        Row(modifier = Modifier.padding(top=20.dp, bottom = 0.dp)) {
            TabsIcon()
        }
        Box(modifier = Modifier.padding(top = 5.dp)) {
            InstagramPhotoGrid()
        }
    }
}


@Composable
fun ProfileStats() {
    Row(modifier = Modifier.padding(top = 5.dp)) {
        ProfileStat("1.5k", "Posts")
        Spacer(modifier = Modifier.width(16.dp))
        ProfileStat("5.3k", "Followers")
        Spacer(modifier = Modifier.width(16.dp))
        ProfileStat("2.1k", "Following")
    }
}


@Composable
fun ArchivesStories(){
    Row(){
        Column() {

            StoryImage("https://source.unsplash.com/random/400x300?9")
            Text(
                text = "Enjoying\uD83D\uDE0E",
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Composable
fun ProfileStat(count: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun basicInfo(fullname: String, bio: String) {
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxWidth(0.44f)) {
        Text(
            text = fullname,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,

            )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = bio,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f, fill = false)
        )
    }

}

@Preview
@Composable
fun InstagramProfilePagePreview() {
    InstagramProfilePage()
}

@Composable
fun FollowingButton(modifier: Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(64, 152, 246),
            contentColor = Color.White
        ),
        modifier = modifier
    ) {
        Text(text = "Following")
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Arrow Down Icon",
            tint = Color.White,
            modifier = Modifier.size(24.dp) // Set the size of the icon
        )
    }

}

@Composable
fun MessageButton(modifier: Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(64, 152, 246),
            contentColor = Color.White
        ),
        modifier = modifier
    ) {
        Text(text = "Message")
    }

}


@Composable
fun TabsIcon(){
    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly) {
        Image(painter = painterResource(R.drawable.icons_grid),
            contentDescription = "Tab icon" )
        Image(painter = painterResource(R.drawable.icons_reel),
            contentDescription = "Tab icon" )
        Image(painter = painterResource(R.drawable.icons_tagged),
            contentDescription = "Tab icon" )


    }

}

@Composable
fun TabIcon(ImageId: Int){
    Image(painter = painterResource(ImageId),
        contentDescription = "Tab icon" )

}

@Composable
fun BackButton(
) {
    IconButton(
        onClick = { },
        modifier = Modifier.size(36.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black // Customize the color as per your design
        )
    }
}

@Composable
fun seeTranslation() {
    Column(verticalArrangement = Arrangement.Top) {
        Text(
            text = "See translation",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun followedBy() {
    Row(){
        Text(
            text = "followed by",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "cherlanphilippe",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
            )
    }
}

@Composable
fun FollowButton(
) {
    Button(
        onClick = { },
        modifier = Modifier.size(36.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(64, 152, 246),
            contentColor = Color.White
        )
    ) {
        Image(
            painter = painterResource(R.drawable.follow_icon),
            contentDescription = "Follow request",
            modifier = Modifier.size(12.dp) // Set the size of the icon
        )
    }
}
