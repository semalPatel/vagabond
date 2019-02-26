package com.constraint.vagabond.main.search.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.constraint.vagabond.R;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

public class AreaHolder extends RecyclerView.ViewHolder implements AreaHolderView {

  private final TextView areaName;
  private final Button moreInfoBtn;
  private final ImageView backgroundImage;

  AreaHolder(final View view) {
    super(view);
    areaName = view.findViewById(R.id.area_name);
    moreInfoBtn = view.findViewById(R.id.more_info);
    backgroundImage = view.findViewById(R.id.card_background);
  }

  @Override
  public void setAreaTitle(String areaTitle) {
    areaName.setText(areaTitle);
  }

  @Override
  public void setAreaImage(String imageUrl) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.drawable.baseline_report_problem_24)
        .fit()
        .centerCrop()
        .into(backgroundImage);
  }

  @Override
  public void setMoreInfoButton() {}
}
