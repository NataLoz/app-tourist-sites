package com.example.appmintic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        botonVuelta.setOnClickListener{

            val intento: Intent = Intent(this, MainActivity::class.java)

            startActivity(intento)

            finish()

        }
    }
}