package com.constraint.vagabond.main;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.constraint.vagabond.R;
import com.constraint.vagabond.data.RecreationalArea;

import java.util.ArrayList;
import java.util.List;

public class RecreationalAreaAdapter
    extends RecyclerView.Adapter<RecreationalAreaAdapter.AreaHolder> {

  private List<RecreationalArea> recreationalAreaArrayList;
  private RecyclerViewclickListener recyclerViewclickListener;

  public RecreationalAreaAdapter(
      List<RecreationalArea> recreationalAreas,
      RecyclerViewclickListener recyclerViewclickListener) {

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
  public void onBindViewHolder(
      @NonNull AreaHolder areaHolder, @SuppressLint("RecyclerView") final int i) {

    areaHolder.areaName.setText(recreationalAreaArrayList.get(i).getRecAreaName());
    areaHolder.areaDescription.setText(recreationalAreaArrayList.get(i).getRecAreaDescription());
    areaHolder.areaPhone.setText(recreationalAreaArrayList.get(i).getRecAreaPhone());
    areaHolder.areaEmail.setText(recreationalAreaArrayList.get(i).getRecAreaEmail());

    areaHolder.itemView.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            recyclerViewclickListener.onItemClick(recreationalAreaArrayList.get(i));
          }
        });
  }

  @Override
  public int getItemCount() {
    return recreationalAreaArrayList.size();
  }

  class AreaHolder extends RecyclerView.ViewHolder {

    TextView areaName;
    TextView areaDescription;
    TextView areaEmail;
    TextView areaPhone;

    AreaHolder(View view) {
      super(view);
      areaName = view.findViewById(R.id.area_name);
      areaDescription = view.findViewById(R.id.area_description);
      areaEmail = view.findViewById(R.id.area_email);
      areaPhone = view.findViewById(R.id.area_phone);
    }
  }
}
