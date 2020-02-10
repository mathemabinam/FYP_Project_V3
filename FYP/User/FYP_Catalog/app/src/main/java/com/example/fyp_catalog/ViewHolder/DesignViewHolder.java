package com.example.fyp_catalog.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fyp_catalog.Interface.ItemClickListener;
import com.example.fyp_catalog.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DesignViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView designName, designCategory, designDesc;
    public ImageView designImage;
    public ItemClickListener listener;
    public CardView cardView;

    public DesignViewHolder(@NonNull View itemView) {
        super(itemView);

        designImage = itemView.findViewById(R.id.design_image);
        designName = itemView.findViewById(R.id.design_name);
        designCategory = itemView.findViewById(R.id.design_category);
        designDesc = itemView.findViewById(R.id.design_description);
        cardView = itemView.findViewById(R.id.design_CardView);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(),false);
    }
}
