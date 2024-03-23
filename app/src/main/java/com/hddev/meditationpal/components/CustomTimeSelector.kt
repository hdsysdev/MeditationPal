package com.hddev.meditationpal.components


import android.widget.EditText
import android.widget.NumberPicker
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CustomTimeSelector() {
    var time by remember { mutableStateOf("10") }
    val values = remember { (1..99).map { it.toString() } }
    val valuesPickerState = rememberPickerState()
    val units = remember { listOf("seconds", "minutes", "hours") }
    val unitsPickerState = rememberPickerState()

//    Text(text = "Example Picker", modifier = Modifier.padding(top = 16.dp))
//    Spacer(modifier = Modifier.height(32.dp))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(200.dp)
    ) {
        Text(text = "Example Picker", modifier = Modifier.padding(top = 16.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Picker(
                state = valuesPickerState,
                items = values,
                visibleItemsCount = 3,
                modifier = Modifier.weight(0.3f),
                textModifier = Modifier.padding(8.dp),
                textStyle = TextStyle(fontSize = 32.sp)
            )
            Picker(
                state = unitsPickerState,
                items = units,
                visibleItemsCount = 3,
                modifier = Modifier.weight(0.7f),
                textModifier = Modifier.padding(8.dp),
                textStyle = TextStyle(fontSize = 32.sp)
            )
        }
    }

}

