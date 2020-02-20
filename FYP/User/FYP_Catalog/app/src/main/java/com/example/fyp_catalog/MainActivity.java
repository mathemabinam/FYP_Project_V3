package com.example.fyp_catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fyp_catalog.Categories.CategoryBracelet;
import com.example.fyp_catalog.Categories.CategoryEarring;
import com.example.fyp_catalog.Categories.CategoryLocket;
import com.example.fyp_catalog.Categories.CategoryNecklace;
import com.example.fyp_catalog.Categories.CategoryRing;
import com.example.fyp_catalog.Model.Designs;
import com.example.fyp_catalog.ViewHolder.DesignHomeViewHolder;
import com.example.fyp_catalog.ViewHolder.DesignViewHolder;
import com.example.fyp_catalog.model3D.home_3D;
import com.example.fyp_catalog.model_2D.DesignHome;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer_User;
    private ImageView img, banner_img;
    private CircleImageView ring, bracelet, necklace, earring, locket;
    private Button view_btn;
    private DatabaseReference DesignRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DesignRef = FirebaseDatabase.getInstance().getReference().child("designs");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer_User = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_User, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_User.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        /*layoutManager = new LinearLayoutManager(this);*/
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        img = findViewById(R.id.img);
        banner_img = findViewById(R.id.banner_img);
        ring = findViewById(R.id.Ring);
        bracelet = findViewById(R.id.Bracelet);
        necklace = findViewById(R.id.Necklace);
        earring = findViewById(R.id.Earring);
        locket = findViewById(R.id.Locket);
        view_btn = findViewById(R.id.view_btn);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DesignHome.class);
                startActivity(intent);
            }
        });

        banner_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, home_3D.class);
                startActivity(intent);
            }
        });

        ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryRing.class);
                startActivity(intent);
            }
        });

        bracelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryBracelet.class);
                startActivity(intent);
            }
        });

        earring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryEarring.class);
                startActivity(intent);
            }
        });

        necklace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryNecklace.class);
                startActivity(intent);
            }
        });

        locket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryLocket.class);
                startActivity(intent);
            }
        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DesignHome.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer_User.isDrawerOpen(GravityCompat.START)) {
            drawer_User.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Designs> options =
                new FirebaseRecyclerOptions.Builder<Designs>().setQuery(DesignRef, Designs.class)
                        .build();

        FirebaseRecyclerAdapter<Designs, DesignHomeViewHolder> adapter =
                new FirebaseRecyclerAdapter<Designs, DesignHomeViewHolder>(options) {


                    @Override
                    protected void onBindViewHolder(@NonNull DesignHomeViewHolder holder, int position, @NonNull final Designs model) {
                        holder.designHomeName.setText(model.getName());
                        Picasso.get().load(model.getImgUrl()).into(holder.designHomeImage);


                        holder.homeCardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(MainActivity.this, DesignHome.class);
                                intent.putExtra("id", model.getId());
                                startActivity(intent);
                            }


                        });

                    }

                    @NonNull
                    @Override
                    public DesignHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_home_layout, parent, false);
                        DesignHomeViewHolder holder = new DesignHomeViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
