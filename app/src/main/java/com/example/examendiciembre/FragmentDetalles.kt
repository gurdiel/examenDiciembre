package com.example.examendiciembre

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembre.databinding.FragmentDetallesBinding
import com.example.examendiciembre.databinding.FragmentMenuBinding


class FragmentDetalles : Fragment() {
    private var _binding: FragmentDetallesBinding? = null
    private val binding get() = _binding!!
    private val args:FragmentDetallesArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetallesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtargumento.text = String.format("${getString(R.string.detalles_titulo)}",args.comida)

        binding.btnConfirmar.setOnClickListener {
            comprobar()

        }
        binding.btnVolver.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun comprobar() {

        if(binding.itxtCantidad.text.toString().toIntOrNull() == null || binding.itxtCantidad.text.toString().toIntOrNull() == 0) {
                Toast.makeText(activity, R.string.error_cantidad_vacia, Toast.LENGTH_SHORT).show()
            return
        }
        val cantidad = binding.itxtCantidad.text.toString().toInt()

        val horario = when(binding.grupoBotones.checkedRadioButtonId){

            binding.PrimerBoton.id -> getString(R.string.para_comer_horario)
            binding.SegundoBoton.id -> getString(R.string.para_cenar_horario)
            else -> "Sin horario"
        }


        if(binding.itxtNombre.text.toString() == null || binding.itxtNombre.text.toString() == "") {
            Toast.makeText(activity, R.string.error_nombre_vacio, Toast.LENGTH_SHORT).show()
            return
        }
        val nombre = binding.itxtNombre.text.toString()

        val action = FragmentDetallesDirections.actionFragmentDetallesToFragmentConfirmacion(args.comida,
            cantidad,horario,nombre)

        findNavController().navigate(action)

    }


}