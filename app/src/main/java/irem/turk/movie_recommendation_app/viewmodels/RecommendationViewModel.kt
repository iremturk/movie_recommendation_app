package irem.turk.movie_recommendation_app.viewmodels

import androidx.lifecycle.ViewModel
import irem.turk.movie_recommendation_app.models.Film
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendationsViewModel : ViewModel() {
    private val _recommendations = MutableStateFlow<List<Film>>(emptyList())
    val recommendations = _recommendations.asStateFlow()

    fun loadRecommendations(filmId: String) {
        _recommendations.value = listOf(
            Film("3", "Interstellar", "2014", "Bilim kurgu ve macera", ""),
            Film("4", "The Dark Knight", "2008", "Aksiyon ve suç", ""),
            Film("5", "Blade Runner", "1982", "Bilim kurgu", ""),
            Film("6", "Fight Club", "1999", "Dram ve gerilim", ""),
            Film("7", "The Matrix Reloaded", "2003", "Aksiyon ve bilim kurgu", "")
        )
    }
}