package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.examendiciembre.databinding.FragmentMenuBinding


class FragmentMenu : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hamburguesa.setOnClickListener {
            comanda(binding.hamburguesa.id)
        }
        binding.pizza.setOnClickListener {
            comanda(binding.pizza.id)
        }
        binding.salad.setOnClickListener {
            comanda(binding.salad.id)
        }
        binding.taco.setOnClickListener {
            comanda(binding.taco.id)
        }

        }

    fun comanda(int: Int){
        val comida = when(int){
            binding.hamburguesa.id -> "Hamburguesa"
            binding.pizza.id -> "Pizza"
            binding.salad.id -> "Ensalada"
            binding.taco.id -> "Taco"
            else -> "Algo va mal"
        }
        val action = FragmentMenuDirections.actionFragmentMenuToFragmentDetalles(comida)
        findNavController().navigate(action)
    }

    }
