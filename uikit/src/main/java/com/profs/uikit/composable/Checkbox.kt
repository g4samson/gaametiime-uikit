package com.profs.uikit.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.profs.uikit.theme.Pink1

@Composable
fun CustomCheckbox(modifier: Modifier, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked,
        { onCheckedChange(!checked) },
        Modifier
            .border(1.dp, Pink1, RoundedCornerShape(3.dp))
            .padding(4.dp)
            .size(14.dp)
            .then(modifier),
        true,
        CheckboxDefaults.colors(
            checkedColor = Color.Transparent,
            uncheckedColor = Color.Transparent,
            checkmarkColor = Pink1
        )
    )
}

@Preview
@Composable
private fun CustomCheckboxPreview() {
    var checked by remember { mutableStateOf(false) }

    CustomCheckbox(Modifier, checked) { checked = it }
}