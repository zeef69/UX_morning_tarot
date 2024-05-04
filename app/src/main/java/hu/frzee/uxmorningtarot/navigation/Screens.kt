package hu.frzee.uxmorningtarot.navigation

enum class Screen() {
    Loading,
    AlarmSet
}
sealed class NavigationItem(val route: String) {
    object Loading : NavigationItem(Screen.Loading.name)
    object AlarmSet : NavigationItem(Screen.AlarmSet.name)
}