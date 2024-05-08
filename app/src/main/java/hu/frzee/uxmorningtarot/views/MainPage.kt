package hu.frzee.uxmorningtarot.views

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.Typography_Card
import hu.frzee.uxmorningtarot.themes.Typography_Mono
import hu.frzee.uxmorningtarot.views.helpers.DateUtils
import hu.frzee.uxmorningtarot.views.helpers.WeekDaySelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(
    alarmTitle: MutableState<String>,
    timePickerState: TimePickerState,
    datePickerState: DatePickerState,
    selectionWeek : List<MutableState<Boolean>>,
    checkedAlarmState: MutableState<Boolean>,
    onSetAlarm: () -> Unit,
    onSetCalendar: () -> Unit,
    onSetNote: () -> Unit,
    onTarotDeck: () -> Unit,
    modifier: Modifier = Modifier
) {
    val millisToLocalDate = datePickerState.selectedDateMillis?.let {
        DateUtils().convertMillisToLocalDate(it)
    }
    val dateToString = millisToLocalDate?.let {
        DateUtils().dateToString(millisToLocalDate)
    } ?: ""

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary)
            .padding(4.dp, 0.dp, 4.dp, 48.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Ébresztő",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = Typography_Mono.titleMedium
                )
            },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp, 0.dp, 12.dp, 0.dp)
                .weight(1f, false)
        ){
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(
                                vertical = 4.dp)
                            .clickable { onSetAlarm() }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp,
                                    vertical = 12.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Ébresztés ekkor:",
                                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                                        textAlign = TextAlign.Center,
                                        style = Typography_Mono.titleSmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                }
                                WeekDaySelector(selectionWeek, false, MaterialTheme.colorScheme.secondary, MaterialTheme.colorScheme.surface)
                                Box(
                                    modifier = Modifier
                                        .width(171.dp)
                                        .height(45.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .align(alignment = Alignment.TopStart)
                                            .padding(horizontal = 27.dp)
                                    ) {
                                        Text(
                                            text = timePickerState.hour.toString(),
                                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                                            textAlign = TextAlign.Center,
                                            lineHeight = 2.29.em,
                                            style = MaterialTheme.typography.headlineMedium,
                                            modifier = Modifier
                                                .requiredWidth(width = 36.dp)
                                                .requiredHeight(height = 37.dp)
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                        Text(
                                            text = ":",
                                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                                            textAlign = TextAlign.Center,
                                            lineHeight = 2.em,
                                            style = MaterialTheme.typography.headlineLarge,
                                            modifier = Modifier
                                                .requiredWidth(width = 10.dp)
                                                .requiredHeight(height = 37.dp)
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                        Text(
                                            text = timePickerState.minute.toString(),
                                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                                            textAlign = TextAlign.Center,
                                            lineHeight = 2.29.em,
                                            style = MaterialTheme.typography.headlineMedium,
                                            modifier = Modifier
                                                .requiredWidth(width = 39.dp)
                                                .requiredHeight(height = 36.dp)
                                                .wrapContentHeight(align = Alignment.CenterVertically))
                                    }
                                }

                            }
                            if(alarmTitle.value != ""){
                                Text(
                                    text = alarmTitle.value,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.43.em,
                                    style = Typography_Mono.titleSmall,
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(31.dp)
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 9.dp)
                            ) {
                                Text(
                                    text = "Jelzés kikapcsolása",
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.43.em,
                                    style = MaterialTheme.typography.labelLarge,
                                    modifier = Modifier
                                        .width(140.dp)
                                        .height(31.dp)
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                Switch(
                                    checked = checkedAlarmState.value,
                                    onCheckedChange = { checkedAlarmState.value = it })
                            }
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 173.dp)
                                .weight(weight = 0.5f)
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.onPrimary)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.Bottom,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 67.dp)
                                    .padding(all = 6.dp)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = painterResource(id = R.mipmap.cute_sun),
                                        contentDescription = "Sun",
                                        modifier = Modifier
                                            .requiredSize(size = 50.dp))
                                }
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Text(
                                        text = "26°C",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        style = Typography_Mono.titleSmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                    Text(
                                        text = "Hőérzet 23°C",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        style = Typography_Mono.bodySmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                }
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 3.dp,
                                        vertical = 3.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.mipmap.image_cloudy),
                                        contentDescription = "Weather details-wind",
                                        modifier = Modifier
                                            .requiredSize(size = 20.dp))
                                    Text(
                                        text = "Szél 7mph",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        textAlign = TextAlign.Center,
                                        style = Typography_Mono.bodySmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                }
                                HorizontalDivider()
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.mipmap.image_wet),
                                        contentDescription = "Weather details-wet",
                                        modifier = Modifier
                                            .requiredSize(size = 20.dp))
                                    Text(
                                        text = "Páratartalom: alacsony",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        textAlign = TextAlign.Center,
                                        style = Typography_Mono.bodySmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                }
                                HorizontalDivider()
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.mipmap.image_sunset),
                                        contentDescription = "Weather details-sunset",
                                        modifier = Modifier
                                            .requiredSize(size = 20.dp))
                                    Text(
                                        text = "Naplemente: 18:30",
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        textAlign = TextAlign.Center,
                                        style = Typography_Mono.bodySmall,
                                        modifier = Modifier
                                            .fillMaxWidth())
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 173.dp)
                                .weight(weight = 0.5f)
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp)
                                .clickable { onSetCalendar() }
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Naptár",
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Center,
                                    style = Typography_Mono.titleSmall,
                                    modifier = Modifier
                                        .requiredHeight(height = 36.dp))
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 48.dp)
                            ) {
                                Text(
                                    text = dateToString,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.5.em,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .fillMaxSize())
                            }
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(
                                vertical = 4.dp)
                            .clickable { onTarotDeck() }
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp,
                                    vertical = 16.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Tarot kártya húzás",
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.33.em,
                                    style = Typography_Card.titleLarge,
                                    modifier = Modifier
                                        .fillMaxWidth())
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(100.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 10.dp),
                                modifier = Modifier
                                    .requiredHeight(height = 40.dp)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .requiredHeight(height = 40.dp)
                                ) {
                                        Text(
                                            text = "Kihúzom a mai kártyákat",
                                            color = MaterialTheme.colorScheme.onPrimary,
                                            textAlign = TextAlign.Center,
                                            lineHeight = 1.43.em,
                                            style = MaterialTheme.typography.labelLarge,
                                            modifier = Modifier
                                                .wrapContentHeight(align = Alignment.CenterVertically))

                                }
                            }
                        }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 173.dp)
                                .weight(weight = 0.5f)
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.Bottom,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 6.dp)
                            ) {
                                Text(
                                    text = "Névnap",
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Center,
                                    style = Typography_Mono.titleSmall,
                                    modifier = Modifier
                                        .fillMaxWidth())
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 48.dp)
                            ) {
                                Text(
                                    text = "A mai névnaposok:\nKonrád, Zsombor",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.43.em,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier
                                        .fillMaxSize())
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 173.dp)
                                .weight(weight = 0.5f)
                                .clip(shape = RoundedCornerShape(40.dp))
                                .background(color = MaterialTheme.colorScheme.onPrimary)
                                .border(border = BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                                    shape = RoundedCornerShape(40.dp))
                                .padding(horizontal = 8.dp)
                                .clickable { onSetNote() }
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                                verticalAlignment = Alignment.Bottom,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 6.dp)
                            ) {
                                Text(
                                    text = "Jegyzet",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    textAlign = TextAlign.Center,
                                    style = Typography_Mono.titleSmall,
                                    modifier = Modifier
                                        .fillMaxWidth())
                            }
                        }
                    }
                }
            }
        }
    }
}





@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier
                .fillMaxWidth())
    }
}

@Preview(widthDp = 360, heightDp = 800,  name = "Light Mode")
@Preview(widthDp = 360, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun MainPagePreview() {
    var alarmTitleValue = remember { mutableStateOf("") }
    val selectionWeek = mutableListOf<Boolean>()
    for (i in 1..7) {
        selectionWeek.add(false)
    }
    val checkedAlarmState = remember { mutableStateOf(true) }
    //MainPage(alarmTitleValue,selectionWeek,checkedAlarmState,{},Modifier)
}