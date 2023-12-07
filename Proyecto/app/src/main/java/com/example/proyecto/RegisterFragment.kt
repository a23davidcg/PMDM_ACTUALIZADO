import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterFragment : Fragment() {

    private lateinit var editTextCorreo: EditText
    private lateinit var editTextContraseña: EditText
    private lateinit var botonRegistrar: Button
    private lateinit var botonInicioSesion: Button

    // Obtén la instancia de FirebaseAuth
    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        editTextCorreo = view.findViewById(R.id.editTextCorreo)
        editTextContraseña = view.findViewById(R.id.editTextContraseña)
        botonRegistrar = view.findViewById(R.id.botonRegistrar)
        botonInicioSesion = view.findViewById(R.id.botonLogin)

        botonRegistrar.setOnClickListener {
            registrarUsuario()
        }
        botonInicioSesion.setOnClickListener {
            iniciarSesion()
        }

        return view
    }

    private fun registrarUsuario() {
        val email = editTextCorreo.text.toString()
        val password = editTextContraseña.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Ingrese un correo y una contraseña válidos.",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Registro de usuario
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Registro exitoso, puedes realizar acciones adicionales si es necesario
                        val user: FirebaseUser? = auth.currentUser
                    } else {
                        Log.e("Registro Error", "Error durante el registro", task.exception)
                        Toast.makeText(
                            requireContext(),
                            "Error durante el registro. Asegúrese de ingresar un correo y una contraseña válidos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    private fun iniciarSesion() {
        val email = editTextCorreo.text.toString().trim()
        val password = editTextContraseña.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Introduzca un mail y una contraseña válidos",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Iniciar sesión de usuario
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Inicio de sesión correcto, asocio fragmento para navegar
                        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
                        findNavController().navigate(R.id.action_registerFragment_to_menuInicio)
                    } else {
                        Log.e("Login Error", "Error durante el inicio de sesión", task.exception)
                        Toast.makeText(
                            requireContext(),
                            "El correo y/o la contraseña son incorrectos. Intente nuevamente.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}
