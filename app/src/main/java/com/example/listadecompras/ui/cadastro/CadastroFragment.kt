package com.example.listadecompras.ui.cadastro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.listadecompras.R
import com.example.listadecompras.TelaInicial
import com.example.listadecompras.databinding.FragmentCadastroBinding
import com.example.listadecompras.databinding.FragmentLoginBinding

class CadastroFragment: Fragment() {


    private var _binding: FragmentCadastroBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root

        prosseguirButton.setOnClickListener {
            IrParaTelaInicial()
        }
    }
    private fun IrParaTelaInicial() {
        val TelaInicial = Intent(this, TelaInicial::class.java)
        startActivity(TelaInicial)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}