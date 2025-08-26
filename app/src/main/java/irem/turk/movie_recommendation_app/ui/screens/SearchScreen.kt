package irem.turk.movie_recommendation_app.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import irem.turk.movie_recommendation_app.models.Film
import irem.turk.movie_recommendation_app.viewmodels.SearchViewModel

@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel = viewModel()) {
    var query by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Film Ara", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Film adı girin") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { viewModel.searchFilm(query) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ara")
        }
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(searchResults) { film ->
                FilmItem(film) {
                    navController.navigate("recommendations/${film.id}")
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun FilmItem(film: Film, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text("${film.title} (${film.year})")
        }
    }
}