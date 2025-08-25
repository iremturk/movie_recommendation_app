package irem.turk.movie_recommendation_app.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess = _loginSuccess.asStateFlow()

    fun login(email: String, password: String) {
        _loginSuccess.value = email.isNotEmpty() && password.isNotEmpty()
    }
}