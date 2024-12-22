package com.example.mobaplicationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter for RecyclerView
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private final List<FoodItem> foodList;
    private final Context context;

    public FoodAdapter(List<FoodItem> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    // ViewHolder class to manage individual item views
    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodTitle;
        TextView foodDescription;
        ImageButton likeButton;
        ImageButton shareButton;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.item_image);
            foodTitle = itemView.findViewById(R.id.item_title);
            foodDescription = itemView.findViewById(R.id.item_description);
            likeButton = itemView.findViewById(R.id.like_button);
            shareButton = itemView.findViewById(R.id.share_button);
        }
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recycle, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItem foodItem = foodList.get(position);

        holder.foodImage.setImageResource(foodItem.getImageResId());
        holder.foodTitle.setText(foodItem.getTitle());
        holder.foodDescription.setText(foodItem.getDescription());

        // Set click listener for food image
        holder.foodImage.setOnClickListener(v ->
                Toast.makeText(context, "You pressed " + foodItem.getTitle() + " image", Toast.LENGTH_SHORT).show()
        );

        // Set click listener for like button
        holder.likeButton.setOnClickListener(v ->
                Toast.makeText(context, "You liked " + foodItem.getTitle(), Toast.LENGTH_SHORT).show()
        );

        // Set click listener for share button
        holder.shareButton.setOnClickListener(v ->
                Toast.makeText(context, "You want to share " + foodItem.getTitle(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}