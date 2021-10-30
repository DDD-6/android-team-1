package com.editor.appcha.ui.feed

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun FeedSummary(
    summary: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    shape: Shape = RectangleShape
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor
    ) {
        AppText(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
            text = summary,
            color = AppTheme.colors.gray4,
            style = AppTheme.typography.body2
        )
    }
}
