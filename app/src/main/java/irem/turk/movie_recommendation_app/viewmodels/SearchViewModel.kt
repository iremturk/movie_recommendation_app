package irem.turk.movie_recommendation_app.viewmodels


import androidx.lifecycle.ViewModel
import irem.turk.movie_recommendation_app.models.Film
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {
    private val _searchResults = MutableStateFlow<List<Film>>(emptyList())
    val searchResults = _searchResults.asStateFlow()

    fun searchFilm(query: String) {
        if (query.isNotEmpty()) {
            _searchResults.value = listOf(
                Film("1", "Matrix", "1999", "Aksiyon ve bilim kurgu filmi", ""),
                Film("2", "Inception", "2010", "Bilim kurgu filmi", "")
            )
        } else {
            _searchResults.value = emptyList()
        }
    }
}