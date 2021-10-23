package com.editor.appcha.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

inline val Dp.sp: TextUnit
    @Composable get() = with(LocalDensity.current) { toSp() }

@Immutable
data class VerticalDp(
    val top: Dp = Dp.Unspecified,
    val bottom: Dp = Dp.Unspecified
) {
    companion object {

        @Stable
        val Default = VerticalDp()
    }
}

@Immutable
data class HorizontalDp(
    val start: Dp = Dp.Unspecified,
    val end: Dp = Dp.Unspecified
) {
    companion object {

        @Stable
        val Default = HorizontalDp()
    }
}
