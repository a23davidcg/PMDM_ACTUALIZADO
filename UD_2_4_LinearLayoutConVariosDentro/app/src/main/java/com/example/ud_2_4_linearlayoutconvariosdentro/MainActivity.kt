package com.example.ud_2_4_linearlayoutconvariosdentro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonLlamada  = findViewById<Button>(R.id.ButtonLlamar) /*Se asigna a una variable local el valor de una variable a traves
        de la id del boton del xml que se ha creado con anterioridad */
        val llamando = findViewById<TextView>(R.id.textView2)
        val nombreLlamada = findViewById<TextView>(R.id.Juan)
        val texto = nombreLlamada.text.toString()
        botonLlamada.setOnClickListener(){
            //Una vez se presiona el boton se eejcuta el siguiente código
            val mensaje = "Se está llamando a  " + texto

            llamando.text = mensaje



        }


    }

}