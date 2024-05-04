package hu.frzee.uxmorningtarot.navigation

import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import hu.frzee.uxmorningtarot.themes.MorningTarotTheme
import hu.frzee.uxmorningtarot.views.AlarmSet
import hu.frzee.uxmorningtarot.views.Loading

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    enterTransition: () -> EnterTransition = { EnterTransition.None },
    exitTransition: () -> ExitTransition = { ExitTransition.None },
    startDestination: String = NavigationItem.Loading.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Loading.route
        ) {
            Loading(
                onSetAlarmNavigate = { navController.navigate(Screen.AlarmSet.name) }
            )
        }
        composable(NavigationItem.AlarmSet.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Screen.Loading.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.Loading.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.Loading.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(300)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.Loading.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(300)
                        )

                    else -> null
                }
            },
        ) {
            AlarmSet(
                onBackNavigate = { navController.navigate(Screen.Loading.name) }
            )
        }
        /*
        *
        navigation(startDestination = "username", route = "login") {
            composable("username") { ... }
            composable("password") { ... }
            composable("registration") { ... }
        }
        * */
    }
}