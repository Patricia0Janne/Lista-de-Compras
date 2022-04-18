package com.example.listadecompras.ui.home

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.listadecompras.R
import kotlinx.android.synthetic.main.fragment_cadastro_produtos.*

class CadastroProdutosFragment : Fragment() {

    val COD_IMAGE = 101
    var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_inserir.setOnClickListener {
            val produto = txt_produto.text.toString()
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()

            if (produto.isNotEmpty() && qtd.isNotEmpty()){
                val prod = Produto(produto, qtd.toInt(), valor.toDouble(), imageBitmap)

                produtosGlobal.add(prod)

                txt_produto.text.clear()
                txt_qtd.text.clear()
                txt_valor.text.clear()
            }else{
                txt_produto.error = if (txt_produto.text.isEmpty()) "Preencha o nome do produto" else null
                txt_qtd.error = if (txt_qtd.text.isEmpty()) "Preencha a quantidade" else null
            }
        }
        img_foto_produto.setOnClickListener{
            abrirGaleria()
        }
    }

    fun abrirGaleria(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"

        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"),COD_IMAGE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK){
            if (data != null) {
                val inputStream = contentResolver.openInputStream(data.getData());
                imageBitmap = BitmapFactory.decodeStream(inputStream)
                img_foto_produto.setImageBitmap(imageBitmap)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_produtos, container, false)
    }
}