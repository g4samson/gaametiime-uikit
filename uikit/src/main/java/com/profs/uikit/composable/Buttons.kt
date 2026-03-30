package com.profs.uikit.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.profs.gaametiime.presentation.theme.Typography
import com.profs.uikit.theme.DefaultWhite
import com.profs.uikit.theme.Pink4
import com.profs.uikit.theme.Pink5

@Composable
fun CustomRoundedButton(value: String, onClick: () -> Unit) {
    Button(
        { onClick() },
        Modifier
            .fillMaxWidth()
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
    CustomRoundedButton("Let’s Combat!") {}
}