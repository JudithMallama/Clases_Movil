package com.example.praticatres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.praticatres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setContentView(mainBinding.root)

        val spinner1 = findViewById<Spinner>(R.id.primera_spinner)
        val lista1 = resources.getStringArray(R.array.opc1)
        val adaptador1= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista1)
        spinner1.adapter=adaptador1

        val spinner2 = findViewById<Spinner>(R.id.segundo_spinner)
        val lista2 = resources.getStringArray(R.array.opc2)
        val adaptador2= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista2)
        spinner2.adapter=adaptador2

        val spinner3 = findViewById<Spinner>(R.id.mul_spinner)
        val lista3 = resources.getStringArray(R.array.opc3)
        val adaptador3= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista3)
        spinner3.adapter=adaptador3

        val spinner4 = findViewById<Spinner>(R.id.tol_spinner)
        val lista4 = resources.getStringArray(R.array.tol)
        val adaptador4= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista4)
        spinner4.adapter=adaptador4

        mainBinding.calculoButton.setOnClickListener {

            val lis1 = spinner1.selectedItem.toString()
            val lis2 = spinner2.selectedItem.toString()
            val lis3 = spinner3.selectedItem.toString()
            val lis4 = spinner4.selectedItem.toString()
            mainBinding.infoTextView.text=lis1+" "+lis2+" "+lis3+" "+lis4

            val pos1 = spinner1.selectedItemPosition.toInt()
            val pos2 = spinner2.selectedItemPosition.toInt()
            val pos3 = spinner3.selectedItemPosition.toInt()
            val pos4 = spinner4.selectedItemPosition.toInt()

        for(i in 0..pos1)
        {
            val dato=pos1*10
            mainBinding.infoTextView.text=dato.toString() +"valor"
            for(i in 0..pos2)
            {
                val dato2=dato+pos2
                mainBinding.infoTextView.text=dato2.toString() +"valor"
                for(i in 0..pos3)
                {
                    val dopos=pos3.toDouble()
                    val dato3=Math.pow(10.0,dopos)
                    val fin=dato2*dato3
                    mainBinding.infoTextView.text=fin.toString()+"   "+dato3.toString() +"valor"+dopos.toString()
                }
            }
        }

        }
    }

}