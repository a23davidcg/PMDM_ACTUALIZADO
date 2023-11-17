package com.example.uf1_proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    val gameModel: GameViewModel by viewModels(ownerProducer = { this.requireActivity() })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.buttonNext.setOnClickListener {
            val userInput = binding.txtGuess.text.toString()
            if (userInput.isNotEmpty()) {
                gameModel.game(userInput[0])
                updateScreen()
                if (gameModel.win() || gameModel.lose())
                    view.findNavController().navigate(R.id.action_gameFragment_to_fragmentResult)
            } else {
                Toast.makeText(context, "Introduce una letra", Toast.LENGTH_SHORT).show()
            }
        }
        gameModel.secretWordDisplay.observe(
            viewLifecycleOwner, Observer {
                it -> binding.txtWord = it

            }
        )
        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun updateScreen() {
        binding.txtWord.text = gameModel.secretDisplay
        binding.txtLives.text = "te quedan ${gameModel.lives} vidas"
    }
}
