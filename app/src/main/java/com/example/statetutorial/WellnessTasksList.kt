package com.example.statetutorial

import WellnessTaskItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask,Boolean)-> Unit,
    onCloseTask: (WellnessTask)-> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label,
                checked = task.checked,
                onCheckedChange = {checked -> onCheckedTask(task,checked)},
                onClose  = {onCloseTask(task)},
            )
        }
    }
}