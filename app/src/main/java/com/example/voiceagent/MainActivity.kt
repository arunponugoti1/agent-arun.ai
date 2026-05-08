package com.example.voiceagent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VoiceAgentScreen()
                }
            }
        }
    }
}

@Composable
fun VoiceAgentScreen() {
    var responseText by remember { mutableStateOf("Press the button and ask me anything!") }
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // TODO: Replace with your actual API Key from GCP
    val apiKey = "YOUR_GEMINI_API_KEY"
    val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = apiKey
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = responseText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }

        Button(
            onClick = {
                scope.launch {
                    isLoading = true
                    try {
                        val response = generativeModel.generateContent("Hello! Introduce yourself as a helpful AI assistant.")
                        responseText = response.text ?: "No response from AI."
                    } catch (e: Exception) {
                        responseText = "Error: ${e.message}"
                    } finally {
                        isLoading = false
                    }
                }
            },
            enabled = !isLoading
        ) {
            Text("Talk to Gemini")
        }
    }
}
