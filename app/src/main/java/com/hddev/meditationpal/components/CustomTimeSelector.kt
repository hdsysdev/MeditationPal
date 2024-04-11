package com.hddev.meditationpal.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SelectedTime(val hours: Int, val minutes: Int, val seconds: Int)

@Composable
fun CustomTimeSelector(
    selectedTime: SelectedTime,
    onTimeSelected: (SelectedTime) -> Unit
) {
    val hourValues = (0..12).map { it.toString().padStart(2, '0') }.reversed()
    val minuteValues = (1..59).map { it.toString().padStart(2, '0') }.reversed()
    val secondValues = (0..59).map { it.toString().padStart(2, '0') }.reversed()

    Column {
        Text(
            text = "Meditation Duration",
            fontSize = TextUnit(18f, TextUnitType.Sp),
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                if (selectedTime.minutes == 59 && selectedTime.seconds == 59) {
                    Picker(
                        value = selectedTime.hours,
                        onValueChange = { hours ->
                            onTimeSelected(SelectedTime(hours, selectedTime.minutes, selectedTime.seconds))
                        },
                        items = hourValues,
                        visibleItemsCount = 3,
                        modifier = Modifier.weight(0.3f),
                        textModifier = Modifier.padding(8.dp),
                        textStyle = TextStyle(fontSize = 32.sp)
                    )
                    Text(
                        text = "hours",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                Picker(
                    value = selectedTime.minutes,
                    onValueChange = { minutes ->
                        val newHours = if (minutes == 0 && selectedTime.minutes == 59) {
                            selectedTime.hours + 1
                        } else {
                            selectedTime.hours
                        }
                        onTimeSelected(SelectedTime(newHours, minutes, selectedTime.seconds))
                    },
                    items = minuteValues,
                    visibleItemsCount = 3,
                    modifier = Modifier.weight(0.3f),
                    textModifier = Modifier.padding(8.dp),
                    textStyle = TextStyle(fontSize = 32.sp)
                )
                Text(
                    text = "minutes",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
                Picker(
                    value = selectedTime.seconds,
                    onValueChange = { seconds ->
                        val newMinutes = if (seconds == 0 && selectedTime.seconds == 59) {
                            (selectedTime.minutes + 1) % 60
                        } else {
                            selectedTime.minutes
                        }
                        val newHours = if (newMinutes == 0 && selectedTime.minutes == 59) {
                            selectedTime.hours + 1
                        } else {
                            selectedTime.hours
                        }
                        onTimeSelected(SelectedTime(newHours, newMinutes, seconds))
                    },
                    items = secondValues,
                    visibleItemsCount = 3,
                    modifier = Modifier.weight(0.3f),
                    textModifier = Modifier.padding(8.dp),
                    textStyle = TextStyle(fontSize = 32.sp)
                )
                Text(
                    text = "seconds",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

