package com.firstproject.projectadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterChat(private val context: Context, private val list: List<ModelChat>) :
    RecyclerView.Adapter<AdapterChat.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name=itemView.findViewById<TextView>(R.id.tvUserName)
        var lastmessage=itemView.findViewById<TextView>(R.id.tvlastMessage)
        var time=itemView.findViewById<TextView>(R.id.tvtimeStamp)
        var image=itemView.findViewById<ImageView>(R.id.imageuser)

        fun bind(modelChat: ModelChat) {

            name.text=modelChat.name
            lastmessage.text=modelChat.lastMessage
            time.text=modelChat.time

            Glide.with(context)
                .load(modelChat.imageview)

            .placeholder(R.drawable.img)
                .centerCrop()

                .into(image)

        }
    }
}