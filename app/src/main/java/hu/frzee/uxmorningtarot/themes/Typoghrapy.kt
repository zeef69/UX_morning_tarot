package hu.frzee.uxmorningtarot.themes

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hu.frzee.uxmorningtarot.R


val robotoFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thinitalic, FontWeight.Thin,  FontStyle.Italic)
)
val bigelowRulesFamily = FontFamily(
    Font(R.font.bigelowrules_regular, FontWeight.Normal)
)
val spaceMonoFamily = FontFamily(
    Font(R.font.spacemono_bold, FontWeight.Bold),
    Font(R.font.spacemono_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.spacemono_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.spacemono_regular, FontWeight.Normal)
)
val Typography_M3 = Typography(
    displayLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.15).sp
    ),
    titleSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.1).sp
    ),
    bodyLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.5).sp
    ),
    bodyMedium  = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.25).sp
    ),
    bodySmall  = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.4).sp
    ),
    labelLarge  = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.1).sp
    ),
    labelMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.5).sp
    ),
    labelSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = (0.5).sp
    ),
)
val Typography_Mono = Typography(
    displayMedium = TextStyle(
        fontFamily = spaceMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = spaceMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 64.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = (0.2).sp
    ),
    titleMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 26.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = spaceMonoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = spaceMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.5).sp
    ),
    bodySmall  = TextStyle(
        fontFamily = spaceMonoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = 0.sp
    ),
)

val Typography_Card = Typography(
    displayLarge = TextStyle(
        fontFamily = bigelowRulesFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = bigelowRulesFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        letterSpacing = (0.3).sp
    ),
    titleLarge = TextStyle(
        fontFamily = bigelowRulesFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 48.sp,
        letterSpacing = (0.3).sp
    ),
    titleSmall = TextStyle(
        fontFamily = bigelowRulesFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = (0.1).sp
    ),
)