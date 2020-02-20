package com.example.fyp_catalog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fyp_catalog.Model.Designs;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DesignDescription extends AppCompatActivity {
    private ImageView desc_image;
    private TextView desc_code, desc_name, desc_description, desc_cate, desc_metal;
    private String designID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_description);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        designID = getIntent().getStringExtra("id");

        desc_code = findViewById(R.id.desc_code);
        desc_image = findViewById(R.id.desc_image);
        desc_name = findViewById(R.id.desc_name);
        desc_cate = findViewById(R.id.desc_cate);
        desc_metal = findViewById(R.id.desc_metal);
        desc_description = findViewById(R.id.desc_description);

        getDesignDesc(designID);
    }

    private void getDesignDesc(String designID) {
       DatabaseReference designRef = FirebaseDatabase.getInstance().getReference().child("designs");

       designRef.child(designID).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if (dataSnapshot.exists()){
                   Designs designs = dataSnapshot.getValue(Designs.class);

                   desc_code.setText(designs.getCode());
                   desc_name.setText(designs.getName());
                   desc_cate.setText(designs.getCategory());
                   desc_description.setText(designs.getDescription());
                   desc_metal.setText(designs.getMetal());
                   Picasso.get().load(designs.getImgUrl()).into(desc_image);
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }
}
