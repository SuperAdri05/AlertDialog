package com.example.alertdialog
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Definimos los tipos de diálogos
enum class DialogType {
    ConfirmAction, Delete, ImportantInfo, Authenticate, CriticalError
}

@Composable
fun AlertDialogHandler(
    type: DialogType,
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    when (type) {
        DialogType.ConfirmAction -> {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text("Confirmación de Acción", fontSize = 22.sp, color = Color.Blue, fontWeight = FontWeight.Bold) },
                text = { Text("¿Estás seguro de que deseas continuar con esta acción?", fontSize = 18.sp, color = Color.DarkGray) },
                confirmButton = {
                    Button(
                        onClick = {
                            onConfirm("Acción Confirmada")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Text("Sí", fontSize = 18.sp, color = Color.White)
                    }
                },
                dismissButton = {
                    Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                        Text("No", fontSize = 18.sp, color = Color.White)
                    }
                }
            )
        }
        DialogType.Delete -> {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text("Eliminar Elemento", fontSize = 22.sp, color = Color.Red, fontWeight = FontWeight.Bold) },
                text = { Text("Esta acción es irreversible. ¿Deseas eliminar este elemento?", fontSize = 18.sp, color = Color.DarkGray) },
                confirmButton = {
                    Button(
                        onClick = {
                            onConfirm("Elemento Eliminado")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text("Eliminar", fontSize = 18.sp, color = Color.White)
                    }
                },
                dismissButton = {
                    Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                        Text("Cancelar", fontSize = 18.sp, color = Color.White)
                    }
                }
            )
        }
        DialogType.ImportantInfo -> {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text("Aviso Importante", fontSize = 22.sp, color = Color.Magenta, fontWeight = FontWeight.Bold) },
                text = { Text("Recuerda que los cambios realizados no se pueden deshacer.", fontSize = 18.sp, color = Color.DarkGray) },
                confirmButton = {
                    Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                        Text("Entendido", fontSize = 18.sp, color = Color.White)
                    }
                }
            )
        }
        DialogType.Authenticate -> {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text("Requiere Autenticación", fontSize = 22.sp, color = Color.Blue, fontWeight = FontWeight.Bold) },
                text = { Text("Para continuar, necesitas autenticarte de nuevo.", fontSize = 18.sp, color = Color.DarkGray) },
                confirmButton = {
                    Button(
                        onClick = {
                            onConfirm("Usuario Autenticado")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                    ) {
                        Text("Autenticar", fontSize = 18.sp, color = Color.White)
                    }
                },
                dismissButton = {
                    Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                        Text("Cancelar", fontSize = 18.sp, color = Color.White)
                    }
                }
            )
        }
        DialogType.CriticalError -> {
            AlertDialog(
                onDismissRequest = onDismiss,
                title = { Text("Error Crítico", fontSize = 22.sp, color = Color.Red, fontWeight = FontWeight.Bold) },
                text = { Text("Se ha producido un error crítico. ¿Deseas intentar nuevamente?", fontSize = 18.sp, color = Color.DarkGray) },
                confirmButton = {
                    Button(
                        onClick = {
                            onConfirm("Intento de Reintento")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                    ) {
                        Text("Reintentar", fontSize = 18.sp, color = Color.Black)
                    }
                },
                dismissButton = {
                    Button(onClick = onDismiss, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                        Text("Cancelar", fontSize = 18.sp, color = Color.White)
                    }
                }
            )
        }
    }
}

