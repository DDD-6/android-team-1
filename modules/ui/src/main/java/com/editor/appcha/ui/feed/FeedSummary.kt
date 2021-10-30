package com.editor.appcha.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun FeedSummary(
    summary: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    paddingValues: PaddingValues = PaddingValues()
) {
    Surface(
        modifier = modifier
            .background(backgroundColor)
            .padding(paddingValues),
        color = backgroundColor
    ) {
        AppText(
            modifier = Modifier,
            text = summary,
            color = AppTheme.colors.gray4,
            style = AppTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun FeedSummaryPreview() {
    AppTheme {
        FeedSummary(
            summary = "요약글이 들어갑니다. 매일 다짐만 하는 프로 다짐러인 당신에게 이 앱을 바칩니다.",
            backgroundColor = AppTheme.colors.gray2,
            paddingValues = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        )
    }
}
