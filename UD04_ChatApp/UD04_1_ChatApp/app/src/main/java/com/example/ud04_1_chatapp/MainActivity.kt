package com.example.ud04_1_chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.graphics.toColor
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        //Acceder al host de navegacion, y o casteamos como un fragmento de navegacion de host
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment//Una vex que este inflado el fragmento busca por el id lo que hay dentro dle navegdor
        //Accedemos al controlador de navegacion
        val navController = navHostFragment.navController
        //Desde el controlador de navegacion podemos acceder al grapho
        toolbar.setupWithNavController(navHostFragment.navController)


        setSupportActionBar(toolbar)

        //Para que coja la configuración necesaria para la barra de navegación

        var builderApp = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builderApp.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)

        //Recuperar barra inferior
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
                //Pasamoslleo controlador de navegacion para poderlle pasar o grapho para que sepa como pintar
        bottomBar.setupWithNavController(navController)


        //FIXME: PANEL LATERAL- Referencia drawer layout

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        builderApp.setOpenableLayout(drawerLayout)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setupWithNavController(navController)


        






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