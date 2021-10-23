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
import com.editor.appcha.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, LoginViewModel.Event>() {

    override val viewModel by viewModels<LoginViewModel>()

    private val kakaoLoginProvider by lazy { KakaoLoginProvider() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LoginActivityScreen(
                    viewModel = viewModel,
                    onKakao = { tryKakaoLogin() }
                )
            }
        }
    }

    override fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            LoginViewModel.Event.StartHome -> {
                HomeActivity.launch(this)
                finish()
            }
            LoginViewModel.Event.ShowErrorToast -> {
                //TODO("서버 통신 에러 필요")
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

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}
