package com.editor.appcha.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun FeedCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(8.dp),
    color: Color = AppTheme.colors.gray1,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = color
    ) {
        val clickModifier = if (onClick != null) {
            Modifier.clickable { onClick() }
        } else {
            Modifier
        }
        Box(modifier = clickModifier, content = content)
    }
}

@Composable
fun FeedTitleAndAuthor(
    title: String,
    author: String,
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 20.dp
) {
    val brush = verticalGradient(
        0f to Color.Transparent,
        1.0f to AppTheme.colors.gray5.copy(alpha = 0.7f)
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(brush)
            .padding(
                start = horizontalPadding,
                end = horizontalPadding,
                top = 20.dp,
                bottom = 20.dp
            )
    ) {
        AppText(
            text = title,
            color = Color.White,
            style = AppTheme.typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppText(
            text = author,
            color = Color.White,
            style = AppTheme.typography.body2
        )
    }
}

@Preview
@Composable
fun FeedTitleAndAuthorPreview() {
    AppTheme {
        FeedTitleAndAuthor(title = "제목이 들어갑니다.\n내일부터 진짜 운동할건데", author = "작성자")
    }
}

