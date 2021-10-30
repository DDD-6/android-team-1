package com.editor.appcha.startup

import android.content.Context
import androidx.startup.Initializer
import com.editor.appcha.BuildConfig
import com.kakao.sdk.common.KakaoSdk

class KakaoInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        return KakaoSdk.init(context, BuildConfig.KAKAO_API_NATIVE_KEY)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}