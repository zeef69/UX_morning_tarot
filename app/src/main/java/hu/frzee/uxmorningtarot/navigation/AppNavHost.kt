package hu.frzee.uxmorningtarot.navigation

import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
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
import hu.frzee.uxmorningtarot.views.AlarmSleep
import hu.frzee.uxmorningtarot.views.AlarmSound
import hu.frzee.uxmorningtarot.views.CalendarPicker
import hu.frzee.uxmorningtarot.views.Loading
import hu.frzee.uxmorningtarot.views.MainPage
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    enterTransition: () -> EnterTransition = { EnterTransition.None },
    exitTransition: () -> ExitTransition = { ExitTransition.None },
    startDestination: String = NavigationItem.Loading.route,
) {
    val timePickerState = rememberTimePickerState()
    var alarmTitleValue = remember { mutableStateOf("") }
    val selectionWeek = ArrayList<MutableState<Boolean>>()
    val hetfo = remember { mutableStateOf(false) }
    val kedd = remember { mutableStateOf(true) }
    val szerda = remember { mutableStateOf(false) }
    val csutortok = remember { mutableStateOf(false) }
    val pentek = remember { mutableStateOf(false) }
    val szombat = remember { mutableStateOf(false) }
    val vasarnap = remember { mutableStateOf(false) }
    selectionWeek.add(hetfo)
    selectionWeek.add(kedd)
    selectionWeek.add(szerda)
    selectionWeek.add(csutortok)
    selectionWeek.add(pentek)
    selectionWeek.add(szombat)
    selectionWeek.add(vasarnap)

    val checkedAlarmState = remember { mutableStateOf(true) }
    var alarmMinuteValue : MutableState<String> = remember { mutableStateOf("20") }
    var alarmMinute by remember { mutableStateOf(alarmMinuteValue) }
    var alarmHourValue : MutableState<String> = remember { mutableStateOf("15") }
    var alarmHour by remember { mutableStateOf(alarmHourValue) }


    val checkedStateSound = remember { mutableStateOf(true) }
    var alarmSongList = listOf("Asteroid", "Beep-Beep", "Comet", "Cosmos", "Neptune", "Orbit", "Outer Ball",
        "Planet","Pluto", "Polaris", "Satellite", "Shooting Star","Sky High", "Space Bell", "Sunlight")
    var alarmSongValue : MutableState<String> = remember { mutableStateOf(alarmSongList[0]) }
    var selectedAlarmSong by remember { mutableStateOf(alarmSongValue) }
    var originalSongValue : MutableState<String> = remember { mutableStateOf("Asteroid") }
    var originalSelectedSong by remember { mutableStateOf(originalSongValue) }

    val checkedStatePulse = remember { mutableStateOf(true) }
    var alarmPulseList = listOf("Hosszú", "Rövid", "Keringő", "Zip-zip-zip")
    var alarmPulseValue : MutableState<String> = remember { mutableStateOf(alarmPulseList[0]) }
    var selectedAlarmPulse by remember { mutableStateOf(alarmPulseValue) }
    var originalPulseValue : MutableState<String> = remember { mutableStateOf("Hosszú") }
    var originalSelectedPulse by remember { mutableStateOf(originalPulseValue) }

    val checkedStateSleep = remember { mutableStateOf(false) }
    var alarmIntervalList = listOf("3 perc", "5 perc", "10 perc", "15 perc", "20 perc", "30 perc")
    var alarmIntervalValue : MutableState<String> = remember { mutableStateOf(alarmIntervalList[0]) }
    var selectedAlarmInterval by remember { mutableStateOf(alarmIntervalValue) }
    var alarmRepeatList = listOf("Egyszer", "Háromszor", "Ötször", "Végtelenítve")
    var alarmRepeatValue : MutableState<String> = remember { mutableStateOf(alarmRepeatList[0]) }
    var selectedAlarmRepeat by remember { mutableStateOf(alarmRepeatValue) }
    var originalIntervalValue : MutableState<String> = remember { mutableStateOf("3 perc") }
    var originalSelectedInterval by remember { mutableStateOf(originalIntervalValue) }
    var originalRepeatValue : MutableState<String> = remember { mutableStateOf("Egyszer") }
    var originalSelectedRepeat by remember { mutableStateOf(originalRepeatValue) }


    val date = remember {
        Calendar.getInstance().timeInMillis
    }
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Loading.route
        ) {
            Loading(
                onSetAlarmNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name)
                }
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
                alarmTitle = alarmTitleValue,
                timePickerState=timePickerState,
                selectionWeek=selectionWeek,
                checkedStateSound=checkedStateSound,
                checkedStatePulse=checkedStatePulse,
                checkedStateSleep=checkedStateSleep,
                selectedAlarmSong = selectedAlarmSong,
                selectedAlarmPulse = selectedAlarmPulse,
                selectedAlarmInterval = selectedAlarmInterval,
                selectedAlarmRepeat = selectedAlarmRepeat,
                onSetAlarmSound = { navController.navigate(Screen.AlarmSound.name) },
                onSetAlarmPulse = { navController.navigate(Screen.AlarmPulse.name) },
                onSetAlarmSleep = { navController.navigate(Screen.AlarmSleep.name) },
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
                onAlarmSave = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
                onAlarmDismiss = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
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
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmSoundSave = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmSoundDismiss = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
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
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmPulseSave = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmPulseDismiss = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
            )
        }
        composable(NavigationItem.AlarmSleep.route,
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
            AlarmSleep(
                checkedStateSleep= checkedStateSleep,
                intervalList = alarmIntervalList,
                repeatList = alarmRepeatList,
                selectedAlarmInterval = selectedAlarmInterval,
                selectedAlarmRepeat = selectedAlarmRepeat,
                originalSelectedInterval = originalSelectedInterval,
                originalSelectedRepeat = originalSelectedRepeat,
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmSleepSave = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
                onAlarmSleepDismiss = {
                    navController.popBackStack()
                    navController.navigate(Screen.AlarmSet.name) },
            )
        }
        composable(NavigationItem.CalendarPicker.route,
            enterTransition = {
                when (initialState.destination.route) {
                    Screen.MainPage.name->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.MainPage.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.MainPage.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.MainPage.name->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
        ) {
            CalendarPicker(
                datePickerState = datePickerState,
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
            )
        }
        composable(NavigationItem.MainPage.route
        ) {
            MainPage(
                alarmTitle = alarmTitleValue,
                timePickerState=timePickerState,
                datePickerState = datePickerState,
                selectionWeek=selectionWeek,
                checkedAlarmState=checkedAlarmState,
                onSetAlarm = { navController.navigate(Screen.AlarmSet.name) },
                onSetCalendar = { navController.navigate(Screen.CalendarPicker.name) }
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