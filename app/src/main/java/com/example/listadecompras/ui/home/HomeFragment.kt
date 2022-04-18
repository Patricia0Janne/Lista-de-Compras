package com.example.listadecompras.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.listadecompras.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.NumberFormat
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
       // homeViewModel.text.observe(viewLifecycleOwner) {
       //     textView.text = it
        //}
       // return root

        val produtosAdapter = ProdutoAdapter(this)
        list_view_produtos.adapter = produtosAdapter

        btn_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroProdutosFragment::class.java)
            startActivity(intent)
        }

        list_view_produtos.setOnItemLongClickListener{ adapterView: AdapterView<*>,
                                                       view: View, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true

        }
    }

    override fun onResume() {
        super.onResume()

        val adapter = list_view_produtos.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)

        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }
        val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))
        txt_total.text = " TOTAL: ${ f.format(soma)}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}