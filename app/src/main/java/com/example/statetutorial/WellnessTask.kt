package com.example.statetutorial

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*

class WellnessTask(val id: Int, val label: String, private val initialChecked: Boolean = false) {
  var checked by mutableStateOf(initialChecked)
 }
