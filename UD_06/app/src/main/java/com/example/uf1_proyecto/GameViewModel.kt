package com.example.uf1_proyecto

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words =  listOf("Android", "Fragment", "Model")
    var secretWord = words.random().uppercase()

}