package com.example.flashgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Lev extends AppCompatActivity {
    LinearLayout lev1, lev2, lev3, lev4, lev5;
    String type;
    String digit;
    Intent intent, getin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lev);
        lev1 = findViewById(R.id.lev1);
        lev2 = findViewById(R.id.lev2);
        lev3 = findViewById(R.id.lev3);
        lev4 = findViewById(R.id.lev4);
        lev5 = findViewById(R.id.lev5);
        getin = getIntent();
        type = getin.getStringExtra("activity");
        digit = getin.getStringExtra("digit");

        intent = new Intent(Lev.this, Add.class);

        if (digit.equals("single")) {
            intent.putExtra("digit", "single");
        } else {
            intent.putExtra("digit", "double");
        }

        lev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tile", 2);
                intent.putExtra("activity", type);
                startActivity(intent);
                Lev.this.finish();
            }
        });
        lev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tile", 3);
                intent.putExtra("activity", type);
                startActivity(intent);
                Lev.this.finish();
            }
        });
        lev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tile", 5);
                intent.putExtra("activity", type);
                startActivity(intent);
                Lev.this.finish();
            }
        });
        lev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tile", 8);
                intent.putExtra("activity", type);
                startActivity(intent);
                Lev.this.finish();
            }
        });
        lev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("tile", 10);
                intent.putExtra("activity", type);
                startActivity(intent);
            }
        });

    }
}