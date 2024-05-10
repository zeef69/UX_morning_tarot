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
import android.speech.tts.TextToSpeech
import androidx.collection.MutableObjectList
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.Typography_Mono
import hu.frzee.uxmorningtarot.views.helpers.FlipCard
import hu.frzee.uxmorningtarot.views.helpers.TarotCardValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarotDeck(
    selectedCards: MutableObjectList<TarotCardValue>,
    selectedCardNum: MutableIntState,
    rotatedCard0: MutableState<Boolean>,
    rotatedCard1: MutableState<Boolean>,
    rotatedCard2: MutableState<Boolean>,
    rotatedCard3: MutableState<Boolean>,
    rotatedCard4: MutableState<Boolean>,
    rotatedCard5: MutableState<Boolean>,
    rotatedCard6: MutableState<Boolean>,
    rotatedCard7: MutableState<Boolean>,
    rotatedCard8: MutableState<Boolean>,
    rotatedCard9: MutableState<Boolean>,
    rotatedCard10: MutableState<Boolean>,
    rotatedCard11: MutableState<Boolean>,
    rotatedCard12: MutableState<Boolean>,
    rotatedCard13: MutableState<Boolean>,
    rotatedCard14: MutableState<Boolean>,
    rotatedCard15: MutableState<Boolean>,
    rotatedCard16: MutableState<Boolean>,
    rotatedCard17: MutableState<Boolean>,
    rotatedCard18: MutableState<Boolean>,
    rotatedCard19: MutableState<Boolean>,
    rotatedCard20: MutableState<Boolean>,
    rotatedCard21: MutableState<Boolean>,
    btnSpeak: MutableState<Boolean>,
    tts: TextToSpeech?,
    onCardMeaning: (TarotCardValue) -> Unit,
    onBackNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotatedCard =  ArrayList<MutableState<Boolean>>()
    var rotatedCard_0 = remember { mutableStateOf(true) }
    var rotatedCard_1 = remember { mutableStateOf(true) }
    var rotatedCard_2 = remember { mutableStateOf(true) }
    rotatedCard.add(rotatedCard_0)
    rotatedCard.add(rotatedCard_1)
    rotatedCard.add(rotatedCard_2)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Napi tarot",
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
                .padding(0.dp, 10.dp, 0.dp, 10.dp)
                .weight(1f, false)
        ) {
            if(selectedCardNum.value <3){
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Válassz még "+(3-selectedCardNum.value).toString()+" kártyát!",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        style = Typography_Mono.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.primaryContainer)
                            .padding(vertical = 20.dp, horizontal = 8.dp)
                    ) {
                        item() {
                            FlipCard(
                                rotated = rotatedCard0,
                                card = TarotCardValue.Card0_Bolond,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card0_Bolond)
                                    }},
                                selectedCardNum = selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard1,
                                card =TarotCardValue.Card1_Magus,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card1_Magus)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard2,
                                card =TarotCardValue.Card2_Fopapno,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card2_Fopapno)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard3,
                                card =TarotCardValue.Card3_Csaszarno,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card3_Csaszarno)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard4,
                                card =TarotCardValue.Card4_Csaszar,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card4_Csaszar)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard5,
                                card =TarotCardValue.Card5_Fopap,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card5_Fopap)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard6,
                                card =TarotCardValue.Card6_Szereto,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card6_Szereto)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard7,
                                card =TarotCardValue.Card7_Szeker,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card7_Szeker)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard8,
                                card =TarotCardValue.Card8_Ero,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card8_Ero)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard9,
                                card =TarotCardValue.Card9_Remete,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card9_Remete)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard10,
                                card =TarotCardValue.Card10_Szerencsekerek,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card10_Szerencsekerek)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard11,
                                card =TarotCardValue.Card11_Igazsag,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card11_Igazsag)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard12,
                                card =TarotCardValue.Card12_Akasztott,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card12_Akasztott)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard13,
                                card =TarotCardValue.Card13_Halal,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card13_Halal)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard14,
                                card =TarotCardValue.Card14_Mertekletesseg,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card14_Mertekletesseg)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard15,
                                card =TarotCardValue.Card15_Ordog,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card15_Ordog)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard16,
                                card =TarotCardValue.Card16_Torony,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card16_Torony)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard17,
                                card =TarotCardValue.Card17_Csillag,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card17_Csillag)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard18,
                                card =TarotCardValue.Card18_Hold,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card18_Hold)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard19,
                                card =TarotCardValue.Card19_Nap,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card19_Nap)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard20,
                                card =TarotCardValue.Card20_Vegitelet,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card20_Vegitelet)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                        item() {
                            FlipCard(
                                rotated =rotatedCard21,
                                card =TarotCardValue.Card21_Vilag,
                                onClick = {
                                    if(selectedCardNum.value < 3){
                                        selectedCards.add(TarotCardValue.Card21_Vilag)
                                    }},
                                selectedCardNum =selectedCardNum
                            )
                        }
                    }
                }
            }
            if(selectedCardNum.value >=3){
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Kiválasztottad az összes kártyát!",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        style = Typography_Mono.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth())
                    Text(
                        text = "Szeretnéd tudni mi a kártyák jelentése?\nHa igen, akkor csak kattints az egyik kártyára és nézd meg mit üzen neked a kártya!",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        lineHeight = (1.5).em,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth())
                }
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                ) {
                    items(selectedCards.size){
                        FlipCard(
                            rotated = rotatedCard[it],
                            card = selectedCards[it],
                            onClick = { onCardMeaning(selectedCards[it]) },
                            selectedCardNum = selectedCardNum
                        )
                    }
                }
            }
            if(selectedCardNum.value >=3 && btnSpeak.value) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.1f, false)
                        .padding(horizontal = 6.dp)
                ) {
                    Text(
                        text = "Meghallgatnád inkább angolul? Olvastasd fel!",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        lineHeight = (1.5).em,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth())
                    Button(
                        onClick = {
                            speakOut(tts, selectedCards)
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
                                text = "Felolvasás",
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

fun speakOut(tts: TextToSpeech?, selectedCards: MutableObjectList<TarotCardValue> ) {
    var text = ""
    for(i in 0..<selectedCards.size){
        text += selectedCards[i].getNameEnglish()
        text += "\n"
        text += selectedCards[i].getMeaningEnglish()
        text += "\n"
    }
    tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
}

@Preview(widthDp = 360, heightDp = 800,  name = "Light Mode")
@Preview(widthDp = 360, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun TarotDeckPreview() {
    //NotePage({},Modifier)
}