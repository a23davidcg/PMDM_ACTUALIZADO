package com.example.secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class EncryptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val message = EncryptFragmentArgs.fromBundle(requireArguments()).mensaje
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        view.findViewById<TextView>(R.id.encrypt_value).text
        return view
    }

    //Para cifrarlo recoger el numero y le sumamos 3, no se puede usar los if, para la resolucion del problema
    //Si es una letra lo cifra, si es un caracter especial, nos lo devolverá tal cual.


    fun cifrado(message: String) = message.map {
        if (it.isLetter()) {
            it.uppercaseChar().code.minus('A'.code).plus(3).mod(26).plus('A'.code).toChar()

        } else {
            it
        }
    } .joinToString ("")
  }



