package com.example.fyp_catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.fyp_catalog.Model.Designs;
import com.example.fyp_catalog.ViewHolder.DesignViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    private DatabaseReference DesignRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DesignRef = FirebaseDatabase.getInstance().getReference().child("designs");


        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
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
                        holder.designName.setText(model.getName());
                        holder.designDesc.setText(model.getDescription());
                        holder.designCategory.setText(model.getCategory());
                        Picasso.get().load(model.getImgUrl()).into(holder.designImage);
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
