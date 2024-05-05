package hu.frzee.uxmorningtarot.navigation

enum class Screen() {
    Loading,
    MainPage,
    AlarmSet,
    AlarmSound,
    AlarmPulse,
    AlarmSleep,
    CalendarPicker,
}
sealed class NavigationItem(val route: String) {
    object Loading : NavigationItem(Screen.Loading.name)
    object MainPage : NavigationItem(Screen.MainPage.name)
    object AlarmSet : NavigationItem(Screen.AlarmSet.name)
    object AlarmSound : NavigationItem(Screen.AlarmSound.name)
    object AlarmPulse : NavigationItem(Screen.AlarmPulse.name)
    object AlarmSleep : NavigationItem(Screen.AlarmSleep.name)
    object CalendarPicker : NavigationItem(Screen.CalendarPicker.name)
}