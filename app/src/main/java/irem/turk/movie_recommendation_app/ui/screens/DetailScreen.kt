package irem.turk.movie_recommendation_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import irem.turk.movie_recommendation_app.viewmodels.DetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, filmId: String, viewModel: DetailViewModel = viewModel()) {
    LaunchedEffect(filmId) {
        viewModel.loadFilm(filmId)
    }
    val film by viewModel.film.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Film Detayları") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            film?.let {
                Spacer(Modifier.height(16.dp))
                Text(it.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(8.dp))
                Text("Yıl: ${it.year}")
                Spacer(Modifier.height(8.dp))
                Text("Açıklama: ${it.overview}")
            }
        }
    }
}