import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class ListaAmigosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_lista_amigos)

        val listaAmigos = obtenerListaAmigos()

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAmigos)
        listView.adapter = adapter
    }

    private fun obtenerListaAmigos(): List<String> {
        // Implementa la lógica para obtener la lista de amigos desde tu base de datos o fuente de datos
        // Por ahora, devolveré una lista de ejemplo.
        return listOf("Amigo1", "Amigo2", "Amigo3")
    }
}
