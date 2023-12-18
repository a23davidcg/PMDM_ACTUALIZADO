package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar

class MenuInicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_menu_inicio, container, false)
        val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
        val navView: NavigationView = view.findViewById(R.id.navigation_view)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)


        // Para el drawerLayout
        val navController = findNavController()

        val builderApp = AppBarConfiguration.Builder(navController.graph)
        builderApp.setOpenableLayout(drawerLayout)
        val appBarConfiguration = builderApp.build()

        // toolbar
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // NavigationView
        navView.setupWithNavController(navController)

        // listener para navigation view
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Actividades -> {
                    navController.navigate(R.id.action_menuInicio_to_activitiesFragment)
                    true
                }
                R.id.Encontrar -> {
                     navController.navigate(R.id.action_menuInicio_to_mapaFragment)
                    true
                }
                R.id.AmigosRecientes -> {
                    navController.navigate(R.id.action_menuInicio_to_listaAmigosFragment)
                    true
                }
                R.id.AniadirAmigos -> {
                    navController.navigate(R.id.action_menuInicio_to_aniadirAmigosFragment)
                    true
                }
                else -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
            }
        }

        // Navigation item selection listener for BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Ajustes -> {
                    // Configurar la accion para ajustes
                    true
                }
                R.id.info -> {
                    // Configurar la accion para info
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener{
            menuItem ->
            when (menuItem.itemId) {
                R.id.nuevoLugar -> {
                    //Configurar lo que se desee hacer a la hora de presionar el icono que hacemos referencia
                    navController.navigate(R.id.action_menuInicio_to_mapaFragment)
                    true

                }
                R.id.amigosBottomBar-> {
                    //Confugrar lo que se vaya a queerer hacer con el icono de la parte inferiore del fragment
                    navController.navigate(R.id.action_menuInicio_to_listaAmigosFragment)
                    true
                }
                R.id.encontrarNuevo -> {

                    //Configurar lo que se queira hacer al presionar el icono de la parte inferior de fragment

                    true
                }

                else -> {
                    false
                }
            }
        }



        return view
    }

}



