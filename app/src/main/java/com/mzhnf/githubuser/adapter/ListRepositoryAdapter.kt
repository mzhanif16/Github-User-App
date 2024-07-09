package com.mzhnf.githubuser.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mzhnf.core.network.model.ListRepositoryDTOItem
import com.mzhnf.githubuser.R
import com.mzhnf.githubuser.databinding.ItemRepositoryBinding
import com.squareup.picasso.Picasso
import java.util.ArrayList

class ListRepositoryAdapter(): RecyclerView.Adapter<ListRepositoryAdapter.ViewHolder>() {
    private var listData = ArrayList<ListRepositoryDTOItem>()

    fun setData(newListData: List<ListRepositoryDTOItem>) {
        if (newListData == null) return
        listData.clear()
        listData.addAll((newListData))
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemRepositoryBinding.bind(view)
        private val context = view.context
        fun bind(data: ListRepositoryDTOItem){
            with(binding){
                tvName.text = data.owner.login
                tvStars.text = data.forks.toString()
                Picasso.get().load(data.owner.avatarUrl).into(ivProfile)
                tvTitle.text = data.name
                tvDesc.text = data.description
                tvLanguageCode.text = data.language
                if (data.language =="Dart"){
                    ivCode.setColorFilter(ContextCompat.getColor(context, R.color.teal_200), PorterDuff.Mode.SRC_IN)
                }
                if (data.language == "Kotlin"){
                    ivCode.setColorFilter(ContextCompat.getColor(context, R.color.purple_200), PorterDuff.Mode.SRC_IN)
                }
                if (data.language =="PHP"){
                    ivCode.setColorFilter(Color.parseColor("#2196F3"), PorterDuff.Mode.SRC_IN)
                }
                if (data.language == "Java") {
                    ivCode.setColorFilter(Color.parseColor("#795548"), PorterDuff.Mode.SRC_IN)
                }
                if (data.language == "C++") {
                    ivCode.setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_IN)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false)
       return ViewHolder(view)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }
}