package com.profs.uikit.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.profs.uikit.theme.Typography
import com.profs.uikit.R
import com.profs.uikit.theme.DefaultWhite
import com.profs.uikit.theme.Pink4
import com.profs.uikit.theme.Pink5

@Composable
fun CustomContainerImage(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    imageResId: Int,
    onClick: () -> Unit
) {

    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(listOf(Pink4, Pink5)))
            .padding(24.dp)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column(Modifier.fillMaxWidth(), Arrangement.Top, Alignment.Start) {
                Text(
                    title,
                    style = Typography.bodySmall.copy(DefaultWhite, fontWeight = FontWeight.Bold)
                )
                Spacer(Modifier.height(14.dp))
                Text(desc, style = Typography.bodySmall.copy(DefaultWhite, 10.sp))
                Spacer(Modifier.height(42.dp))
                Icon(painterResource(R.drawable.forward_arrow), null, Modifier.size(16.dp), DefaultWhite)
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Image(
                    painterResource(imageResId), null,
                    Modifier.size(110.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview
@Composable
private fun CustomContainerImagePreview() {
    CustomContainerImage(
        Modifier,
        stringResource(R.string.title),
        stringResource(R.string.desc),
        R.drawable.image
    ) {}
}

@Composable
fun CustomContainerTimer(modifier: Modifier = Modifier, value: String, title: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(listOf(Pink4, Pink5)))
            .padding(7.dp)
            .then(modifier)
    ) {
        Column(Modifier.fillMaxWidth(), Arrangement.Top, Alignment.CenterHorizontally) {
            Text(title, style = Typography.bodySmall.copy(DefaultWhite))
            Spacer(Modifier.height(14.dp))
            Text(value, style = Typography.titleLarge.copy(DefaultWhite, 30.sp, FontWeight.Bold))
            Spacer(Modifier.height(14.dp))
        }
    }
}

@Preview
@Composable
private fun CustomContainerTimerPreview() {
    CustomContainerTimer(Modifier, "00:00", "Timer")
}