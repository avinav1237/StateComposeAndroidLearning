package com.example.statetutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

//@Composable
//fun WellnessScreen(modifier: Modifier = Modifier) {
//    Column(modifier = modifier) {
//        StatefulCounter()
//
//        val list = remember { getWellnessTasks().toMutableStateList() }
//        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
//    }
//}
//@Composable
//fun WellnessScreen(
//    modifier: Modifier = Modifier,
//    wellnessViewModel: WellnessViewModel = viewModel()
//) {
//    Column(modifier = modifier) {
//        StateFullCounter()
//
//        WellnessTasksList(
//            list = wellnessViewModel.tasks,
//            onCloseTask = { task -> wellnessViewModel.remove(task) })
//    }
//}
//fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
