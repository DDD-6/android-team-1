package com.editor.appcha.ui.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun CommunityAuthorAndCreatedAt(
    author: String,
    createdAt: LocalDateTime,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        val text = "$author ∙ ${DateTimeFormatter.ofPattern("yy.MM.dd").format(createdAt)}"
        AppText(
            text = text,
            style = AppTheme.typography.caption,
            color = AppTheme.colors.gray4
        )
    }
}

@Composable
fun CommunityCommentIcon(count: Int, modifier: Modifier = Modifier) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = AppTheme.colors.gray4
        )
        if (count > 0) {
            AppText(
                text = "$count",
                style = AppTheme.typography.body2,
                color = AppTheme.colors.gray4
            )
        }
    }
}
