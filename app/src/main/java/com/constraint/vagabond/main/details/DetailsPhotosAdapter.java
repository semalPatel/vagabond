package com.constraint.vagabond.main.details;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.constraint.vagabond.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsPhotosAdapter extends RecyclerView.Adapter<DetailsPhotosAdapter.Images> {

  private List<String> imagesUrls;

  public DetailsPhotosAdapter(List<String> imageUrls) {
    this.imagesUrls = imageUrls;
  }

  @NonNull
  @Override
  public Images onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    View view = layoutInflater.inflate(R.layout.horizontal_images_grid, viewGroup, false);
    return new Images(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Images images, final int i) {
    final String randomUrl = imagesUrls.get(images.getAdapterPosition());
    Picasso.get().load(randomUrl).fit().centerCrop().into(images.image);
    images.image.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), SingleImageView.class);
            intent.putExtra("image_url", randomUrl);
            v.getContext().startActivity(intent);
          }
        });
  }

  @Override
  public int getItemCount() {
    return imagesUrls.size();
  }

  class Images extends RecyclerView.ViewHolder {

    final PhotoView image;

    Images(@NonNull View itemView) {
      super(itemView);
      image = itemView.findViewById(R.id.more_images);
    }
  }
}
