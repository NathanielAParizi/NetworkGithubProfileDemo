package com.example.networkgithubprofiledemo.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networkgithubprofiledemo.Model.User.Item
import com.example.networkgithubprofiledemo.R
import kotlinx.android.synthetic.main.item_list_row.view.*

class UserAdapter(val resultList: List<Item>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_row,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = resultList.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) =
        holder.populateItem(resultList[position])


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun populateItem(result: Item) {

            itemView.txt1.text = "${result.login} ${result.login}"
            itemView.txt2.text = "${result.repos_url}"
            itemView.txt3.text = "${result.id}"
            Glide.with(itemView).load(result.avatar_url).into(itemView.imgView)

        }
    }
}
