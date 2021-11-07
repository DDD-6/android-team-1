package com.editor.appcha.ui.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.component.AppText
import com.editor.appcha.ui.component.NetworkImage
import com.editor.appcha.ui.model.AppModel
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun AppItems(
    apps: List<AppModel>,
    modifier: Modifier = Modifier,
    onClick: (AppModel) -> Unit
) {
    val lastIndex = apps.lastIndex
    Column(modifier = modifier.fillMaxWidth()) {
        apps.forEachIndexed { index, app ->
            // TODO: Constraint 기반으로 변경 (AppItem + Divider)
            AppItem(
                app = app,
                onClick = onClick
            )
            if (index != lastIndex) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 92.dp, end = 24.dp),
                    color = AppTheme.colors.gray1,
                )
            }
        }
    }
}

@Composable
fun AppItem(
    app: AppModel,
    onClick: (AppModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(app) }
            .padding(horizontal = 24.dp, vertical = 6.dp),
    ) {
        Surface(
            modifier = Modifier.size(56.dp),
            shape = RoundedCornerShape(8.dp),
            color = AppTheme.colors.gray1,
        ) {
            NetworkImage(data = app.imageUrl)
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            AppText(
                text = app.name,
                style = AppTheme.typography.body2,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            AppText(
                text = app.description,
                style = AppTheme.typography.caption,
                color = AppTheme.colors.gray4,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}
