package com.rafaelm.thenewyorktimes.view.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafaelm.thenewyorktimes.R
import com.rafaelm.thenewyorktimes.data.entity.MovieEntity
import com.rafaelm.thenewyorktimes.data.model.Result
import com.rafaelm.thenewyorktimes.data.repository.MovieRepository
import kotlinx.android.synthetic.main.recyclerview_movie.view.*

class RecyclerviewAdapterMovie(
    private val item: List<Result>,
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

        holder.itemView.txt_movie_title.text = itemList.displayTitle
        holder.itemView.txt_movie_release_date.text = itemList.dateUpdated
        holder.itemView.txt_movie_headline.text = itemList.headline
        holder.itemView.txt_movie_summary_short.text = itemList.summaryShort

        val repository = MovieRepository(applicationContext as Application)


        val movieRepository = MovieEntity(
            movieId = 0,
            movie_title = itemList.displayTitle,
            MovieSummaryShort = itemList.summaryShort,
            MovieHeadline = itemList.headline, movieImage = null
        )

        repository.insertMovie(movieRepository)

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