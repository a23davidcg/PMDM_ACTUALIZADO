package com.example.uf1_proyecto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words = listOf("Android", "Fragment", "Model")
    var secretWordDisplay = words.random().uppercase()

    //Palabra secreat que voy a mostrar
    //val secretDisplay = ""
    val secretDisplay = MutableLiveData<String>()
    //Numero de vidas
    //var lives = 5
    var lives = MutableLiveData<Int> (5)

    //Almacenar el numero de intentos del usuario. Caracteres
    var guesses = mutableListOf<Char>()

    fun generateWordDisplay() =
        secretDisplay.map {
            if (it in guesses) it
            else "_"
        }.joinToString("")

    fun game(guess: Char) {
        //añado el caracter a la lista de intentos
        guesses.add(guess.uppercaseChar())
        //actualizo la palabra a mostrar
        secretWordDisplay = generateWordDisplay()
        //Actualizo las vidas
        if (!secretDisplay.contains(guess.uppercaseChar())) lives.value
    }

    fun resultMessage () =
        if (win())"Ganaste la palabra secreta era ${secretDisplay}"
    else "oops no acertaste la palabra ${secretDisplay}"

    fun restart(){
        guesses.clear()
        lives =5
        secretWordDisplay = words.random().uppercase()
        secretWordDisplay =  generateWordDisplay()
    }
    fun win() = secretDisplay.equals(secretWordDisplay)

    fun lose() = lives <= 0
}