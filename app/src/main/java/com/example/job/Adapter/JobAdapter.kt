package com.example.job.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.job.Activity_Detail_Job
import com.example.job.Model.JobModel
import com.example.job.databinding.ActivityDetailJobBinding
import com.example.job.databinding.ViewholderJobBinding

class JobAdapter(private val items: List<JobModel>) :
    RecyclerView.Adapter<JobAdapter.Viewholder>() {

    private lateinit var context: Context

    inner class Viewholder(val binding: ViewholderJobBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.Viewholder {
        context = parent.context
        val binding =
            ViewholderJobBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: JobAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleTxt.text = item.title
        holder.binding.companyTxt.text = item.company
        holder.binding.locationTxt.text = item.location
        holder.binding.timeTxt.text = item.time
        holder.binding.modelTxt.text = item.model
        holder.binding.levelTxt.text = item.level
        holder.binding.salaryTxt.text = item.salary

        val drawableResourceId = holder.itemView.resources
            .getIdentifier(item.picUrl, "drawable", holder.itemView.context.packageName)

        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, Activity_Detail_Job::class.java)
            intent.putExtra("object",item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}