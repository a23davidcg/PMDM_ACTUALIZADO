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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MenuInicio : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_menu_inicio, container, false)
        val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
        val navView: NavigationView = view.findViewById(R.id.navigation_view)
        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottom_navigation)


        //PAra el menu lateral emergente deslizando desde la izquierda debemos de:

        //Debemos de inflar el menu lateral
         // Inflar el menú lateral
        val navController = findNavController()

        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .setDrawerLayout(drawerLayout)
            .build()

        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)




        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Actividades -> {
                    findNavController().navigate(R.id.action_menuInicio_to_activitiesFragment)
                    // Acción para la opción 1
                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
                    return@setNavigationItemSelectedListener true
                }

                R.id.Encontrar -> {

                    // Acción para la opción 2
                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
                    // replaceFragment(Fragment2())
                    return@setNavigationItemSelectedListener true
                }

                R.id.AmigosRecientes -> {
                    // Acción para la opción 2
                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
                    // replaceFragment(Fragment2())
                    return@setNavigationItemSelectedListener true

                }

                else -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
            }
        }


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Ajustes -> {
                    // Acción para la opción 1 del BottomNavigationView
                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
                    // replaceFragment(Fragment1())
                    true
                }

                R.id.info -> {
                    // Acción para la opción 2 del BottomNavigationView
                    // Puedes cargar un nuevo layout, iniciar una actividad, o realizar la acción que desees
                    //replaceFragment(Fragment2())
                    true
                }

                else -> false
            }
        }

        return view
    }
}

