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

            abrirFragmentoIngresoAmigo()
        }
    }

    private fun abrirFragmentoIngresoAmigo() {

        val fragmentTransaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, ListaAmigosFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
