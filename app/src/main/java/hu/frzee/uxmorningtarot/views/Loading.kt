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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.MorningTarotTheme
import hu.frzee.uxmorningtarot.navigation.NavigationItem
import hu.frzee.uxmorningtarot.navigation.Screen
import hu.frzee.uxmorningtarot.themes.MorningTarotTheme
import hu.frzee.uxmorningtarot.themes.Typography_Card
import hu.frzee.uxmorningtarot.themes.bigelowRulesFamily

@Composable
fun Loading(
    onSetAlarmNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(95.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .weight(weight = 1f)
                .padding(
                    start = 2.dp,
                    end = 2.dp,
                    top = 20.dp,
                    bottom = 50.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.mipmap.main_image),
                contentDescription = "Rectangle",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .offset(
                        x = 0.dp,
                        y = 0.dp
                    )
                    .requiredWidth(width = 356.dp)
                    .requiredHeight(height = 252.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 18.dp)
            ) {
                Text(
                    text = "Ébredj Tarot húzással!",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center,
                    style = Typography_Card.displayLarge,)
            }
            Button(
                onClick = onSetAlarmNavigate,
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
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
                        text = "Ébresztés beállítása",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
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

@Preview(widthDp = 360, heightDp = 800,
    name = "Light Mode")
@Preview(
    widthDp = 360, heightDp = 800,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
private fun LoadPreview() {
    MorningTarotTheme {
        Loading(
            { },
            Modifier
        )
    }
}