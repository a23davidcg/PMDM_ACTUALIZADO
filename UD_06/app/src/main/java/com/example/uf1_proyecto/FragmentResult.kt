package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentResultBinding


class FragmentResult : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root
        val gameModel: GameViewModel by viewModels(
            ownerProducer = { this.requireActivity() }
        )

        binding.resultbutton.setOnClickListener {
            gameModel.restart()
            view.findNavController().navigate(R.id.action_fragmentResult_to_gameFragment)
            Toast.makeText(activity, gameModel.secretDisplay, Toast.LENGTH_LONG)
        }
        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}