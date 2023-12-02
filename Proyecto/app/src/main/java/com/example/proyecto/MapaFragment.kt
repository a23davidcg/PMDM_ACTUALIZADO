//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//import com.example.proyecto.R
//
// class MapaFragment : Fragment(), OnMapReadyCallback {
//
//    private lateinit var googleMap: GoogleMap
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflar el diseño del fragmento
//        return inflater.inflate(R.layout.fragment_mapa, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val mapFragment = childFragmentManager.findFragmentById(R.id.map)
//
//        if (mapFragment is SupportMapFragment){
//            mapFragment.getMapAsync(this)
//        }else{
//            Log.e("MapaFragment", "El fragmento no es de tipo SupportMapFragment)
//        }
//
//        // Obtener una referencia al mapa desde el fragmento
////        val mapFragment =
////            childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
////        mapFragment?.getMapAsync(this)
//    }
//
//    override fun onMapReady(map: GoogleMap?) {
//        map?.let {
//            googleMap = it
//
//            try {
//                // Configurar el mapa según sea necesario
//                val location = LatLng(0.0, 0.0) // Coordenadas de ejemplo
//                googleMap.addMarker(MarkerOptions().position(location).title("Marcador de ejemplo"))
//                googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.example.proyecto.R

class MapaFragment : Fragment() {

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the fragment of the map
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapaFragment) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            // Configure the GoogleMap
            googleMap = map
            // You can perform additional map configurations here
        }
    }
}
//
//
////import android.os.Bundle
////import androidx.fragment.app.Fragment
////import android.view.LayoutInflater
////import android.view.View
////import android.view.ViewGroup
////import com.google.android.gms.maps.GoogleMap
////import com.google.android.gms.maps.SupportMapFragment
////import com.example.proyecto.R
////
////class MapaFragment : Fragment() {
////
////
////
////    private lateinit var googleMap: GoogleMap
////
////
////
////    override fun onCreateView(
////        inflater: LayoutInflater, container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View? {
////        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_mapa, container, false)
////    }
/////*
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////
////        // Inicializar el fragmento del mapa
////        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
////        mapFragment.getMapAsync { map ->
////            // Configurar el GoogleMap
////            googleMap = map
////            // Puedes realizar configuraciones adicionales del mapa aquí
////        }
////    }*/
////}
