package com.profs.uikit.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.profs.uikit.theme.Typography
import com.profs.uikit.R
import com.profs.uikit.theme.DefaultWhite
import com.profs.uikit.theme.Pink1
import com.profs.uikit.theme.Pink4
import com.profs.uikit.theme.Pink5

@Composable
fun CustomRoundedButton(modifier: Modifier, value: String, onClick: () -> Unit) {
    Button(
        { onClick() },
        Modifier
            .width(210.dp)
            .height(58.dp)
            .background(
                Brush.linearGradient(
                    listOf(Pink4, Pink5)
                ), CircleShape
            ),
        true,
        CircleShape,
        ButtonDefaults.buttonColors(
            Color.Transparent
        ),
    ) {
        Text(value, style = Typography.bodyMedium.copy(DefaultWhite, fontWeight = FontWeight.Bold))
    }
}

@Preview
@Composable
private fun CustomRoundedButtonPreview() {
    CustomRoundedButton(Modifier, "Let’s Combat!") {}
}

@Composable
fun CustomTextButton(modifier: Modifier = Modifier, textValue: String, iconResId: Int, onClick: () -> Unit) {
    Row(modifier
        .height(24.dp)
        .clickable { onClick() }, Arrangement.spacedBy(20.dp), Alignment.CenterVertically) {
        Icon(painterResource(iconResId), null, Modifier.fillMaxHeight(), Pink1)

        Text(textValue, style = Typography.headlineMedium)
    }
}

@Preview
@Composable
private fun CustomTextButtonPreview() {
    CustomTextButton(Modifier, "Logout", R.drawable.logout) {}
}