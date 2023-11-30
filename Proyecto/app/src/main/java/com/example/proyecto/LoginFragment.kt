package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val botonLogin =
            view.findViewById<Button>(R.id.login_button) //Tambien se podria hacer el aceso al boton  con val botonLogin: Button.....
        val botonRegistrarDesdeLogin: Button = view.findViewById(R.id.singup_button)

        botonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_menuInicio)
        }
        botonRegistrarDesdeLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginRegisterMainFragment_to_registerFragment)
        }
        return view
    }
}