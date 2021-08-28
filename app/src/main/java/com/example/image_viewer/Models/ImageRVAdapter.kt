package com.example.image_viewer.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.image_viewer.R

class ImageRVAdapter (var imageList:List<Image>,var context: Context) :RecyclerView.Adapter<ImagesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
      var itemView=LayoutInflater.from(parent.context).inflate(R.layout.image_list,parent,false)
        return ImagesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        var currentImage=imageList.get(position)
        holder.user.text=currentImage.user
        holder.id.text=currentImage.imageId
       holder.caption.text=currentImage.caption
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}
class ImagesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var user=itemView.findViewById<TextView>(R.id.tvName)
    var id=itemView.findViewById<TextView>(R.id.tvImageId)
    var caption=itemView.findViewById<TextView>(R.id.tvCaption)


}
