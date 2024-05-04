package hu.frzee.uxmorningtarot.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColorScheme(
    primary = primary_light,
    primaryContainer = primaryContainer_light,
    onPrimaryContainer = onPrimaryContainer_light,
    inversePrimary = inversePrimary_light,
    onPrimary = onPrimary_light,
    secondary = secondary_light,
    onSecondary = onSecondary_light,
    secondaryContainer = secondaryContainer_light,
    onSecondaryContainer = onSecondaryContainer_light,
    tertiary = tertiary_light,
    onTertiaryContainer = onTertiaryContainer_light,
    onTertiary = onTertiary_light,
    tertiaryContainer = tertiaryContainer_light,
    surface = surface_light,
    onSurface = surfaceTint_light,
    surfaceVariant = surfaceVariant_light,
    onSurfaceVariant = onSurfaceVariant_light,
    surfaceTint = surfaceTint_light,
    background = background_light,
    onBackground = onBackground_light,
    outline = outline_light,
    outlineVariant = outlineVariant_light,
    surfaceContainer = surfaceContainer_light,
    surfaceContainerLowest = surfaceContainerLowest_light,
    surfaceContainerLow = surfaceContainerLow_light,
    surfaceContainerHigh = surfaceContainerHigh_light,
    surfaceContainerHighest = surfaceContainerHighest_light,
    surfaceBright = surfaceBright_light,
    surfaceDim = surfaceDim_light,
    scrim = scrim_light
)

private val DarkColorPalette = darkColorScheme(
    primary = primary_dark ,
    primaryContainer = primaryContainer_dark,
    onPrimaryContainer = onPrimaryContainer_dark,
    inversePrimary = inversePrimary_dark,
    onPrimary = onPrimary_dark,
    secondary = secondary_dark,
    onSecondary = onSecondary_dark,
    secondaryContainer = secondaryContainer_dark,
    onSecondaryContainer = onSecondaryContainer_dark,
    tertiary = tertiary_dark,
    onTertiaryContainer = onTertiaryContainer_dark,
    onTertiary = onTertiary_dark,
    tertiaryContainer = tertiaryContainer_dark,
    surface = surface_dark,
    onSurface = surfaceTint_dark,
    surfaceVariant = surfaceVariant_dark,
    onSurfaceVariant = onSurfaceVariant_dark,
    surfaceTint = surfaceTint_dark,
    background = background_dark,
    onBackground = onBackground_dark,
    outline = outline_dark,
    outlineVariant = outlineVariant_dark,
    surfaceContainer = surfaceContainer_dark,
    surfaceContainerLowest = surfaceContainerLowest_dark,
    surfaceContainerLow = surfaceContainerLow_dark,
    surfaceContainerHigh = surfaceContainerHigh_dark,
    surfaceContainerHighest = surfaceContainerHighest_dark,
    surfaceBright = surfaceBright_dark,
    surfaceDim = surfaceDim_dark,
    scrim = scrim_dark
)

@Composable
fun MorningTarotTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography_M3,
        shapes = Shapes,
        content = content
    )
}