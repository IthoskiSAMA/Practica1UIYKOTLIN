package com.uteq.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtNombre =findViewById<TextView>(R.id.txtnombres);
        val txtGenero =findViewById<TextView>(R.id.txtgeneros);
        val txtNacimiento =findViewById<TextView>(R.id.txtnacimiento);
        val txtTelefono =findViewById<TextView>(R.id.txttelefonos);

        val datos = this.intent.extras;
        txtNombre.setText(datos?.getString("Nombre"));
        txtGenero.setText(datos?.getString("Genero"));
        txtNacimiento.setText(datos?.getString("Nacimiento"));
        txtTelefono.setText(datos?.getString("Telefono"));
    }

    fun regresar(view: View){
        val intent=Intent(this,MainActivity::class.java);
        startActivity(intent);
    }
}