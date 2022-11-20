package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.ui.theme.Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Challenge2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Challenge2Theme() {
                        DiceRollerApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember { mutableStateOf(1) }

    val diceImageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(diceImageResource),
            contentDescription = "Dice number ${result.toString()}",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            modifier = Modifier.width(80.dp) ,
            colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray,
            contentColor = Color.Black)
                ,
            onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    MainScreen()
}




