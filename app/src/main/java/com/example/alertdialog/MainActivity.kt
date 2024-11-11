package com.example.alertdialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var mainText by remember { mutableStateOf("Texto Principal") }
    var dialogType by remember { mutableStateOf<DialogType?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto principal con tamaño y color personalizado
        Text(
            text = mainText,
            fontSize = 24.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botones con tamaño de texto y color de fondo personalizado
        Button(
            onClick = { dialogType = DialogType.ConfirmAction },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text("Confirmación de Acción", fontSize = 20.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { dialogType = DialogType.Delete },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Eliminación Permanente", fontSize = 20.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { dialogType = DialogType.ImportantInfo },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text("Información Importante", fontSize = 20.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { dialogType = DialogType.Authenticate },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text("Autenticación Requerida", fontSize = 20.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { dialogType = DialogType.CriticalError },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text("Error Crítico", fontSize = 20.sp, color = Color.Black)
        }

        // Mostrar AlertDialog según el tipo seleccionado
        dialogType?.let { type ->
            AlertDialogHandler(
                type = type,
                onConfirm = { resultText ->
                    mainText = resultText
                    dialogType = null // cerrar el dialog
                },
                onDismiss = { dialogType = null } // cerrar el dialog sin acción
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApp()
}

