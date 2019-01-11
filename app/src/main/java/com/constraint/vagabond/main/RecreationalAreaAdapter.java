package com.constraint.vagabond.main;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.constraint.vagabond.R;
import com.constraint.vagabond.data.RecAreaMedia;
import com.constraint.vagabond.data.RecreationalArea;
import com.constraint.vagabond.data.RecreationalAreaList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecreationalAreaAdapter
    extends RecyclerView.Adapter<RecreationalAreaAdapter.AreaHolder> {

  public RecreationalAreaList recreationalAreaArrayList;
  public RecyclerViewclickListener recyclerViewclickListener;

  public RecreationalAreaAdapter(
      RecreationalAreaList recreationalAreas, RecyclerViewclickListener recyclerViewclickListener) {
    this.recreationalAreaArrayList = recreationalAreas;
    this.recyclerViewclickListener = recyclerViewclickListener;
  }

  @NonNull
  @Override
  public AreaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    View view = layoutInflater.inflate(R.layout.list_view, viewGroup, false);
    return new AreaHolder(view);
  }

  @Override
  public void onBindViewHolder(final AreaHolder areaHolder, final int i) {
    RecreationalArea recreationalArea = recreationalAreaArrayList.recreationalAreaList.get(i);
    areaHolder.areaName.setText(recreationalArea.recAreaName);
    Log.d(getClass().getSimpleName(), recreationalAreaArrayList.toString());
    final String imageURL = setBackGroundImage(recreationalArea, areaHolder.backgroundImage);
    if (imageURL == null) {
      Resources res = areaHolder.areaName.getContext().getResources();
      areaHolder.areaName.setTextColor(res.getColor(android.R.color.black));
    }
    areaHolder.moreInfoBtn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
            intent.putExtra("image_url", imageURL);
            v.getContext().startActivity(intent);
          }
        });
  }

  @Override
  public int getItemCount() {
    return recreationalAreaArrayList.recreationalAreaList.size();
  }

  public String setBackGroundImage(RecreationalArea recreationalArea, ImageView imageView) {
    List<RecAreaMedia> imageList = recreationalArea.recAreaMediaList;
    String imageURL;
    if (imageList.isEmpty()) {
      imageURL = null;
    } else {
      imageURL = imageList.get(0).imageURL;
    }
    Picasso.get()
        .load(imageURL)
        .placeholder(R.drawable.baseline_report_problem_24)
        .fit()
        .centerCrop()
        .into(imageView);
    return imageURL;
  }

  class AreaHolder extends RecyclerView.ViewHolder {

    final TextView areaName;
    final Button moreInfoBtn;
    final ImageView backgroundImage;

    AreaHolder(View view) {
      super(view);
      areaName = view.findViewById(R.id.area_name);
      moreInfoBtn = view.findViewById(R.id.more_info);
      backgroundImage = view.findViewById(R.id.card_background);
      setupClickListener();
    }

    private void setupClickListener() {
      itemView.setOnClickListener(
          new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int position = getLayoutPosition();
              recyclerViewclickListener.onItemClick(
                  recreationalAreaArrayList.recreationalAreaList.get(position));
            }
          });
    }
  }
}
