package com.example.remonterv7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val orderList : ArrayList<Task>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = orderList[position]
        //holder.check.text = currentitem.done

        holder.testCheck.text = currentitem.done
        holder.orderid.text = currentitem.order
        holder.ordername.text = currentitem.name
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val testCheck : TextView = itemView.findViewById(R.id.testCheck)
        //val check : CheckBox = itemView.findViewById(R.id.tacheck)
        val ordername : TextView = itemView.findViewById(R.id.taname)
        val orderid : TextView = itemView.findViewById(R.id.taorder)

    }
}