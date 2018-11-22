package com.example.ronald.deber

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonPantallaPrincipal.setOnClickListener {

            this.irOtraPantalla()
        }


    }
    fun irOtraPantalla() {

        val intentOtraPantalla = Intent(this, Calendario::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentOtraPantalla)
    }

}
