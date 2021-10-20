package com.editor.appcha.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.editor.appcha.core.ui.activity.AbstractActivity
import com.editor.appcha.ui.login.provider.KakaoLoginProvider
import com.editor.appcha.ui.main.GreeterActivity
import com.editor.appcha.ui.theme.AppChaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AbstractActivity<LoginViewModel, LoginViewModel.Event>() {

    override val vm by viewModels<LoginViewModel>()

    @Inject
    lateinit var kakaoLoginProvider: KakaoLoginProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppChaTheme {
                LoginActivityScreen(this, vm, kakaoLoginProvider)
            }
        }
    }

    override fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            LoginViewModel.Event.Success -> {
                startActivity(Intent(this, GreeterActivity::class.java))
                finish()
            }
            LoginViewModel.Event.Error -> {
                //TODO("서버 통신 에러 필요")
            }
        }
    }
}