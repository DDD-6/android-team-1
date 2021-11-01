package com.editor.appcha.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

@Composable
fun NetworkImage(
    data: Any?,
    modifier: Modifier = Modifier,
    builder: ImageRequest.Builder.() -> Unit = { crossfade(true) },
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        painter = rememberImagePainter(
            data = data,
            builder = builder
        ),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}
