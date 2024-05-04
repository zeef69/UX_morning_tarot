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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em


@Composable
fun WeekDaySelector(
    selectionWeek: List<Boolean> = ArrayList<Boolean>(),
    modifier: Modifier = Modifier
) {
    var selectedDay1 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[0] else false) }
    var selectedDay2 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[1] else false) }
    var selectedDay3 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[2] else false) }
    var selectedDay4 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[3] else false) }
    var selectedDay5 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[4] else false) }
    var selectedDay6 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[5] else false) }
    var selectedDay7 by remember { mutableStateOf(if (selectionWeek.size >= 7) selectionWeek[6] else false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            DaySelector("Hé", selectedDay1)
            DaySelector("Ke", selectedDay2)
            DaySelector("Sze", selectedDay3)
            DaySelector("Csüt", selectedDay4)
            DaySelector("Pé", selectedDay5)
            DaySelector("Szo", selectedDay6)
            DaySelector("Vas", selectedDay7)
        }
    }
}

@Composable
fun DaySelector(
    text: String = "Hét",
    selectionDay: Boolean = false,
    modifier: Modifier = Modifier
) {
    var selectedDay by remember { mutableStateOf(selectionDay) }

    var modifierDay =
        if (selectedDay) Modifier.background(color = MaterialTheme.colorScheme.secondaryContainer)
        else Modifier
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                start = 2.dp,
                end = 2.dp,
                bottom = 4.dp
            )
            .clip(shape = MaterialTheme.shapes.large)
            .clickable { selectedDay = !selectedDay }

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifierDay
                .padding(all = 6.dp)
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.surfaceTint,
                textAlign = TextAlign.Center,
                lineHeight = 1.33.em,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}