package irem.turk.movie_recommendation_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import irem.turk.movie_recommendation_app.viewmodels.RecommendationsViewModel

@Composable
fun RecommendationsScreen(
    navController: NavController,
    filmId: String,
    viewModel: RecommendationsViewModel = viewModel()
) {
    LaunchedEffect(filmId) {
        viewModel.loadRecommendations(filmId)
    }
    val recommendations by viewModel.recommendations.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Benzer Filmler", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(recommendations) { film ->
                FilmItem(film) {
                    navController.navigate("detail/${film.id}")
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}