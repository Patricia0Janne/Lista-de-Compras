package com.example.listadecompras.ui.home

import android.content.Context

class ListComprasDataBase(context: Context) : ManagedSQLiteOpenHelper(ctx = context, name = "listaCompras.dp", version = 1) {
}