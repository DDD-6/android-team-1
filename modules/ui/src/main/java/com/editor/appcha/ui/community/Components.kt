package com.editor.appcha.ui.community

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.theme.AppTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun CommunityAuthorAndCreatedAt(author: String, createdAt: LocalDateTime) {
    Row {
        AppText(
            text = author,
            style = AppTheme.typography.caption,
            color = AppTheme.colors.gray4
        )
        AppText(
            text = " ∙ ",
            style = AppTheme.typography.caption,
            color = AppTheme.colors.gray4
        )
        AppText(
            text = DateTimeFormatter.ofPattern("yy.MM.dd").format(createdAt),
            style = AppTheme.typography.caption,
            color = AppTheme.colors.gray4
        )
    }
}

@Composable
fun CommunityCommentIcon(count: Int) {
    Row {
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
