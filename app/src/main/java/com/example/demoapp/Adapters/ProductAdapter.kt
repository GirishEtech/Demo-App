package com.example.demoapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapp.Network.Models.Product
import com.example.demoapp.databinding.ProductListBinding

class ProductAdapter(private val listData: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.Holder>() {

    inner class Holder(val binding: ProductListBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemImage = binding.itemProductImage
        val itemTitle = binding.itemTitle
        val itemSubtitle = binding.itemSubtitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ProductListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listData[position]
        holder.itemTitle.text = item.title
        Glide.with(holder.itemView).load(item.thumbnail).into(holder.itemImage)
        holder.itemSubtitle.text = item.description
    }
}