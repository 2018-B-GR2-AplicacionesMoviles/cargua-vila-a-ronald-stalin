package com.example.ronald.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_navegar.setOnClickListener {
            this.irAPantallaDeBotones()
        }
        }
    fun irAPantallaDeBotones(){
        val intentIrABotones = Intent(this,Button::class.java)
        this.startActivity(intentIrABotones)
    }
}