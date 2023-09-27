package com.example.demoapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.Network.Models.GallaryResposeItem
import com.example.demoapp.databinding.GallaryListBinding

class GallaryAdapter(
    private val data: communication,
    private val listData: ArrayList<GallaryResposeItem>
) :
    RecyclerView.Adapter<GallaryAdapter.Holder>() {


    inner class Holder(val binding: GallaryListBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.itemGalleryImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = GallaryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listData[position]
        Glide.with(holder.itemView).load(item.url).into(holder.image)
        holder.itemView.setOnClickListener {
            data.passImage(item.url)
        }
    }

    interface communication {
        fun passImage(image: String)
    }
}