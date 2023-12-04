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
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapaFragment : Fragment() {

    private lateinit var googleMap: GoogleMap

    //PAra pillar la ubicacion desde un click
    private var marcadorActual: Marker? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_mapa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // inicializar el fragmento del mapa
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapaFragment) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            // Configure the GoogleMap
            googleMap = map
            configurarMapa()
            //Configurar mapa para añadir por click

            agregarListenerClicMapa()

        }
    }

    private fun configurarMapa() {
        // Configuración adicional del mapa
        // Ejemplo: Mover la cámara a una ubicación específica y agregar un marcador

        // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud de un lugar)
        val ubicacion = LatLng(37.7749, -122.4194) // Latitud y longitud de San Francisco, CA
        val ubicacionSantiago =
            LatLng(42.8805200, -8.5456900) //Ubicacion para santiago de compostela
//        val ubicacionActual = LatLng()
        googleMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                ubicacionSantiago,
                12f
            )
        ) // Zoom de 12

        // Agregar un marcador en la ubicación
        googleMap.addMarker(MarkerOptions().position(ubicacionSantiago).title("Santiago"))
    }

    private fun agregarListenerClicMapa() {
        googleMap.setOnMapClickListener { latLng ->
            // Eliminar el marcador anterior si existe

            marcadorActual?.remove()

            // Agregar un nuevo marcador en la ubicación del clic
            marcadorActual = googleMap.addMarker(
                MarkerOptions().position(latLng).title("Ubicación personalizada")

            )

            // Puedes guardar la ubicación en una variable, base de datos, etc.
            val latitud = latLng.latitude
            val longitud = latLng.longitude



            // Aquí puedes realizar acciones adicionales con la ubicación obtenida
        }
    }

}
