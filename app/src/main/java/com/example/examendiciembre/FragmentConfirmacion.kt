package com.example.examendiciembre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentConfirmacionBinding
import com.example.examendiciembre.databinding.FragmentDetallesBinding


class FragmentConfirmacion : Fragment() {
    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!
    private val args:FragmentConfirmacionArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConfirmacionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtnombre.text =String.format("${getString(R.string.nombre_confirmacion)}",args.nombre)
        binding.txtCantidadConfirmacion.text = String.format("${getString(R.string.pedido_confirmacion)}",args.cantidad,args.comida)
        binding.txthorario2.text = String.format("${getString(R.string.horario_confirmacion)}",args.horario)

        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}