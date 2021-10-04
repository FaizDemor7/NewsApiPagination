package com.example.newslistactivity

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView




class ListFooterViewHolder (view: View) : RecyclerView.ViewHolder(view) {


    fun bind(status: State?) {
       // itemView.progress_bar.visibility = if (status == State.LOADING) VISIBLE else View.INVISIBLE
        //itemView.txt_error.visibility = if (status == State.ERROR) VISIBLE else View.INVISIBLE
    }

    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_footer, parent, false)

          //  view.txt_error.setOnClickListener { retry() }
            //return ListFooterViewHolder(view)
        }


    }
}