package com.example.linguistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.linguistapp.ui.theme.LinguistAppTheme
import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment


// button dependencies
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.size



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinguistAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(1f, 0f, 0f, 0.9f) // Semi-transparent red
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TitleText(title = "Linguist App", subtitle = "Let's Translate")
                        Spacer(modifier = Modifier.height(16.dp))
                        MyButton()
                    }
                }
            }
        }
    }
}

@Composable
fun TitleText(title : String, subtitle : String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp),
    ) {
        Text(
            text = title,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = subtitle,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    LinguistAppTheme {
        TitleText(title = "Linguist App", subtitle = "Let's Translate")
    }
}

// Button
@Composable
fun MyButton(modifier: Modifier = Modifier) {
    var isClicked by remember { mutableStateOf<Boolean>(false) }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = if (isClicked) Color.Yellow else Color.Blue
    )

    Button(
        onClick = {
            isClicked = !isClicked
        },
        modifier = modifier
            .padding(16.dp) // Adjusts the padding around the button
            .size(width = 200.dp, height = 50.dp),
        colors = buttonColors
    ) {
        Text("Translate")
    }
}

@Preview
@Composable
fun PreviewMyButton() {
    MyButton()
}
