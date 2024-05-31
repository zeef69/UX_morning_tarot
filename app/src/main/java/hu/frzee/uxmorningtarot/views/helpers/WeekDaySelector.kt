package hu.frzee.uxmorningtarot.views.helpers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em


@Composable
fun WeekDaySelector(
    selectionWeek: List<MutableState<Boolean>>,
    modifiable: Boolean = true,
    selectionColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    onSelectionColor: Color = MaterialTheme.colorScheme.surfaceTint,
    onNonSelectionColor: Color = MaterialTheme.colorScheme.surfaceTint,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            DaySelector("Hé", selectionWeek[0], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Ke", selectionWeek[1], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Sze", selectionWeek[2], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Csüt", selectionWeek[3], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Pé", selectionWeek[4], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Szo", selectionWeek[5], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
            DaySelector("Vas", selectionWeek[6], modifiable, selectionColor,onSelectionColor, onNonSelectionColor)
        }
    }
}

@Composable
fun DaySelector(
    text: String = "Hét",
    selectionDay: MutableState<Boolean>,
    modifiable: Boolean = true,
    selectionColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    onSelectionColor: Color = MaterialTheme.colorScheme.surfaceTint,
    onNonSelectionColor: Color = MaterialTheme.colorScheme.surfaceTint,
    modifier: Modifier = Modifier
) {
    var modifiableSelection =
        if (modifiable) modifier.clickable { selectionDay.value = !selectionDay.value }
        else modifier
    var backgroundSelection =
        if (selectionDay.value) Modifier.background(color = selectionColor)
        else Modifier

    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifiableSelection
            .padding(
                start = 2.dp,
                end = 2.dp,
                bottom = 4.dp
            )
            .clip(shape = MaterialTheme.shapes.large)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = backgroundSelection
                .padding(all = 6.dp)
        ) {
            Text(
                text = text,
                color = if (selectionDay.value) {onSelectionColor} else onNonSelectionColor,
                textAlign = TextAlign.Center,
                lineHeight = 1.33.em,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}