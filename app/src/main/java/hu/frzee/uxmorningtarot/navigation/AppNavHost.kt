package hu.frzee.uxmorningtarot.navigation

import android.speech.tts.TextToSpeech
import android.widget.Button
import androidx.collection.mutableObjectListOf
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.frzee.uxmorningtarot.views.AlarmPulse
import hu.frzee.uxmorningtarot.views.AlarmSet
import hu.frzee.uxmorningtarot.views.AlarmSleep
import hu.frzee.uxmorningtarot.views.AlarmSound
import hu.frzee.uxmorningtarot.views.CalendarPicker
import hu.frzee.uxmorningtarot.views.Loading
import hu.frzee.uxmorningtarot.views.MainPage
import hu.frzee.uxmorningtarot.views.NotePage
import hu.frzee.uxmorningtarot.views.TarotCardMeaning
import hu.frzee.uxmorningtarot.views.TarotDeck
import hu.frzee.uxmorningtarot.views.helpers.TarotCardValue
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    btnSpeak: MutableState<Boolean>,
    tts: TextToSpeech?,
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

    var noteTitle = remember { mutableStateOf("") }
    var noteBody = remember { mutableStateOf("") }

    //Kártya állapotváltozók
    val selectedCardList = remember { mutableObjectListOf<TarotCardValue>() }
    var selectedCardNum = remember { mutableIntStateOf(0) }
    var rotatedCard0 = remember { mutableStateOf(false) }
    var rotatedCard1 = remember { mutableStateOf(false) }
    var rotatedCard2 = remember { mutableStateOf(false) }
    var rotatedCard3 = remember { mutableStateOf(false) }
    var rotatedCard4 = remember { mutableStateOf(false) }
    var rotatedCard5 = remember { mutableStateOf(false) }
    var rotatedCard6 = remember { mutableStateOf(false) }
    var rotatedCard7 = remember { mutableStateOf(false) }
    var rotatedCard8 = remember { mutableStateOf(false) }
    var rotatedCard9 = remember { mutableStateOf(false) }
    var rotatedCard10 = remember { mutableStateOf(false) }
    var rotatedCard11 = remember { mutableStateOf(false) }
    var rotatedCard12 = remember { mutableStateOf(false) }
    var rotatedCard13 = remember { mutableStateOf(false) }
    var rotatedCard14 = remember { mutableStateOf(false) }
    var rotatedCard15 = remember { mutableStateOf(false) }
    var rotatedCard16 = remember { mutableStateOf(false) }
    var rotatedCard17 = remember { mutableStateOf(false) }
    var rotatedCard18 = remember { mutableStateOf(false) }
    var rotatedCard19 = remember { mutableStateOf(false) }
    var rotatedCard20 = remember { mutableStateOf(false) }
    var rotatedCard21 = remember { mutableStateOf(false) }


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
        composable(NavigationItem.NotePage.route,
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
            NotePage(
                noteTitle = noteTitle,
                noteBody = noteBody,
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
                onNoteSave = {
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
                onNoteDismiss ={
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
            )
        }
        composable(NavigationItem.TarotDeck.route,
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
            TarotDeck(
                selectedCards = selectedCardList,
                selectedCardNum = selectedCardNum,
                rotatedCard0 = rotatedCard0,
                rotatedCard1 = rotatedCard1,
                rotatedCard2 = rotatedCard2,
                rotatedCard3 = rotatedCard3,
                rotatedCard4 = rotatedCard4,
                rotatedCard5 = rotatedCard5,
                rotatedCard6 = rotatedCard6,
                rotatedCard7 = rotatedCard7,
                rotatedCard8 = rotatedCard8,
                rotatedCard9 = rotatedCard9,
                rotatedCard10 = rotatedCard10,
                rotatedCard11 = rotatedCard11,
                rotatedCard12 = rotatedCard12,
                rotatedCard13 = rotatedCard13,
                rotatedCard14 = rotatedCard14,
                rotatedCard15 = rotatedCard15,
                rotatedCard16 = rotatedCard16,
                rotatedCard17 = rotatedCard17,
                rotatedCard18 = rotatedCard18,
                rotatedCard19 = rotatedCard19,
                rotatedCard20 = rotatedCard20,
                rotatedCard21 = rotatedCard21,
                btnSpeak = btnSpeak,
                tts = tts,
                onCardMeaning = {
                    navController.navigate(Screen.TarotCardMeaning.name+"?cardType={"+it.name+"}")
                },
                onBackNavigate = {
                    tts!!.stop()
                    navController.popBackStack()
                    navController.navigate(Screen.MainPage.name) },
            )
        }
        composable(
            NavigationItem.TarotCardMeaning.route +"?cardType={cardType}",
            arguments = listOf(navArgument("cardType") { defaultValue = TarotCardValue.Card0_Bolond.name }),
            enterTransition = {
                when (initialState.destination.route) {
                    Screen.TarotDeck.name->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    Screen.TarotDeck.name ->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    Screen.TarotDeck.name ->
                        slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    Screen.TarotDeck.name->
                        slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )

                    else -> null
                }
            },

        ) {
            TarotCardMeaning(
                _cardType = it.arguments?.getString("cardType"),
                onBackNavigate = {
                    navController.popBackStack()
                    navController.navigate(Screen.TarotDeck.name) }
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
                onSetCalendar = { navController.navigate(Screen.CalendarPicker.name) },
                onSetNote = { navController.navigate(Screen.NotePage.name) },
                onTarotDeck = { navController.navigate(Screen.TarotDeck.name) }
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