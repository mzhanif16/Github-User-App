package com.mzhnf.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mzhnf.core.network.model.Item
import com.mzhnf.core.utils.showToast
import com.mzhnf.users.databinding.ItemSearchBinding
import com.squareup.picasso.Picasso
import java.util.ArrayList

class SearchUserAdapter: RecyclerView.Adapter<SearchUserAdapter.ViewHolder>() {
    private var listData = ArrayList<Item>()

    fun setData(newListData: List<Item>) {
        if (newListData == null) return
        listData.clear()
        listData.addAll((newListData))
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = ItemSearchBinding.bind(view)
        private val context = view.context
        fun bind(data: Item){
            with(binding){
                tvName.text = data.login
                Picasso.get().load(data.avatarUrl).into(ivProfilePhoto)
                cvLayout.setOnClickListener {
                    showToast(context,"User ${data.login} di klik")
                }
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchUserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchUserAdapter.ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}