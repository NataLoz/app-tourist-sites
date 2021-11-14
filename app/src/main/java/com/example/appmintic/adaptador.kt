package com.example.appmintic

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.example.appmintic.adaptador.ViewHolder as ViewHolder1



class adaptador(items: ArrayList<ciudad>): RecyclerView.Adapter<adaptador.ViewHolder>(){

    var items:ArrayList<ciudad>?=null

    var viewHolder:ViewHolder?=null

    init {
        this.items=items
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items?.get(position)
        holder.nombre?.text=item?.nombre
        holder.foto?.setImageResource(item?.foto!!)
    }

    override fun getItemCount(): Int {
       return this.items?.count()!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent , false  )
        viewHolder= ViewHolder(vista)

        return viewHolder!!
    }





    class ViewHolder (vista: View):RecyclerView.ViewHolder(vista){
        var Vista = vista
        var foto : ImageView?=null
        var nombre : TextView?=null
        var descripcion : TextView?=null

        init {
/*
            foto=Vista.
            descripcion = laVista.descripcion
      */
        }
    }

}