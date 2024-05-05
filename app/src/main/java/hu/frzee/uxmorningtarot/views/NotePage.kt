package hu.frzee.uxmorningtarot.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.Typography_Mono
import hu.frzee.uxmorningtarot.views.helpers.HorizontalDiv
import hu.frzee.uxmorningtarot.views.helpers.LabelWithSwitch
import hu.frzee.uxmorningtarot.views.helpers.RadioButtonList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotePage(
    noteTitle: MutableState<String>,
    noteBody: MutableState<String>,
    onBackNavigate: () -> Unit,
    onNoteSave: () -> Unit,
    onNoteDismiss: () -> Unit,
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
                    text = "Jegyzet",
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
                    .weight(0.1f, false)
                    .padding(all = 8.dp)
            ) {
                TextField(
                    value = noteTitle.value,
                    onValueChange = { noteTitle.value = it },
                    placeholder = { Text("Input") },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.surface, 
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 56.dp)
                        .clip(shape = RoundedCornerShape(8.dp)))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.8f, false)
                    .padding(horizontal = 16.dp,
                        vertical = 8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TextField(
                    value = noteBody.value,
                    onValueChange = { noteBody.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)))
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.2f, false)
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
                        onClick = onNoteSave,
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
                        onClick = onNoteDismiss,
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
private fun NotePagePreview() {
    //NotePage({},Modifier)
}