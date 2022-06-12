package com.uteq.practica1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showDialogAlertSimple() {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage("Valores no ingresados.")
            .setNegativeButton(android.R.string.cancel,
                DialogInterface.OnClickListener { dialog, which -> "Y SI"})
            .show()
    }
    fun enviar_actividad(view: View){
        val intent=Intent(this,MainActivity2::class.java);
        val nombre = findViewById<EditText>(R.id.txtnombre);
        val generom = findViewById<RadioButton>(R.id.rbmasculino);
        val generof = findViewById<RadioButton>(R.id.rbfemenino);
        val nacimiento = findViewById<EditText>(R.id.ednacimiento);
        val telefono = findViewById<EditText>(R.id.txttelefono);
        var int =0;

        val datos=Bundle();
        if(nombre.toString()==""){int=1;}else{datos.putString("Nombre",nombre.text.toString());}
        if(generom.isChecked){datos.putString("Genero",generom.text.toString())}else{
            if(generof.isChecked){datos.putString("Genero",generof.text.toString())}else{int=1;}}
        if(nacimiento.toString()==""){int=1;}else{datos.putString("Nacimiento",nacimiento.text.toString())};
        if(telefono.toString()==""){int=1;}else{datos.putString("Telefono",telefono.text.toString())};

        if(int==1){showDialogAlertSimple()}else{intent.putExtras(datos); startActivity(intent);}
    }
}