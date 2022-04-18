package com.example.listadecompras.ui.home

import android.graphics.Bitmap

data class Produto(val nome:String, val quantidade:Int, val valor:Double? = null, val foto: Bitmap? = null)

