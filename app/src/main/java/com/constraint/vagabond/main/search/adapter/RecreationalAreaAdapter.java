package com.constraint.vagabond.main.search.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.constraint.vagabond.R;
import com.constraint.vagabond.data.entities.RecreationalAreaList;

public class RecreationalAreaAdapter extends RecyclerView.Adapter<AreaHolder> {

  private AreaAdapterPresenter areaAdapterPresenter;

  public RecreationalAreaAdapter(RecreationalAreaList recreationalAreaList) {
    this.areaAdapterPresenter = new AreaAdapterPresenter(recreationalAreaList);
  }

  @NonNull
  @Override
  public AreaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new AreaHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull AreaHolder holder, int position) {
    areaAdapterPresenter.onBindDataToAdapter(holder, position);
  }

  @Override
  public int getItemCount() {
    return areaAdapterPresenter.getAreaCount();
  }
}
