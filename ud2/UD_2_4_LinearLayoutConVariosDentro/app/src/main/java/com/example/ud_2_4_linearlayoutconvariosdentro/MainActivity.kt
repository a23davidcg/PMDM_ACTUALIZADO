package com.example.ud_2_4_linearlayoutconvariosdentro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val llamar  =  findViewById<Button>(R.id.button)
        val llamada  =  findViewById<TextView>(R.id.textView3)
        val juan =  findViewById<TextView>(R.id.text1)


        llamar.setOnClickListener {
            llamada.text = "Llamando a " //+ juan
        }


    }
}