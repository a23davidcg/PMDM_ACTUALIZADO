package com.example.ud04_1_chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val navHostController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostController//Una vex que este inflado el fragmento busca por el id lo que hay dentro dle navegdor
        val navHostFragment = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setupWithNavController(navHostFragment.navController)

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_toolbar, menu)

        return super.onCreateOptionsMenu(menu) //Sobreescribir el metodo para que nos aparezca el interrogante de ayuda arriba de t.odo a la derecha
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Recuperar el controlador de navegacion, es decir el grapho de navegacion
        val navController = findNavController(R.id.nav_graph) //Se usa para recuperar el navegadro del controlador.
        return NavigationUI.onNavDestinationSelected(item, navController)//NavigationUI es para navegar por la interfaz del usuario

    }
}