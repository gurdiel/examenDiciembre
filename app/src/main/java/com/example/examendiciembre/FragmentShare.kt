package com.example.examendiciembre

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examendiciembre.databinding.FragmentConfirmacionBinding
import com.example.examendiciembre.databinding.FragmentShareBinding

class FragmentShare : Fragment() {
    private var _binding: FragmentShareBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShareBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgX.setOnClickListener {
            activity?.finish()
        }
        binding.txtClose.setOnClickListener {
            activity?.finish()
        }
        binding.imgShare.setOnClickListener {
            compartiendo()

        }
        binding.txtShare.setOnClickListener {

            compartiendo()
        }

    }
    fun compartiendo(){

        // Create the text message with a string.
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, R.string.compartir_text)
            type = "text/plain"
        }

// Try to invoke the intent.
        try {
            startActivity(sendIntent)
        } catch (e: ActivityNotFoundException) {
            // Define what your app should do if no activity can handle the intent.
        }

    }

}