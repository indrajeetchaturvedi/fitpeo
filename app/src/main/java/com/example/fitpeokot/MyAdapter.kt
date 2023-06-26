package com.example.fitpeokot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.internal.http.StatusLine.get

class MyAdapter(private val data: List<Model>,
                 val context: Context ,
                private val cellClickListener: CellClickListener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data_model: Model) {
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            val description = view.findViewById<TextView>(R.id.tvDescription)

            title.text = data_model.title
            description.text = data_model.url
            Picasso.with(view.context)
                .load(data_model.thumbnailUrl).into(imageView);



        }
    }

    interface CellClickListener {
        fun onCellClickListener(data: Model)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        val demo = data[position]
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(demo)
          //  Toast.makeText(context,data[position].albumId,Toast.LENGTH_LONG)
        }


        }
    }
