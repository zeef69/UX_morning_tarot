package hu.frzee.uxmorningtarot.views.helpers

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import hu.frzee.uxmorningtarot.R
import hu.frzee.uxmorningtarot.themes.card_background_color

@Composable
fun FlipCard(
    rotated: MutableState<Boolean>,
    card: TarotCardValue,
    selectedCardNum: MutableIntState,
    onClick: () -> Unit,
    oneFlip: Boolean = true
) {

    val rotation = animateFloatAsState(
        targetValue = if (rotated.value) 180f else 0f,
        animationSpec = tween(800)
    )

    val animateFront =  animateFloatAsState(
        targetValue = if (!rotated.value) 1f else 0f,
        animationSpec = tween(800)
    )

    val animateBack = animateFloatAsState(
        targetValue = if (rotated.value) 1f else 0f,
        animationSpec = tween(800)
    )


    Card(
        onClick = {
            onClick()
            if(selectedCardNum.value < 3){
                if (!rotated.value) selectedCardNum.value++
                rotated.value = if(oneFlip) true else !rotated.value
            }},
        modifier = Modifier
            .graphicsLayer {
                rotationY = if (rotated.value) -rotation.value else rotation.value
                cameraDistance = 16 * density
            }
    ) {
            Image(
                painter = if (rotated.value) painterResource(id = card.getImage()) else painterResource(id = R.mipmap.card_back),
                contentDescription = card.getName(),
                modifier = Modifier
                    .graphicsLayer {
                        alpha = if (rotated.value) animateBack.value else animateFront.value
                        rotationY = rotation.value
                    }
                    .clip(MaterialTheme.shapes.medium)
                    .background(card_background_color)
            )

        /*
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = if (rotated.value) "Back" else "Front",
                modifier = Modifier
                    .graphicsLayer {
                        alpha = if (rotated.value) animateBack.value else animateFront.value
                        rotationY = rotation.value
                    }
            )
        }*/
    }
}