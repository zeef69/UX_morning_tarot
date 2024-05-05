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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import hu.frzee.uxmorningtarot.themes.MorningTarotTheme
import hu.frzee.uxmorningtarot.views.AlarmPulse
import hu.frzee.uxmorningtarot.views.AlarmSet
import hu.frzee.uxmorningtarot.views.AlarmSound
import hu.frzee.uxmorningtarot.views.Loading
import hu.frzee.uxmorningtarot.views.MainPage

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    enterTransition: () -> EnterTransition = { EnterTransition.None },
    exitTransition: () -> ExitTransition = { ExitTransition.None },
    startDestination: String = NavigationItem.Loading.route,
) {

    val checkedStateSound = remember { mutableStateOf(true) }
    var alarmSongList = listOf("My Song", "Madár dal", "Aktuális kedvenc", "Pittyegés", "Reggeli torna")
    var alarmSongValue : MutableState<String> = remember { mutableStateOf(alarmSongList[0]) }
    var selectedAlarmSong by remember { mutableStateOf(alarmSongValue) }
    var originalSongValue : MutableState<String> = remember { mutableStateOf("My Song") }
    var originalSelectedSong by remember { mutableStateOf(originalSongValue) }

    val checkedStatePulse = remember { mutableStateOf(true) }
    var alarmPulseList = listOf("Hosszú", "Rövid", "Keringő", "Zip-zip-zip")
    var alarmPulseValue : MutableState<String> = remember { mutableStateOf(alarmPulseList[0]) }
    var selectedAlarmPulse by remember { mutableStateOf(alarmPulseValue) }
    var originalPulseValue : MutableState<String> = remember { mutableStateOf("Hosszú") }
    var originalSelectedPulse by remember { mutableStateOf(originalPulseValue) }

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
                    Screen.Loading.name,Screen.MainPage.name->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.Loading.name,Screen.MainPage.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.Loading.name,Screen.MainPage.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.Loading.name,Screen.MainPage.name->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
        ) {
            AlarmSet(
                checkedStateSound=checkedStateSound,
                checkedStatePulse=checkedStatePulse,
                selectedAlarmSong = selectedAlarmSong,
                selectedAlarmPulse = selectedAlarmPulse,
                onSetAlarmSound = { navController.navigate(Screen.AlarmSound.name) },
                onSetAlarmPulse = { navController.navigate(Screen.AlarmPulse.name) },
                onBackNavigate = { navController.navigate(Screen.MainPage.name) },
                onAlarmSave = { navController.navigate(Screen.MainPage.name) },
                onAlarmDismiss = { navController.navigate(Screen.MainPage.name) },
            )
        }
        composable(NavigationItem.AlarmSound.route,
            enterTransition = {
            when (initialState.destination.route) {
                Screen.AlarmSet.name->
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )

                else -> null
            }
        },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.AlarmSet.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.AlarmSet.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.AlarmSet.name->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
        ) {
            AlarmSound(
                checkedStateSound= checkedStateSound,
                songList = alarmSongList,
                selectedAlarmSong = selectedAlarmSong,
                originalSelectedSong = originalSelectedSong,
                onBackNavigate = { navController.navigate(Screen.AlarmSet.name) },
                onAlarmSoundSave = { navController.navigate(Screen.AlarmSet.name) },
                onAlarmSoundDismiss = { navController.navigate(Screen.AlarmSet.name) },
            )
        }
        composable(NavigationItem.AlarmPulse.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Screen.AlarmSet.name->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.AlarmSet.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.AlarmSet.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.AlarmSet.name->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
        ) {
            AlarmPulse(
                checkedStatePulse= checkedStatePulse,
                pulseList = alarmPulseList,
                selectedAlarmPulse = selectedAlarmPulse,
                originalSelectedPulse = originalSelectedPulse,
                onBackNavigate = { navController.navigate(Screen.AlarmSet.name) },
                onAlarmPulseSave = { navController.navigate(Screen.AlarmSet.name) },
                onAlarmPulseDismiss = { navController.navigate(Screen.AlarmSet.name) },
            )
        }
        composable(NavigationItem.MainPage.route
        ) {
            MainPage(
                //onBackNavigate = { navController.navigate(Screen.Loading.name) }
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