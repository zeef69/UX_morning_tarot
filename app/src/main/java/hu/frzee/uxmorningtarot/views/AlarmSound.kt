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
import androidx.compose.foundation.lazy.LazyColumn
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
import hu.frzee.uxmorningtarot.views.helpers.HorizontalDiv
import hu.frzee.uxmorningtarot.views.helpers.LabelWithSwitch
import hu.frzee.uxmorningtarot.views.helpers.RadioButtonList
import hu.frzee.uxmorningtarot.views.helpers.WeekDaySelector


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmSound(
    checkedStateSound: MutableState<Boolean>,
    songList: List<String>,
    selectedAlarmSong : MutableState<String>,
    originalSelectedSong: MutableState<String>,
    onBackNavigate: () -> Unit,
    onAlarmSoundSave: () -> Unit,
    onAlarmSoundDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Ébresztőhang",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = Typography_Mono.titleMedium
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
                    .weight(0.2f, false)
                    .padding(all = 8.dp)
            ) {
                LabelWithSwitch(checkedStateSound, onClickText={},"Bekapcsolás", "")
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.7f, false)
                    .padding(all = 6.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                HorizontalDiv(modifier = Modifier.padding(horizontal = 10.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(28.dp))
                        .background(color = MaterialTheme.colorScheme.surface)
                        .padding(all = 16.dp)
                ) {
                    RadioButtonList(songList, selectedAlarmSong)
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.1f, false)
                    .padding(horizontal = 6.dp)
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
                        onClick = {
                            originalSelectedSong.value = selectedAlarmSong.value
                            onAlarmSoundSave()
                        },
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
                        onClick = {
                            selectedAlarmSong.value = originalSelectedSong.value
                            onAlarmSoundDismiss() },
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

@Preview(widthDp = 360, heightDp = 800,  name = "Light Mode")
@Preview(widthDp = 360, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun AlarmSoundPreview() {
    val checkedStateSound = remember { mutableStateOf(true) }
    var alarmSongList = listOf("My Song", "Madár dal", "Aktuális kedvenc", "Pittyegés", "Reggeli torna")
    var alarmSongValue : MutableState<String> = remember { mutableStateOf(alarmSongList[0]) }
    var selectedAlarmSong by remember { mutableStateOf(alarmSongValue) }
    var originalSongValue : MutableState<String> = remember { mutableStateOf("My Song") }
    var originalSelectedSong by remember { mutableStateOf(originalSongValue) }
    AlarmSound(checkedStateSound,alarmSongList,selectedAlarmSong,originalSelectedSong,{},{},{},Modifier)
}