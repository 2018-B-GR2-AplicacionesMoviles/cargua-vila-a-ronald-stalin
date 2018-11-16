package com.example.viniq.a2018movilesgr2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        button_devolver_respultado
                .setOnClickListener {
                    this.devolverRespuesta()
                }
    }
    fun devolverRespuesta(){
        val nombre = texto_nombre.text
        val apellido = texto_apellifo.text
        val intentRespuesta = Intent()
        intentRespuesta.putExtra("nombre",nombre)
        intentRespuesta.putExtra("apellido",apellido)
        val a = IntentRespuestaActivity()
        this.setResult(RESULT_OK,intentRespuesta)
        this.finish()

    }
}
