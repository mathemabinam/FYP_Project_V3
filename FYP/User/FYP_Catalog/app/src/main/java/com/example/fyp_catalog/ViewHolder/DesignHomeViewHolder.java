package com.example.fyp_catalog.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fyp_catalog.Interface.ItemClickListener;
import com.example.fyp_catalog.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DesignHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView designHomeName;
    public ImageView designHomeImage;
    public ItemClickListener listener;
    public CardView homeCardView;

    public DesignHomeViewHolder(@NonNull View itemView) {
        super(itemView);

        designHomeImage = itemView.findViewById(R.id.design_home_image);
        designHomeName = itemView.findViewById(R.id.design_home_name);
        homeCardView = itemView.findViewById(R.id.design_home_Cardview);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View view) {
        listener.onClick(view, getAdapterPosition(),false);
    }


}
