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


        // For the drawer layout
        val navController = findNavController()

        val builderApp = AppBarConfiguration.Builder(navController.graph)
        builderApp.setOpenableLayout(drawerLayout)
        val appBarConfiguration = builderApp.build()

        // Setup the toolbar with NavController and AppBarConfiguration
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Setup the NavigationView with NavController
        navView.setupWithNavController(navController)

        // Navigation item selection listener for NavigationView
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
                    // Perform the action for Ajustes
                    true
                }
                R.id.info -> {
                    // Perform the action for info
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




//package com.example.proyecto
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.google.android.material.navigation.NavigationView
//
//
//class MenuInicioFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        val view = inflater.inflate(R.layout.fragment_menu_inicio, container, false)
//        val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
//        val navView: NavigationView = view.findViewById(R.id.navigation_view)
//        val toolbar: NavigationView = view.findViewById(R.id.toolbar)
//        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)
//
//
//
//        //PAra el menu lateral emergente deslizando desde la izquierda debemos de:
//
//        //Debemos de inflar el menu lateral
//         // Inflar el menú lateral
//        val navController = findNavController()
//
//        var builderApp = AppBarConfiguration.Builder(navController.graph)
//        builderApp.setOpenableLayout(drawerLayout)
//      //  navView.setupWithNavController(navController)
//
//
//
//
//        //FIXME: PANEL LATERAL- Referencia drawer layout
//
//        val appBarConfiguration = builderApp.build()
//        setupActionBarWithNavController(navController = navController, appBarConfiguration)
//
//
//        navView.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.Actividades -> {
//                    findNavController().navigate(R.id.action_menuInicio_to_activitiesFragment)
//                    // Acción para la opción 1
//                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
//                    return@setNavigationItemSelectedListener true
//                }
//
//                R.id.Encontrar -> {
//                    findNavController().navigate(R.id.action_menuInicio_to_mapaFragment)
//
//                    // Acción para la opción 2
//                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
//                    // replaceFragment(Fragment2())
//                    return@setNavigationItemSelectedListener true
//                }
//
//                R.id.AmigosRecientes -> {
//                    findNavController().navigate(R.id.action_menuInicio_to_listaAmigosActivity)
//                    // Acción para la opción 2
//                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
//                    // replaceFragment(Fragment2())
//                    return@setNavigationItemSelectedListener true
//
//                }
//                R.id.AniadirAmigos -> {
//                    findNavController().navigate(R.id.action_menuInicio_to_agregarAmigosActivity)
//                    return@setNavigationItemSelectedListener true
//                }
//
//                else -> {
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                    true
//                }
//            }
//        }
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.Ajustes -> {
//                    // Acción para la opción 1 del BottomNavigationView
//                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
//                    // replaceFragment(Fragment1())
//                    true
//                }
//
//                R.id.info -> {
//                    // Acción para la opción 2 del BottomNavigationView
//                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
//                    //replaceFragment(Fragment2())
//                    true
//                }
//
//                else -> false
//            }
//        }
//
//        return view
//    }
//}
//
