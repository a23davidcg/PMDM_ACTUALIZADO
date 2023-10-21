package com.example.secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //O que devolve debe de almacenarse nunha variable
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val botonStart = view.findViewById<Button>(R.id.button_start)
        botonStart.setOnClickListener {
            view.findNavController().navigate(R.id.action_welcomeFragment_to_messageFragment2)

        }
        return view

    }

}