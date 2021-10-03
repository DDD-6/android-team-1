package com.editor.appcha.ui.compose.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.editor.appcha.ui.compose.R
import com.editor.appcha.ui.compose.util.dp

private val SpoqaHanSansNeo = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)

val AppChaTypography
    @Composable
    get() = Typography(
        h1 = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 24.dp,
            fontWeight = FontWeight.Bold,
            lineHeight = 36.dp,
        ),
        h2 = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 20.dp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.dp
        ),
        h3 = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 18.dp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.dp
        ),
        body1 = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 16.dp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.dp,
        ),
        button = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 14.dp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.dp
        ),
        caption = TextStyle(
            fontFamily = SpoqaHanSansNeo,
            fontSize = 12.dp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.dp
        )
    )

private inline val Int.dp: TextUnit
    @Composable
    get() = TextUnit.dp(value = this)
