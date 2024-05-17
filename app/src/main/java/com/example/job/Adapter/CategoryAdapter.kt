package com.example.job.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.job.R
import com.example.job.databinding.ViewholderCategoryBinding

class CategoryAdapter(private val items:List<String>,val clickListener: ClickListener): RecyclerView.Adapter<CategoryAdapter.Viewholder>() {

    private var  selectedPosition=-1
    private  var lastSelectedPosition=-1
    private lateinit var context:Context



     inner class Viewholder(val binding:ViewholderCategoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Viewholder {
       context=parent.context
        val binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)

    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.catTxt.text=item
        holder.binding.root.setOnClickListener{
            lastSelectedPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
            clickListener.onClick(position.toString())




        }
        if(selectedPosition==position){
            holder.binding.catTxt.setBackgroundResource(R.drawable.blue_full_corner)
            holder.binding.catTxt.setTextColor(context.resources.getColor(R.color.white))

        }
        else{
            holder.binding.catTxt.setBackgroundResource(R.drawable.white_bg_full_stroke)
            holder.binding.catTxt.setTextColor(context.resources.getColor(R.color.black))


        }
    }

    override fun getItemCount(): Int =items.size


    interface ClickListener{
        fun onClick(category:String)
    }

}