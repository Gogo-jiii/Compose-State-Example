package com.example.stateexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateexample.ui.theme.StateExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val mContext = LocalContext.current

    //handling the state of a single variable
    var enabled by remember { mutableStateOf(value = true) }

    //handling the state of an arraylist
    val arr = remember { mutableStateListOf("") }

    val model = remember { mutableStateListOf(ModelClass("")) }

    Box(contentAlignment = Alignment.Center) {
        Button(
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            onClick = {
                enabled = enabled != true

                arr.clear()
                arr.add("A")
                arr.add("B")
                arr.add("C")
                var value = arr[0]

                model.clear()
                model.add(ModelClass("X"))
                model.add(ModelClass("Y"))
                model.add(ModelClass("Z"))
                var value2 = model[0].name

                model.set(index = 0, ModelClass("A"))
                val value3 = model[0].name

                Toast.makeText(mContext, "Clicked: $enabled\n$value3", Toast.LENGTH_SHORT)
                    .show()
            },
        ) {
            Text(text = "Click")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    StateExampleTheme {
        Greeting()
    }
}