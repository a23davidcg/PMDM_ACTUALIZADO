import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.R

class AgregarAmigosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_aniadir_amigos)

        val btnAgregarAmigo: Button = findViewById(R.id.btnAgregarAmigo)

        btnAgregarAmigo.setOnClickListener {
            // Aquí puedes agregar lógica para obtener la información del nuevo amigo
            // y almacenarlo en algún lugar, como una base de datos o una lista.
            // Por ejemplo, podrías abrir otra actividad para ingresar detalles del amigo.
            abrirActividadIngresoAmigo()
        }
    }

    private fun abrirActividadIngresoAmigo() {
        // Puedes implementar aquí la lógica para abrir la actividad donde ingresan los detalles del amigo.
        // Por ejemplo:
        val intent = Intent(this, AgregarAmigosActivity::class.java)
        startActivity(intent)
    }
}
