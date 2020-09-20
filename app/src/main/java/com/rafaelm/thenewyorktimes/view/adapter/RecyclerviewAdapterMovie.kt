package com.rafaelm.thenewyorktimes.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity
import kotlinx.android.synthetic.main.recyclerview_movie.view.*

class RecyclerviewAdapterMovie(
    private val item: List<MovieEntity>,
    private val applicationContext: Context,
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

        holder.itemView.txt_movie_title.text = itemList.movieTitle.toString()
        holder.itemView.txt_movie_release_date.text = itemList.movieDateUpdate.toString()
        holder.itemView.txt_movie_headline.text = itemList.movieHeadline.toString()
        holder.itemView.txt_movie_summary_short.text = itemList.movieSummaryShort.toString()

        val itemImg = itemList.movieImage.toString()
        if (itemImg != null) {
            val imgReplace = itemImg.replace("\\", "")
            val img = holder.itemView.img_movie
            Glide.with(applicationContext)
                .load(imgReplace)
                .into(img)
        }


    }

    override fun getItemCount(): Int {
        return item.size
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

}