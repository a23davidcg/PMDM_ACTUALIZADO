import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.proyecto.R

class ListaAmigosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_amigos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaAmigos = obtenerListaAmigos()

        val listView: ListView = view.findViewById(R.id.listView)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listaAmigos)
        listView.adapter = adapter
    }

    private fun obtenerListaAmigos(): List<String> {

        return listOf("Amigo1", "Amigo2", "Amigo3")
    }
}
