package com.example.ronald.deber

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calendario.*
import kotlinx.android.synthetic.main.activity_main.*

class Calendario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        buton_calendario.setOnClickListener {

            this.irOtraPantalla()
        }


    }

    fun irOtraPantalla() {

        val intentOtraPantalla = Intent(this, pantalla2Activity::class.java) //ButtonActivity nombre de la otra actividad
        this.startActivity(intentOtraPantalla)
    }
}