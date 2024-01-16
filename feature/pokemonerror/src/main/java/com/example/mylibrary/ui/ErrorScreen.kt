package com.example.mylibrary.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mylibrary.R
import com.example.ui.topbar.Screen

@Composable
fun ErrorScreen(
    navHostController: NavHostController
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_view))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        LottieAnimation(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

        Text(
            modifier = Modifier.padding(
                vertical = 24.dp,
                horizontal = 16.dp
            ),
            textAlign = TextAlign.Center,
            text = "Oops something went wrong, I'm sorry",
            style = MaterialTheme.typography.titleLarge
        )


        OutlinedButton(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            border = BorderStroke(
                1.dp,
                MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = {  navHostController.navigate(Screen.PokemonList.route)}
        ) {
            Text(
                color = MaterialTheme.colorScheme.primary,
                text = "Got it"
            )
        }
    }
}