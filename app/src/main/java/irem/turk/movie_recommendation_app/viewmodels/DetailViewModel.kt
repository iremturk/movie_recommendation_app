package irem.turk.movie_recommendation_app.viewmodels


import androidx.lifecycle.ViewModel
import irem.turk.movie_recommendation_app.models.Film
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel : ViewModel() {
    private val _film = MutableStateFlow<Film?>(null)
    val film = _film.asStateFlow()

    fun loadFilm(filmId: String) {
        _film.value = Film(filmId, "", "", "", "")
    }
}