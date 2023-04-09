package com.momid.bay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BayListAdapter(val chatItems : ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return BayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as BayViewHolder).textView?.text = chatItems[position]
    }

    public class BayViewHolder(view: View) : ViewHolder(view) {
        public var textView : TextView? = null
        init {
            textView = view.findViewById(R.id.chat_item)
        }
    }


    public fun addItem(item: String) {
        chatItems.add(item)
        notifyItemInserted(chatItems.size - 1)
    }
}
