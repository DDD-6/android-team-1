package com.editor.appcha.ui.compose.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.login.provider.KakaoLoginProvider
import com.editor.appcha.ui.compose.login.provider.OnKakaoLoginListener
import com.editor.appcha.ui.compose.main.MainActivity
import com.editor.appcha.ui.compose.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, LoginViewModel.Event>() {

    override val vm by viewModels<LoginViewModel>()

    @Inject
    lateinit var kakaoLoginProvider: KakaoLoginProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LoginActivityScreen(vm, onKakaoLoginListener)
            }
        }
    }

    override fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            LoginViewModel.Event.StartHome -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            LoginViewModel.Event.ShowErrorToast -> {
                //TODO("서버 통신 에러 필요")
            }
        }
    }

    private val onKakaoLoginListener = object : OnKakaoLoginListener {
        override fun onLogin() {
            kakaoLoginProvider.login(this@LoginActivity) { oAuthToken, throwable ->
                if (throwable != null) {
                    Toast.makeText(this@LoginActivity, throwable.message, Toast.LENGTH_SHORT).show()
                } else {
                    oAuthToken?.accessToken?.let {
                        vm.login(it)
                    }
                }
            }
        }
    }
}