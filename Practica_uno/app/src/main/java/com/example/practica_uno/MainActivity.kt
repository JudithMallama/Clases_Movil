package com.example.practica_uno

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practica_uno.databinding.ActivityMainBinding

private const val EMPTY = ""
private const val SPACE = " "

class MainActivity : AppCompatActivity()
{
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setContentView(R.layout.activity_main)


        mainBinding.salveButton.setOnClickListener {
            //Log.d("Click", "true")
            val name = mainBinding.nameEditText.text.toString()
            val email = mainBinding.emailEditText.text.toString()
            val pass = mainBinding.passEditText.text.toString()
            val repeatPass = mainBinding.repeatPassEditText.text.toString()
            val gender =
                if (mainBinding.femaleRadioButton.isChecked) getString(R.string.female) else getString(
                    R.string.male
                )

            var hobbies =
                if (mainBinding.musicCheckBox.isChecked) getString(R.string.music) else EMPTY
            hobbies =
                hobbies + SPACE + if (mainBinding.readCheckBox.isChecked) getString(R.string.read) else EMPTY
            hobbies =
                hobbies + SPACE + if (mainBinding.sportCheckBox.isChecked) getString(R.string.sport) else EMPTY
            hobbies =
                hobbies + SPACE + if (mainBinding.wtiteCheckBox.isChecked) getString(R.string.write) else EMPTY



            if (email.isNotEmpty() && name.isNotEmpty() && pass.isNotEmpty()) {
                if (pass == repeatPass) {
                    salveUser(name, email, pass, repeatPass, gender, hobbies)
                    mainBinding.repeatPassTextLayout.error = null
                } else {
                    mainBinding.repeatPassTextLayout.error = getString(R.string.pass_error)
                }
            } else {
                Toast.makeText(this, getString(R.string.campos_error), Toast.LENGTH_SHORT).show()
            }
            cleanViews()

        }
    }

    private fun cleanViews() {
        with(mainBinding) {
            emailEditText.setText(EMPTY)
            nameEditText.setText(EMPTY)
            passEditText.setText(EMPTY)
            repeatPassEditText.setText(EMPTY)
        }
    }

    private fun salveUser(
        name: String,
        email: String,
        pass: String,
        repeatPass: String,
        gender: String,
        hobbies: String
    ) {
        val newUser = User(name, email, pass, repeatPass, gender, hobbies)
        mainBinding.infoTextView.text =
            newUser.name + "\n" + newUser.email + "\n" + newUser.geder + "\n" + hobbies
    }

}