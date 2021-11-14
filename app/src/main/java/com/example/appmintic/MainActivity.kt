package com.example.appmintic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
   var ciudad:ArrayList<ciudad>? =null

    var lista:RecyclerView?=null

    var layoutManager:RecyclerView.LayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ciudad = ArrayList()
        ciudad?.add(ciudad(nombre = "Central Park", R.drawable.times_square_new_york))

        lista=findViewById(R.id.ciudades)


    }
}