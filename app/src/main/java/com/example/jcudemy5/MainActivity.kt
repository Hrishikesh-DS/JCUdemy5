package com.example.jcudemy5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//Recycler view easy in JC

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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val greetingListState = remember {
            mutableStateListOf<String>("John", "Amanda")
        }
        val newNameStateContent = remember {
            mutableStateOf("")
        }
        GreetingList(greetingListState,
            newNameStateContent.value,
            {
                greetingListState.add(newNameStateContent.value)
            },
            { newName ->
                newNameStateContent.value = newName
            })
    }
}

@Composable
fun GreetingList(
    greetingListState: List<String>,
    textFieldValue: String,
    buttonClick: () -> Unit,
    textFieldUpdate: (newName: String) -> Unit
) {
    for (name in greetingListState) {
        Greeting(name = name)
    }

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
    Button(onClick = buttonClick) {
        Text(text = "Add new name")
    }
}


@Composable
fun Greeting(name: String) {
    Text(
        "Hello $name",
        style = MaterialTheme.typography.headlineLarge
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}