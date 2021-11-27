package com.jmarti.proyectosemtres.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jmarti.proyectosemtres.R
import com.jmarti.proyectosemtres.model.PointinterestItem
import com.squareup.picasso.Picasso

class PointInterestsAdapter(
    private val pointinterestsList: ArrayList<PointinterestItem>,
    private val onItemClicked: (PointinterestItem) -> Unit
) : RecyclerView.Adapter<PointInterestsAdapter.PointinterestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointinterestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_point_item, parent, false)
        return PointinterestViewHolder(view)
    }

    override fun onBindViewHolder(holder: PointinterestViewHolder, position: Int) {
        val pointinterest = pointinterestsList[position]
        holder.itemView.setOnClickListener { onItemClicked(pointinterestsList[position]) }
        holder.bind(pointinterest)
    }

    override fun getItemCount(): Int = pointinterestsList.size

    class PointinterestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var aliasTextView: TextView = itemView.findViewById(R.id.alias_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(pointinterest: PointinterestItem){
            nameTextView.text = pointinterest.name
            aliasTextView.text = pointinterest.alias
            Picasso.get().load(pointinterest.urlPicture).into(pictureImageView)
        }
    }
}