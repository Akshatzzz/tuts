package com.kcdeepak.faceapp

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val usersFace: List<UserFace>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.face_user_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageViewSmall.setImageBitmap(usersFace[position].bitmap)
        holder.imageViewLarge.setImageBitmap(usersFace[position].bitmap)
        holder.textViewName.text = usersFace[position].name
        holder.textViewPhone.text = usersFace[position].phone
        holder.textViewAddress.text = usersFace[position].address
    }

    override fun getItemCount(): Int {
        return usersFace.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSmall: ImageView = itemView.findViewById(R.id.imageViewSmall)
        val imageViewLarge: ImageView = itemView.findViewById(R.id.imageViewLarge)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
        val textViewAddress: TextView = itemView.findViewById(R.id.textViewAddress)
    }
}