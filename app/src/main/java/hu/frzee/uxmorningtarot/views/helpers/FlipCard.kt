package hu.frzee.uxmorningtarot.views.helpers

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import hu.frzee.uxmorningtarot.R

@Composable
fun FlipCard(
    rotated: MutableState<Boolean>,
    image_resource: Int
) {

    //var rotated = remember { mutableStateOf(false) }

    val rotation = animateFloatAsState(
        targetValue = if (rotated.value) 180f else 0f,
        animationSpec = tween(500)
    )

    val animateFront =  animateFloatAsState(
        targetValue = if (!rotated.value) 1f else 0f,
        animationSpec = tween(500)
    )

    val animateBack = animateFloatAsState(
        targetValue = if (rotated.value) 1f else 0f,
        animationSpec = tween(500)
    )


    Card(
        onClick = { rotated.value = !rotated.value },
        modifier = Modifier
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 8 * density
            }
    ) {
            Image(
                painter = if (rotated.value) painterResource(id = R.mipmap.card_00) else painterResource(id = R.mipmap.card_back),
                contentDescription = "Card",
                modifier = Modifier
                    .graphicsLayer {
                        alpha = if (rotated.value) animateBack.value else animateFront.value
                        rotationY = rotation.value
                    }
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