package com.sierra.vagabond.main.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sierra.vagabond.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_image_view.*


class SingleImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_image_view)
        val imageUrl = intent.getStringExtra("image_url")
        Picasso.get().load(imageUrl).into(single_image)
    }
}
