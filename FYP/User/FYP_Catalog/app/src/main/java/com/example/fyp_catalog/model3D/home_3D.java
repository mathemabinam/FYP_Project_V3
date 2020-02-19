package com.example.fyp_catalog.model3D;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fyp_catalog.MainActivity;
import com.example.fyp_catalog.R;
import com.example.fyp_catalog.model_2D.DesignHome;

public class home_3D extends AppCompatActivity {
    private CardView card1, card2, card3, card4, card5, card6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_3_d);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("3D Designs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card1);
        card3 = findViewById(R.id.card1);
        card4 = findViewById(R.id.card1);
        card5 = findViewById(R.id.card1);
        card6 = findViewById(R.id.card1);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_3D.this, first_model.class);
                startActivity(intent);
            }
        });
    }
}
