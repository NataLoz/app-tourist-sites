
package com.example.appmintic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.example.appmintic.databinding.ItemCiudadBinding
import com.example.appmintic.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class adaptador(val laciudad:List<ciudad>): RecyclerView.Adapter<adaptador.ViewHolder>(){





    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val item=items?.get(position)
        holder.nombre?.text=item?.nombre
        holder.foto?.setImageResource(item?.foto!!)
    */

        holder.render(laciudad[position])


    }


    override fun getItemCount(): Int {
       return laciudad.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador.ViewHolder {
        val vista = LayoutInflater.from(parent?.context)

        return ViewHolder(vista.inflate(R.layout.item_ciudad, parent , false  ))

    }




    class ViewHolder(val laVista:View):RecyclerView.ViewHolder(laVista) {

        val itemB   = ItemCiudadBinding.bind(laVista)




        fun render(ciudad: ciudad){

            itemB.elnombre.text = ciudad.nombre
            itemB.descrip.text= ciudad.descripcion
            itemB.puntuacion.text=ciudad.puntuacion
            Picasso.get().load(ciudad.foto).into(itemB.imagen)

        }


    }

/*
    class ViewHolder (vista: View):RecyclerView.ViewHolder(vista){
        var Vista = vista
        var foto : ImageView?=null
        var nombre : TextView?=null
        var descripcion : TextView?=null

        init {

//            foto=Vista

  //          descripcion = Vista.descripcion

        }
    }

 */

}


