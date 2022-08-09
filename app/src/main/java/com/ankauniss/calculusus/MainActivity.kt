package com.ankauniss.calculusus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var num1 by remember { mutableStateOf("1+2+3+4+5")}
        var num2 by remember { mutableStateOf("")}
        var sonuc by remember { mutableStateOf("")}

        OutlinedTextField(
            value = num1,
            onValueChange ={num1=it},
            label = { Text(text = "İşlem", fontSize = 15.sp, fontWeight = FontWeight.Light)},
        )
        DesignPage()
    }

}

@Composable
fun DesignPage() {
    Surface(modifier = Modifier.padding(0.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    NumberButtonDesign("1")
                    NumberButtonDesign("4")
                    NumberButtonDesign("7")
                    OperatorButtonDesign(".")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    NumberButtonDesign("2")
                    NumberButtonDesign("5")
                    NumberButtonDesign("8")
                    NumberButtonDesign("0")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    NumberButtonDesign("3")
                    NumberButtonDesign("6")
                    NumberButtonDesign("9")
                    OperatorButtonDesign("=")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OperatorButtonDesign("+")
                    OperatorButtonDesign("-")
                    OperatorButtonDesign("*")
                    OperatorButtonDesign("/")
                }
            }
        }
    }
}

@Composable
fun OperatorButtonDesign(buttonTxt: String) {
    Surface() {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {  },
               // modifier = Modifier.padding(Dp(1F), Dp(0F)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF5722),
                    contentColor = Color(0xFFFFF5EE),
                    disabledBackgroundColor = Color(0xFF59260B),
                    disabledContentColor = Color(0xFF8A795D)
                ),
                enabled = true,
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Red)),
                // below line is use to add shape for our button.
                shape = RectangleShape
            ) { Text(text = buttonTxt, color = Color.Black, fontWeight = FontWeight.ExtraBold)}
        }
    }
}

@Composable
fun NumberButtonDesign(buttonTxt: String) {
    Surface() {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {  },
              //  modifier = Modifier.padding(Dp(1F), Dp(0F)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF404041),
                    contentColor = Color(0xFFFFF5EE),
                    disabledBackgroundColor = Color(0xFF59260B),
                    disabledContentColor = Color(0xFF8A795D)
                ),
               // shape = RoundedCornerShape(50),
                shape = RectangleShape,
                enabled = true,
                border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Black)),
                // below line is use to add shape for our button.
              //  shape = MaterialTheme.shapes.medium,
            ) { Text(text = buttonTxt, color = Color.White, fontWeight = FontWeight.ExtraBold)}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}