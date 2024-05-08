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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
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
import hu.frzee.uxmorningtarot.views.helpers.FlipCard
import hu.frzee.uxmorningtarot.views.helpers.HorizontalDiv
import hu.frzee.uxmorningtarot.views.helpers.LabelWithSwitch
import hu.frzee.uxmorningtarot.views.helpers.RadioButtonList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarotDeck(
    rotatedCard1: MutableState<Boolean>,
    rotatedCard2: MutableState<Boolean>,
    onBackNavigate: () -> Unit,
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
                .padding(12.dp, 10.dp, 12.dp, 10.dp)
                .weight(1f, false)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Válassz még 1 kártyát!",
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
                        .background(color = Color(0xffeddcff))
                        .padding(all = 24.dp)
                ) {
                    item() {
                        FlipCard(
                            rotated=rotatedCard1,
                            image_resource=R.mipmap.card_00
                        )
                    }
                    item() {
                        FlipCard(
                            rotated=rotatedCard2,
                            image_resource=R.mipmap.card_01
                        )
                    }
                    item() {
                        FlipCard(
                            rotated=rotatedCard1,
                            image_resource=R.mipmap.card_00
                        )
                    }
                    item() {
                        FlipCard(
                            rotated=rotatedCard2,
                            image_resource=R.mipmap.card_01
                        )
                    }
                    item() {
                        FlipCard(
                            rotated=rotatedCard1,
                            image_resource=R.mipmap.card_00
                        )
                    }
                    item() {
                        FlipCard(
                            rotated=rotatedCard2,
                            image_resource = R.mipmap.card_01
                        )
                    }
                }
            }

        }
    }

}


/*
* @Composable
fun CardsDrawing2Light(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 800.dp)
                .background(color = Color.White)
        ) {

            },
            actions = {
            Spacer(
            modifier = Modifier
                        .requiredHeight(height = 48.dp))
            })
        LazyColumn(
            modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
            ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                    ) {
                    Text(
                        text = "Válassz még 1 kártyát!",
                        color = Color(0xff250e44),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                                                fontSize = 32.sp,
                                                fontWeight = FontWeight.Bold,
                                                letterSpacing = 0.2.sp),
                        modifier = Modifier
                                                .fillMaxWidth())
                    }
                }
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxWidth()
                    ) {
                    TarotCardDeck()
                    }
                }
            item {
                Horizontalinset()
                }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 16.dp,
                                                            end = 24.dp,
                                                            top = 16.dp,
                                                            bottom = 16.dp)
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.tarotcard),
                        contentDescription = "Tarot Card",
                        modifier = Modifier
                                                .requiredWidth(width = 139.dp)
                                                .requiredHeight(height = 232.dp)
                                                .clip(shape = RoundedCornerShape(20.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.tarotcard),
                        contentDescription = "Tarot Card",
                        modifier = Modifier
                                                .requiredWidth(width = 139.dp)
                                                .requiredHeight(height = 232.dp)
                                                .clip(shape = RoundedCornerShape(20.dp)))
                    }
                }
            }
        ConfigurationiconLabelSegments3(
            modifier = Modifier
                        .align(alignment = Alignment.BottomStart)
                        .offset(x = 0.dp,
                                    y = 0.dp))
        }
 }

@Composable
fun TarotCardDeck(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xffeddcff))
                        .padding(all = 24.dp)
            ) {
            items(22) {
                Image(
                    painter = painterResource(id = R.drawable.tarotcard22),
                    contentDescription = "Tarot Card22",
                    modifier = Modifier
                                        .requiredWidth(width = 139.dp)
                                        .requiredHeight(height = 232.dp)
                                        .clip(shape = RoundedCornerShape(20.dp)))
                }
            }
        }
 }

@Composable
fun Horizontalinset(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
        Divider(
            color = Color(0xff7b757f),
            modifier = Modifier
                        .fillMaxWidth())
        }
 }

@Composable
fun ConfigurationiconLabelSegments3(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        modifier = modifier
                .fillMaxWidth()
                .background(color = Color(0xffe8e7e9))
                .padding(horizontal = 8.dp)
        ) {
        NavigationBarItem(
            icon = {
            Icon(
            painter = painterResource(id = R.drawable.menu_24px),
            contentDescription = "Icon",
            tint = Color(0xff4a454e))
            },
            alwaysShowLabel = true,
            selected = false,
            onClick = { })
        NavigationBarItem(
            icon = {
            Icon(
            painter = painterResource(id = R.drawable.check_box_outline_blank),
            contentDescription = "Icon",
            tint = Color(0xff4a454e))
            },
            alwaysShowLabel = true,
            selected = false,
            onClick = { })
        NavigationBarItem(
            icon = {
            Icon(
            painter = painterResource(id = R.drawable.navigate_before),
            contentDescription = "Icon",
            tint = Color(0xff4a454e))
            },
            alwaysShowLabel = true,
            selected = false,
            onClick = { })
        }
 }

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun CardsDrawing2LightPreview() {
    CardsDrawing2Light(Modifier)
 }
*
* */


@Preview(widthDp = 360, heightDp = 800,  name = "Light Mode")
@Preview(widthDp = 360, heightDp = 800, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun TarotDeckPreview() {
    //NotePage({},Modifier)
}