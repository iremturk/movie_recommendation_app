package irem.turk.movie_recommendation_app.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {
    private val _registerSuccess = MutableStateFlow(false)
    val registerSuccess = _registerSuccess.asStateFlow()

    fun register(email: String, password: String, name: String?) {
        _registerSuccess.value = email.isNotEmpty() && password.isNotEmpty()
    }
}