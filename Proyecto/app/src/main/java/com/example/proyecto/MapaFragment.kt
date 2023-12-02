import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

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
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapaFragment) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            // Configure the GoogleMap
            googleMap = map
            configurarMapa()
            // You can perform additional map configurations here
        }
    }

    private fun configurarMapa() {
        // Configuración adicional del mapa
        // Ejemplo: Mover la cámara a una ubicación específica y agregar un marcador

        // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud de un lugar)
        val ubicacion = LatLng(37.7749, -122.4194) // Latitud y longitud de San Francisco, CA
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 12f)) // Zoom de 12

        // Agregar un marcador en la ubicación
        googleMap.addMarker(MarkerOptions().position(ubicacion).title("San Francisco"))
    }
}
