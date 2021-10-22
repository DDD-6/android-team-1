package com.editor.appcha.ui.compose.login.provider

import android.app.Activity
import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

typealias KakaoLoginCallback = (OAuthToken?, Throwable?) -> Unit

class KakaoLoginProvider {

    fun login(activity: Activity, callback: KakaoLoginCallback) {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(activity)) {
            UserApiClient.instance.loginWithKakaoTalk(activity) { token, error ->
                callback(token, error)
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(activity) { token, error ->
                callback(token, error)
            }
        }
    }

    fun logout() {
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.d("KakaoLoginProvider", "로그아웃 실패. SDK에서 토큰 삭제됨")
            } else {
                Log.d("KakaoLoginProvider", "로그아웃 성공. SDK에서 토큰 삭제됨")
            }
        }
    }

    private fun info() {
        UserApiClient.instance.me { user, error ->
            TODO()
        }
    }
}