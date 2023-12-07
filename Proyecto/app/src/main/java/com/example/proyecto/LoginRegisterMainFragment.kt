package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginRegisterMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login_register_main, container, false)
        //val botonInicioSesion: Button = view.findViewById(R.id.iniciarSessionButton)

        //val botonRegistrar: Button = view.findViewById(R.id.registroButton)

        val accederBoton: Button = view.findViewById(R.id.AccederBoton)


        accederBoton.setOnClickListener{
            findNavController().navigate(R.id.action_loginRegisterMainFragment_to_registerFragment)
        }
//        botonInicioSesion.setOnClickListener {
//            findNavController().navigate(R.id.action_loginRegisterMainFragment_to_loginFragment)
//        }
//
//        botonRegistrar.setOnClickListener {
//            findNavController().navigate(R.id.action_loginRegisterMainFragment_to_registerFragment)
//        }
       return view

    }
}