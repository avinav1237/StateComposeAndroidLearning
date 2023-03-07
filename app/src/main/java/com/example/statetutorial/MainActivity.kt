package com.example.statetutorial

import WellnessTaskItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statetutorial.ui.theme.StateTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }

    /**
     * Wellness Screen pahse 1 done
     */

//    @Composable
//    fun WellnessScreen(modifier: Modifier = Modifier) {
//        Column(modifier = modifier) {
//            StatefulCounter()
//            val list = remember { getWellnessTasks().toMutableStateList() }
//            WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
//        }
//
//    }
    /**
     * WellnessScreen Phase 2
     */
    @Composable
    fun WellnessScreen(
        modifier: Modifier = Modifier,
        wellnessViewModel: WellnessViewModel = viewModel()
    ) {
        Column(modifier = modifier) {
            StatefulCounter()

            WellnessTasksList(
                list = wellnessViewModel.tasks,
                onCheckedTask = {task, checked ->
                    wellnessViewModel.changeTaskChecked(task, checked)
                },
                onCloseTask = { task -> wellnessViewModel.remove(task) })
        }
    }
    //    @Composable
//    private fun WaterCounter(modifier: Modifier) {
//        Column(modifier = modifier.padding(16.dp)) {
//            var count by remember { mutableStateOf(0) }
//            if (count > 0) {
//                var showTask by remember {
//                    mutableStateOf(true)
//                }
//                if (showTask) {
//                    WellnessTaskItem(
//                        taskName = "Have you taken 15 minute walk today?",
//                        onClose = { showTask = false }
//                    )
//                }
//                Text("You've had $count glasses.")
//            }
//            Row(modifier = Modifier.padding(top = 8.dp)) {
//                Button(onClick = { count++ }, enabled = count < 10) {
//                    Text("Add one")
//                }
//
//                Button(
//                    onClick = { count = 0 },
//                    modifier = Modifier.padding(start = 8.dp)
//                ) {
//                    Text(
//                        text = "Clear water count"
//                    )
//                }
//
//            }
//        }
//    }
    @Composable
    fun WaterCounter(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {
            var count by rememberSaveable { mutableStateOf(0) }
            if (count > 0) {
                Text("You've had $count glasses.")
            }
            Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
                Text("Add one")
            }
        }
    }

    @Composable
     fun StatefulCounter(modifier: Modifier = Modifier) {
        var count by rememberSaveable { mutableStateOf(0) }
        StateLessCounter(count, { count++ }, modifier)
    }

    @Composable
    fun StateLessCounter(
        count: Int,
        onIncrement: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        if (count > 0) {
            Text(text = "You have $count glasses of water")
        }
        Button(
            onClick = { onIncrement },
            modifier = Modifier.padding(
                top = 8.dp
            ),
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }
}