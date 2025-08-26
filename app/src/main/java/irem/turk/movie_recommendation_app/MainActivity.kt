package irem.turk.movie_recommendation_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import irem.turk.movie_recommendation_app.ui.screens.DetailScreen
import irem.turk.movie_recommendation_app.ui.screens.LoginScreen
import irem.turk.movie_recommendation_app.ui.screens.RecommendationsScreen
import irem.turk.movie_recommendation_app.ui.screens.RegisterScreen
import irem.turk.movie_recommendation_app.ui.screens.SearchScreen
import irem.turk.movie_recommendation_app.ui.theme.MovieRecommendationApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieRecommendationApp {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                        composable("search") { SearchScreen(navController) }
                        composable("recommendations/{filmId}") { backStackEntry ->
                            val filmId = backStackEntry.arguments?.getString("filmId") ?: ""
                            RecommendationsScreen(navController, filmId)
                        }
                        composable("detail/{filmId}") { backStackEntry ->
                            val filmId = backStackEntry.arguments?.getString("filmId") ?: ""
                            DetailScreen(navController, filmId)
                        }
                    }
                }
            }
        }
    }
}