package com.editor.appcha.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.api.kakao.KakaoLoginProvider
import com.editor.appcha.ui.base.BaseActivity
import com.editor.appcha.ui.home.HomeActivity
import com.editor.appcha.ui.login.LoginViewModel.Event
import com.editor.appcha.ui.theme.SplashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, Event>() {

    override val viewModel by viewModels<LoginViewModel>()

    private val kakaoLoginProvider by lazy { KakaoLoginProvider() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashTheme {
                LoginActivityScreen(
                    viewModel = viewModel,
                    onKakao = { tryKakaoLogin() }
                )
            }
        }
    }

    private fun tryKakaoLogin() = kakaoLoginProvider.login(this) { oAuthToken, throwable ->
        when {
            throwable != null -> Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
            oAuthToken != null -> viewModel.login(oAuthToken.accessToken)
            else -> Unit
        }
    }

    override fun handleEvent(event: Event) {
        when (event) {
            Event.StartHome -> {
                HomeActivity.launch(this)
                finish()
            }
            Event.ShowErrorToast -> {
                //TODO("서버 통신 에러 필요")
            }
        }
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}
