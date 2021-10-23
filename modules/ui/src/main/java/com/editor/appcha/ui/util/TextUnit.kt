package com.editor.appcha.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/**
 * 텍스트에 들어가는 값인 TextUnit으로 변환하기 위한 유틸 함수
 */
@Composable
fun TextUnit.Companion.dp(value: Int): TextUnit = value.dp.sp

@Composable
fun TextUnit.Companion.dp(value: Float): TextUnit = value.dp.sp

@Immutable
data class VerticalTextUnit(
    val top: TextUnit = TextUnit.Unspecified,
    val bottom: TextUnit = TextUnit.Unspecified
) {
    companion object {

        @Stable
        val Default = VerticalTextUnit()
    }
}

@Immutable
data class HorizontalTextUnit(
    val start: TextUnit = TextUnit.Unspecified,
    val end: TextUnit = TextUnit.Unspecified
) {
    companion object {

        @Stable
        val Default = HorizontalTextUnit()
    }
}
