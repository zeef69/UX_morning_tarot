package hu.frzee.uxmorningtarot.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.MorningTarotTheme
import hu.frzee.uxmorningtarot.themes.Typography_Card
import hu.frzee.uxmorningtarot.themes.Typography_Mono
import hu.frzee.uxmorningtarot.themes.bigelowRulesFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmSet(
    onBackNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    val timePickerState = TimePickerState(9, 15, true)
    val selectionWeek = mutableListOf<Boolean>()
    for (i in 1..7) {
        selectionWeek.add(false)
    }
    val checkedStateSound = remember { mutableStateOf(true) }
    val checkedStateNoise = remember { mutableStateOf(true) }
    val checkedStateSleep = remember { mutableStateOf(false) }
    val checkedStateSpeech = remember { mutableStateOf(false) }
    var titleInput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Ébresztő",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = Typography_Mono.titleLarge
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = onBackNavigate,
                    content = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back_24),
                            contentDescription = "Icons/arrow_back_24px",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                )
            },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp, 10.dp, 12.dp, 20.dp)
                .weight(1f, false)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f, false)
                    .padding(all = 8.dp)
            ) {
                TimeInput(
                    state = timePickerState
                )
                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    thickness = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
                        .padding(all = 10.dp)
                ) {
                    Text(
                        text = "Holnap",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = Typography_Mono.titleSmall
                    )
                    WeekHKSCPSV(selectionWeek)
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f, false)
                    .padding(all = 6.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                TextField(
                    value = titleInput,
                    onValueChange = { titleInput = it },
                    label = {
                        Text(
                            text = "Jelzés neve",
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            lineHeight = 1.33.em,
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                    placeholder = { Text("Név") },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 56.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                )
                LabelWithSwitch(checkedStateSound, "Jelzőhang", "My Song")
                LabelWithSwitch(checkedStateNoise, "Rezgés", "Rövid", MaterialTheme.colorScheme.tertiaryContainer)
                LabelWithSwitch(checkedStateSleep, "Szundi", "")
                LabelWithSwitch(checkedStateSpeech, "Felolvasás", "",MaterialTheme.colorScheme.tertiaryContainer)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.2f, false)
                    .padding(all = 6.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        24.dp,
                        Alignment.CenterHorizontally
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 10.dp),
                        modifier = Modifier
                            .requiredHeight(height = 40.dp)

                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 40.dp)
                        ) {
                            Text(
                                text = "Mentés",
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                textAlign = TextAlign.Center,
                                lineHeight = 1.43.em,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                            )

                        }
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 10.dp),
                        modifier = Modifier
                            .requiredHeight(height = 40.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(
                                8.dp,
                                Alignment.CenterVertically
                            ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .requiredHeight(height = 40.dp)
                        ) {
                            Text(
                                text = "Mégse",
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                textAlign = TextAlign.Center,
                                lineHeight = 1.43.em,
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                            )

                        }
                    }
                }
            }

        }
    }

}

@Composable
fun WeekHKSCPSV(
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
            DaySelectionHKSCPSV("Hé", selectedDay1)
            DaySelectionHKSCPSV("Ke", selectedDay2)
            DaySelectionHKSCPSV("Sze", selectedDay3)
            DaySelectionHKSCPSV("Csüt", selectedDay4)
            DaySelectionHKSCPSV("Pé", selectedDay5)
            DaySelectionHKSCPSV("Szo", selectedDay6)
            DaySelectionHKSCPSV("Vas", selectedDay7)
        }
    }
}

@Composable
fun DaySelectionHKSCPSV(
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

@Composable
fun LabelWithSwitch(
    checkedState: MutableState<Boolean>,
    title: String = "Title",
    subText: String = "SubTitle",
    color: Color = MaterialTheme.colorScheme.background,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .requiredWidth(width = 344.dp)
            .requiredHeight(height = 56.dp)
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = color)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 24.dp
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(weight = 0.8f)
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.surfaceTint,
                    lineHeight = 1.5.em,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
                Text(
                    text = subText,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 1.43.em,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                modifier = Modifier
                    .weight(weight = 0.2f)
            ) {
                val checkedState = checkedState
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it })
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 800,  name = "Light Mode")
@Preview(widthDp = 360, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun AlarmSetPreview() {
    AlarmSet({}, Modifier)
}