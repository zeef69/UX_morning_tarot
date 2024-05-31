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
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.Typography_Card
import hu.frzee.uxmorningtarot.themes.Typography_Mono
import hu.frzee.uxmorningtarot.views.helpers.FlipCard
import hu.frzee.uxmorningtarot.views.helpers.TarotCardValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarotCardMeaning(
    _cardType: String?,
    onBackNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {

    var cardType : TarotCardValue = _cardType?.let { TarotCardValue.valueOf(it.replace("{", "").replace("}","")) } ?: TarotCardValue.Card0_Bolond

    var selectedCardNum = remember { mutableIntStateOf(3) }
    var rotatedCard = remember { mutableStateOf(true) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Kártya jelentése",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = Typography_Mono.titleMedium
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { onBackNavigate() },
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
                .padding(12.dp, 0.dp, 12.dp, 47.dp)
                .weight(1f, false)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f, false)
                    .verticalScroll(rememberScrollState())
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 8.dp,
                            vertical = 16.dp
                        )
                ) {
                    Text(
                        text = cardType.getName(),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        style = Typography_Card.displayMedium,
                        modifier = Modifier
                            .fillMaxWidth())
                    FlipCard(
                        rotated = rotatedCard,
                        card = cardType,
                        onClick = {},
                        selectedCardNum = selectedCardNum
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = MaterialTheme.shapes.small)
                            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                            .padding(6.dp)
                    ) {
                        Text(
                            text = "Kulcsszavak:",
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            textAlign = TextAlign.Center,
                            style = Typography_Mono.titleSmall)
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 6.dp,16.dp, 8.dp)
                        ) {
                            Text(
                                text = cardType.getKeywords(),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                lineHeight = 1.43.em,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .fillMaxWidth())
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = MaterialTheme.shapes.small)
                            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                            .padding(6.dp)
                    ) {
                        Text(
                            text = "Értelmezése:",
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            textAlign = TextAlign.Center,
                            style = Typography_Mono.titleSmall)
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp, 6.dp,16.dp, 8.dp)
                        ) {
                            Text(
                                text = cardType.getMeaning(),
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                lineHeight = 1.43.em,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .fillMaxWidth())
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
private fun TarotCardMeaningPreview() {
    //NotePage({},Modifier)
}