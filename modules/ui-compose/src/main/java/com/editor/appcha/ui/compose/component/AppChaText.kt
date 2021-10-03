package com.editor.appcha.ui.compose.component

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.editor.appcha.ui.compose.util.VerticalDp

/**
 * @see [com.editor.appcha.ui.compose.theme.AppChaTypography]
 */
@Composable
fun AppChaText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {

    /**
     * - top = distance between top and baseline
     * - bottom = distance between bottom and baseline
     * - lineHeight = top + bottom
     */
    val (top, bottom) = when (style) {
        MaterialTheme.typography.h1 -> VerticalDp(21.dp, 5.dp)
        MaterialTheme.typography.h2 -> VerticalDp(23.dp, 9.dp)
        MaterialTheme.typography.h3 -> VerticalDp(21.dp, 9.dp)
        MaterialTheme.typography.body1 -> VerticalDp(18.dp, 6.dp)
        MaterialTheme.typography.button -> VerticalDp(15.dp, 5.dp)
        MaterialTheme.typography.caption -> VerticalDp(12.dp, 4.dp)
        else -> VerticalDp.Default
    }

    Text(
        text = text,
        modifier = modifier.paddingFromBaseline(top = top, bottom = bottom),
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}
