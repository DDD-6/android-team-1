package com.editor.appcha.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.R
import com.editor.appcha.ui.theme.AppTheme

@Composable
fun FeedScrollToTop(onScroll: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(AppTheme.colors.gray1),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = CircleShape,
            color = AppTheme.colors.gray2,
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onScroll() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_up),
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
    }
}
