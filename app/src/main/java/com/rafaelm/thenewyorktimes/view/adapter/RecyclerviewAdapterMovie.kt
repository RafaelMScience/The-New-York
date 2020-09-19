package com.rafaelm.thenewyorktimes.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.model.Result
import kotlinx.android.synthetic.main.recyclerview_movie.view.*

const val POST_IMG = "https://static01.nyt.com/images/"

class RecyclerviewAdapterMovie(
    private val item: List<Result>,
    val applicationContext: Context
) : RecyclerView.Adapter<RecyclerviewAdapterMovie.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = item[position]

        holder.itemView.txt_movie_title.text = itemList.displayTitle
        holder.itemView.txt_movie_release_date.text = itemList.publicationDate


        itemList.multimedia.let {
            if (it != null) {
                val imgLet = it.src
                val imgReplace = imgLet.replace("\\", "")
                val img = holder.itemView.img_movie
                Glide.with(applicationContext)
                    .load(imgReplace)
                    .into(img)
            }
        }


    }

    override fun getItemCount(): Int {
        return item.size
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

}