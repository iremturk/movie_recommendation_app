package irem.turk.movie_recommendation_app.models

data class Film(
    val id: String,
    val title: String,
    val year: String,
    val overview: String,
    val posterUrl: String = ""
)
