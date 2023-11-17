package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.uf1_proyecto.databinding.FragmentGameBinding


class FragmentResult : Fragment() {

    private var _binding : FragmentGameBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        val gameModel : GameViewModel by viewModels(
            ownerProducer = { this.requireActivity()}
        )
        
        binding.buttonNext.setOnClickListener{

            Toast.makeText(activity, gameModel.secretWord, Toast.LENGTH_LONG)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}