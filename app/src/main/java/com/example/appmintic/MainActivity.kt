package com.example.appmintic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmintic.databinding.ActivityMainBinding
import com.example.appmintic.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_ciudad.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding



    var ciudad= listOf<ciudad>(
    ciudad(nombre = "Central Park", R.drawable.times_square_new_york,descripcion = "Con 340 hectáreas, unos 4 kilómetros de largo y 800 metros de ancho, este es uno de los mayores parques del planeta", puntuacion = "Puntuación: 7"),
    ciudad(nombre = "Empire State", R.drawable.empire_state_new_york,descripcion = "Durante cuarenta años, desde su finalización en 1931 hasta 1972, año en que se completó la construcción de la torre norte del World Trade Center, este fue además con 381 metros el edificio más alto del mundo.", puntuacion = "Puntuación: 8"),
    ciudad(nombre = "World Trade Center", R.drawable.world_trade_center,descripcion = "Justo al lado del Memorial 11S, se levanta imponente el esbelto y nuevo One World Trade Center que con sus 541 metros es el rascacielos más alto del hemisferio occidental y el sexto más alto del mundo", puntuacion = "Puntuación: 7"),
    ciudad(nombre = "Estatua de la Libertad", R.drawable.statue_of_liberty,descripcion = "Una bellísima y enorme dama francesa, de 46 metros de altura (93 si contamos su base) que Francia regaló a Estados Unidos en la conmemoración de los 100 años de la declaración de independencia.", puntuacion = "Puntuación: 8.5"),
    ciudad(nombre = "Wall Street", R.drawable.wall_street,descripcion = "es una calle de ocho cuadras de largo en el distrito financiero del Lower Manhattan en Nueva York.", puntuacion = "Puntuación: 9")
   )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()

        botonIda.setOnClickListener{

            val intento: Intent = Intent(this, MainActivity2::class.java)

            startActivity(intento)

        }

    }

    fun initRecycler(){

        binding.ciudades.layoutManager = LinearLayoutManager (this)
        val adapter = adaptador(ciudad)
        binding.ciudades.adapter=adapter

    }
}