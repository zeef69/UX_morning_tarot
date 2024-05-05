package hu.frzee.uxmorningtarot.navigation

enum class Screen() {
    Loading,
    MainPage,
    AlarmSet,
    AlarmSound
}
sealed class NavigationItem(val route: String) {
    object Loading : NavigationItem(Screen.Loading.name)
    object MainPage : NavigationItem(Screen.MainPage.name)
    object AlarmSet : NavigationItem(Screen.AlarmSet.name)
    object AlarmSound : NavigationItem(Screen.AlarmSound.name)
}