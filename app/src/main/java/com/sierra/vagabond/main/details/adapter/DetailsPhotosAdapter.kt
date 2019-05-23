package com.sierra.vagabond.main.details.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.sierra.vagabond.R
import com.github.chrisbanes.photoview.PhotoView
import com.sierra.vagabond.main.details.SingleImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.horizontal_images_grid.view.*


class DetailsPhotosAdapter(private val imagesUrls: List<String>) : RecyclerView.Adapter<DetailsPhotosAdapter.Images>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Images {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.horizontal_images_grid, viewGroup, false)
        return Images(view)
    }

    override fun onBindViewHolder(images: Images, i: Int) {
        val randomUrl = imagesUrls[images.adapterPosition]
        Picasso.get().load(randomUrl).fit().centerCrop().into(images.image)
        images.image.setOnClickListener { v ->
            val intent = Intent(v.context, SingleImageView::class.java)
            intent.putExtra("image_url", randomUrl)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return imagesUrls.size
    }

    inner class Images(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: PhotoView = itemView.more_images
    }
}
