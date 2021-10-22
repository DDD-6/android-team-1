package com.editor.appcha.ui.compose.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.ui.compose.base.BaseActivity
import com.editor.appcha.ui.compose.login.provider.KakaoLoginProvider
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
                LoginActivityScreen(this, vm, kakaoLoginProvider)
            }
        }
    }

    override fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            LoginViewModel.Event.Success -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            LoginViewModel.Event.Error -> {
                //TODO("서버 통신 에러 필요")
            }
        }
    }
}