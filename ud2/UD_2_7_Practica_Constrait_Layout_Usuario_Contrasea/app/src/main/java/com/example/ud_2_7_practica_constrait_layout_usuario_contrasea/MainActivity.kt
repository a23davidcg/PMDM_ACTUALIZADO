package com.example.ud_2_7_practica_constrait_layout_usuario_contrasea

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.Barrier
import android.support.constraint.ConstraintLayout
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario = findViewById<EditText>(R.id.usuario) //TODO: Localizmaos la id de lo que queremos obtenre el texto en este caso
        val contraseña = findViewById<EditText>(R.id.contraseña)
        val button = findViewById<Button>(R.id.iniciarSesion) //TODO: Localizamos la id del boton del que añadiremos un evento
        val sesionIniciada = findViewById<TextView>(R.id.sesionIniciada)

        //Añadimos las acciones al boton que seran mostrar el usuaario y la contraseña que se ingresaran

        button.setOnClickListener {
            val usuario = usuario.text.toString() //pasamos el texto del usuario a String
            val contraseña =
                contraseña.text.toString() // pasamos el texto de la contraseña a String
            if (usuario.isEmpty() || contraseña.isEmpty() || contraseña.length < 6) { //comprobamos si el usuario y la contraseña estan vacias
                sesionIniciada.setText("Ingrese usuario y contraseña válidos! \n Recuerda mínimo la contraseña debe de ser de 6 char") //mostramos un mensaje de error
                sesionIniciada.setTextSize(1, 30f)//damos el tamaño a la sesionIniciada

            } else {
                sesionIniciada.setText(" Usuario: $usuario \n Contraseña: $contraseña")//Mostramos el usuario y la contraseña que se han introducido
                sesionIniciada.setTextSize(50f) //damos el tamaño a la sesionIniciada
            }
        }




    }
}