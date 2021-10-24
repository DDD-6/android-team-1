package com.editor.appcha.ui.theme

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.editor.appcha.ui.R

private val SpoqaHanSansNeo = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)

@Immutable
data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp,
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 30.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
    ),
    val button: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

enum class AppTextStyle(
    val firstBaselineToTop: TextUnit = TextUnit.Unspecified,
    val lastBaselineToBottom: TextUnit = TextUnit.Unspecified
) {
    Unspecified,
    H1(26.sp, 10.sp),
    H2(23.sp, 9.sp),
    H3(21.sp, 9.sp),
    Body1(18.sp, 9.sp),
    Button(15.sp, 5.sp),
    Caption(12.sp, 4.sp);
}

@Composable
fun appTextStyle(style: TextStyle = LocalTextStyle.current): AppTextStyle {
    val equals: ((TextStyle, TextStyle) -> Boolean) = { style1, style2 ->
        style1.fontFamily == style2.fontFamily &&
                style1.fontSize == style2.fontSize &&
                style1.fontWeight == style2.fontWeight &&
                style1.lineHeight == style2.lineHeight
    }

    return when {
        equals(MaterialTheme.typography.h1, style) -> AppTextStyle.H1
        equals(MaterialTheme.typography.h2, style) -> AppTextStyle.H2
        equals(MaterialTheme.typography.h3, style) -> AppTextStyle.H3
        equals(MaterialTheme.typography.body1, style) -> AppTextStyle.Body1
        equals(MaterialTheme.typography.button, style) -> AppTextStyle.Button
        equals(MaterialTheme.typography.caption, style) -> AppTextStyle.Caption
        else -> AppTextStyle.Unspecified
    }
}
