package com.example.practica_dos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.practica_dos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setContentView(mainBinding.root)

        val spinner1 = findViewById<Spinner>(R.id.divisa_spinner)
        val lista = resources.getStringArray(R.array.opciones)
        val adaptador= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        spinner1.adapter=adaptador

        mainBinding.calculoButton.setOnClickListener {
            val valor = mainBinding.valorEditText.text.toString()
            var val2 = valor.toFloat()

            val lis = spinner1.selectedItem.toString()
            val pos = spinner1.selectedItemPosition.toInt()

            mainBinding.infoTextView.text= pos.toString()


            if(pos == 0)
            {
                val2=val2/3650
                mainBinding.infoTextView.text=val2.toString()+ " Dolares"
            }
            if (pos==1)
            {
                val2=val2/4338
                mainBinding.infoTextView.text=val2.toString() +" Euros"
            }
            if (pos==2)
            {
                val2=val2/33
                mainBinding.infoTextView.text=val2.toString() +" Yenes"
            }
            if (pos==3)
            {
                val2=val2/5019
                mainBinding.infoTextView.text=val2.toString() +" Libras esterlinas"
            }
            if(pos==4)
            {
                val2=val2/3932
                mainBinding.infoTextView.text=val2.toString() +" Francos suizos"
            }

       }





    }


}


