package com.profs.uikit.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.profs.uikit.theme.Typography
import com.profs.uikit.R
import com.profs.uikit.theme.DefaultWhite

@Composable
fun CustomBottomBar(modifier: Modifier = Modifier, on1Click: () -> Unit, on2Click: () -> Unit, onCenterClick: () -> Unit, on3Click: () -> Unit, on4Click: () -> Unit) {

    Box(modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(
            painterResource(R.drawable.bottom),
            null,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {
            Row(
                Modifier.fillMaxWidth(0.33f),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically
            ) {
                CustomBottomBarItem(Modifier, "Statistics", R.drawable.statistics_icon) { on1Click() }
                CustomBottomBarItem(Modifier, "Discover", R.drawable.location_pin) {on2Click() }
            }
            Row(
                Modifier
                    .fillMaxWidth(0.48f), Arrangement.SpaceBetween, Alignment.CenterVertically
            ) {
                CustomBottomBarItem(Modifier, "Chat", R.drawable.chat) { on3Click()}
                CustomBottomBarItem(Modifier, "Profile", R.drawable.profile) { on4Click()}
            }
        }

        Box(
            modifier
                .padding(bottom = 30.dp)
                .size(60.dp)
                .clip(CircleShape)
                .clickable { onCenterClick() }
                .border(5.dp, DefaultWhite, CircleShape)
                .padding(13.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(R.drawable.schedule),
                null,
                Modifier.fillMaxSize(),
                DefaultWhite
            )
        }
    }
}

@Composable
private fun CustomBottomBarItem(
    modifier: Modifier = Modifier,
    title: String,
    iconResId: Int,
    onClick: () -> Unit
) {
    Column(modifier.clickable { onClick() }, Arrangement.Center, Alignment.CenterHorizontally) {
        Icon(painterResource(iconResId), null, Modifier.size(20.dp), DefaultWhite)
        Spacer(Modifier.height(5.dp))
        Text(title, style = Typography.bodySmall.copy(DefaultWhite, 10.sp))
    }
}

@Preview
@Composable
private fun CustomBottomBarPreview() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        CustomBottomBar(Modifier, {}, {}, {}, {}, {})
    }
}