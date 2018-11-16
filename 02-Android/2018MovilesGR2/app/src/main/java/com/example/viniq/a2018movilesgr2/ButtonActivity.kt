package com.example.viniq.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    var nombre: String = ""
    var apellido: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        capturarDatosDelIntent()

        //instaciamos el boton de activity_button.xml
        boton_enviar_correo.setOnClickListener {
            enviarIntentCorreo()

        }

    }

    //funcion para obtener los datos enviados desde
    //otra pantalla
    fun capturarDatosDelIntent() {
        this.nombre = intent.getStringExtra("nombre")
        this.apellido = intent.getStringExtra("apellido")

        //se insatancia textView desde activity_button-xmk
        textView_RevibeDatos.text = "${nombre} ${apellido}"
        //recibe los datos desde otra pantalla
    }

    //funcion enviar correo
    fun enviarIntentCorreo() {
        val correo = text_Correo.text//obtiene los datos del textview
        val subject = text_subject.text
        val texto = text_Texto.text

        val intent = Intent(Intent.ACTION_SEND)//se define el intent en este caso de correo
        intent.type = "text/html"//tipo
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correo, "vincio_520@hotmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, texto)

        startActivity(intent)//se inicializa el intent
    }
}

