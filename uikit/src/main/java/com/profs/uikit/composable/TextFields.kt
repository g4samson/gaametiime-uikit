package com.profs.uikit.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.profs.gaametiime.presentation.theme.Typography
import com.profs.uikit.theme.Pink4
import com.profs.uikit.theme.Pink5

@Composable
fun CustomTextField(
    label: String,
    value: String = "",
    type: String = "",
    onValueChange: (String) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(value) }
    var isPasswordVisible by remember { mutableStateOf(true) }

    BasicTextField(
        textFieldValue,
        {
            textFieldValue = it
            onValueChange(textFieldValue)
        },
        Modifier
            .fillMaxWidth()
            .height(26.dp),
        singleLine = true,
        textStyle = Typography.bodySmall,
        decorationBox = { innerTextField ->
            Box {
                if (textFieldValue.isEmpty()) {
                    Text(
                        label,
                        style = Typography.bodySmall
                    )
                }
                innerTextField()
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Brush.linearGradient(listOf(Pink4, Pink5)), RectangleShape)
                    )
                }
            }
        },
        visualTransformation = if (type == "password" && !isPasswordVisible)
            PasswordVisualTransformation('●')
        else VisualTransformation.None
    )
}

@Preview
@Composable
private fun CustomTextFieldPreview() {
    CustomTextField("Full Name", "", "") { }
}