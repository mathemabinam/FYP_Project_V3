package com.example.fyp_catalog.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fyp_catalog.DesignDescription;
import com.example.fyp_catalog.Model.Designs;
import com.example.fyp_catalog.R;
import com.example.fyp_catalog.ViewHolder.DesignViewHolder;
import com.example.fyp_catalog.model_2D.DesignHome;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class CategoryEarring extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference DesignRef;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_earring);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ear Rings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DesignRef = FirebaseDatabase.getInstance().getReference().child("designs");

        recyclerView = findViewById(R.id.recycleView_earring);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 1);
        /*layoutManager = new LinearLayoutManager(this);*/
        /*layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);*/
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Designs> options =
                new FirebaseRecyclerOptions.Builder<Designs>()
                        .setQuery(DesignRef, Designs.class).build();

        FirebaseRecyclerAdapter<Designs, DesignViewHolder> adapter =
                new FirebaseRecyclerAdapter<Designs, DesignViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull DesignViewHolder holder, int position, @NonNull final Designs model) {
                        if (model.getCategory().equalsIgnoreCase("Ear Rings")) {
                            holder.designName.setText(model.getName());
                            holder.designDesc.setText(model.getDescription());
                            holder.designCategory.setText(model.getCategory());
                            Picasso.get().load(model.getImgUrl()).into(holder.designImage);

                            holder.cardView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    Intent intent = new Intent(CategoryEarring.this, DesignDescription.class);
                                    intent.putExtra("id", model.getId());
                                    startActivity(intent);
                                }
                            });
                        } else {
                            holder.itemView.setVisibility(View.GONE);
                            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
                        }
                    }

                    @NonNull
                    @Override
                    public DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_layout, parent, false);
                        DesignViewHolder holder = new DesignViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}
