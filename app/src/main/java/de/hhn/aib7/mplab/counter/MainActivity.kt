package de.hhn.aib7.mplab.counter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.hhn.aib7.mplab.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var counter by remember { mutableStateOf(0) }
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = counter.toString(),
                            style = MaterialTheme.typography.displayLarge
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Button(
                                onClick = { counter-- },
                                modifier = Modifier.width(150.dp),
                                content = {
                                    Text(
                                        text = "-",
                                        style = MaterialTheme.typography.displayMedium
                                    )
                                }
                            )
                            Button(
                                onClick = { counter++ },
                                modifier = Modifier.width(150.dp),
                                content = {
                                    Text(
                                        text = "+",
                                        style = MaterialTheme.typography.displayMedium
                                    )
                                }
                            )
                        }
                        /*Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Hello, $name",
                                modifier = Modifier.padding(bottom = 8.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            OutlinedTextField(value = name, onValueChange = {name = it}, label = { Text("Name") })
                        }*/
                        val activity = (LocalContext.current as? Activity)
                        Button(
                            onClick = {
                                activity?.startActivity(Intent(this@MainActivity, EndActivity::class.java))
                            },
                            modifier = Modifier.width(300.dp),
                            content = {
                                Text(
                                    text = "next screen",
                                    style = MaterialTheme.typography.displayMedium
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
    }
}