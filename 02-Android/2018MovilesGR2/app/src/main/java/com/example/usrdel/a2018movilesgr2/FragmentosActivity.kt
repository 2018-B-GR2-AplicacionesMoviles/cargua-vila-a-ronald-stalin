package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    lateinit var fragmentoActual: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)

        fragmentoActual = PrimerFragment()


        button_crear_primer_fragmento
                .setOnClickListener {
                    crearFragmentoUno()
                }

        /*
        boton_tab1.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoUno())
        }
        boton_tab2.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoDos())
        }
        boton_tab3.setOnClickListener { view ->
            reemplazarFragmentoActual(FragmentoTres())
        }
        boton_destruir_fragmento.setOnClickListener { view ->
            destruirFragmentoActual()
        }
        */
    }

    fun crearFragmentoUno() {
        // Manager
        val fragmentManager = supportFragmentManager

        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Crear instancia de fragmento
        val primerFragmento = PrimerFragment()

        val argumentos = Bundle()

        argumentos.putString("nombre", "Adrian Eguez")
        argumentos.putInt("edad", 29)

        primerFragmento.arguments = argumentos

        // Anadir fragmento

        fragmentTransaction.remove(fragmentoActual)
        // fragmentTransaction.replace(R.id.fragment_primer, primerFragmento)

        fragmentoActual = primerFragmento


        // Commit
        fragmentTransaction.commit()
    }

    /*
    fun destruirFragmentoActual() {
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()
    }


    fun reemplazarFragmentoActual(fragmento: android.support.v4.app.Fragment) {
        fragmentoActual = fragmento
        // Manager
        val fragmentManager = supportFragmentManager
        // Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rl_fragmento, fragmento)
        fragmentTransaction.commit()
    }
    */
}
