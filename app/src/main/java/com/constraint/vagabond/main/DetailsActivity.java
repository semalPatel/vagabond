package com.constraint.vagabond.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.constraint.vagabond.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity implements DetailsContract {

  CollapsingToolbarLayout collapsingToolbarLayout;
  Toolbar toolbar;
  FloatingActionButton favButton;
  String imageUrl;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent getImage = getIntent();
    imageUrl = getImage.getStringExtra("image_url");
    initializeView();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  public void initializeView() {
    setContentView(R.layout.activity_detail);
    toolbar = findViewById(R.id.toolbar_title);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    collapsingToolbarLayout = findViewById(R.id.collapsing_layout);
    collapsingToolbarLayout.setTitle("Yosemite");
    loadImage();
    favButton = findViewById(R.id.fav_button);
    favButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Snackbar.make(v, "Added to watchlist", Snackbar.LENGTH_LONG);
          }
        });
  }

  public void loadImage() {
    final ImageView expandingImage = findViewById(R.id.collapsing_image);
    Picasso.get().load(imageUrl).fit().centerCrop().into(expandingImage);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflator = getMenuInflater();
    inflator.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public void destroyView() {}

  @Override
  public void initializeData() {}

  @Override
  public void setDataToRecyclerView() {}
}
