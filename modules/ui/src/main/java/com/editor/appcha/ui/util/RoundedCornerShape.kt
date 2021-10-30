package com.editor.appcha.ui.util

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun verticalRoundedCornerShape(
    top: Dp = 0.dp,
    bottom: Dp = 0.dp
) = RoundedCornerShape(
    topStart = top,
    topEnd = top,
    bottomEnd = bottom,
    bottomStart = bottom
)
