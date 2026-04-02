package com.profs.uikit.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.profs.uikit.theme.Typography
import com.profs.uikit.R
import com.profs.uikit.theme.Dark
import com.profs.uikit.theme.Pink1

@Composable
fun Pagination(index: Int) {
    Row(Modifier, Arrangement.spacedBy(10.dp), Alignment.CenterVertically) {
        repeat(3) { i ->
            val isSelected = index == i + 1

            Box(
                Modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) Pink1 else Pink1.copy(0.35f))
            )
        }
    }
}

@Preview
@Composable
private fun PaginationPreview() {
    Pagination(2)
}

@Composable
fun Select(modifier: Modifier, value: String, tag: String, onClick: () -> Unit) {
    Column(modifier, Arrangement.spacedBy(10.dp)) {
        Text(tag.uppercase(), style = Typography.bodySmall.copy(Pink1))
        Row(
            Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {
            Text(value, style = Typography.bodySmall.copy(Dark))
            Icon(
                painterResource(R.drawable.dropdown),
                null,
                Modifier.size(8.dp),
                Pink1
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun SelectPreview() {
    var sheet by remember { mutableStateOf(false) }

    BottomSheetScaffold(
        sheetContent = {},
        Modifier.fillMaxSize(),
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = if (sheet) 800.dp else 0.dp,
    ) {
        Box {

            Select(modifier = Modifier.width(320.dp), "MON, NOV 4,2019", "From") {
                sheet = !sheet
            }
        }

    }
}