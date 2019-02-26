package com.constraint.vagabond.main.details;

import android.os.Bundle;

import com.constraint.vagabond.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SingleImageView extends AppCompatActivity {
  PhotoView photoView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.single_image_view);
    photoView = findViewById(R.id.single_image);
    String imageUrl = getIntent().getStringExtra("image_url");
    Picasso.get().load(imageUrl).into(photoView);
  }
}
