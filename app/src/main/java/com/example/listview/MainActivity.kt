package com.example.listview

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val arrSO = arrayOf("Android", "iPhone", "Windows Phone", "Blackberry", "Firefox OS", "Amazon World")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Se obtiene el view 1stSo
        val lsvSistemasOperativos: ListView = findViewById<View>(R.id.LsvSO) as ListView

        //Se crea un adaptador para llenar la lista
        val adaptador: Any? =
            ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, arrSO)

        //Se asigna el adaptador a la view
        lsvSistemasOperativos.adapter = adaptador as ListAdapter?

        //Se genera el método setOnItemClickListener de. la view
        lsvSistemasOperativos.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                applicationContext,
                "Posición: $position",
            Toast.LENGTH_SHORT
            ).show()
        }

    }

}