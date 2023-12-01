import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.proyecto.R

class AniadirAmigosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        return inflater.inflate(R.layout.fragment_aniadir_amigos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAgregarAmigo: Button = view.findViewById(R.id.btnAgregarAmigo)

        btnAgregarAmigo.setOnClickListener {
            // Aquí puedes agregar lógica para obtener la información del nuevo amigo
            // y almacenarlo en algún lugar, como una base de datos o una lista.
            // Por ejemplo, podrías abrir otro fragmento para ingresar detalles del amigo.
            abrirFragmentoIngresoAmigo()
        }
    }

    private fun abrirFragmentoIngresoAmigo() {
        // Puedes implementar aquí la lógica para abrir el fragmento donde ingresan los detalles del amigo.
        // Por ejemplo:
        val fragmentTransaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, ListaAmigosFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
