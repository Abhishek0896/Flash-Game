package com.example.flashgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout mixgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        addgame = findViewById(R.id.addgame);
        mixgame = findViewById(R.id.mixgame);

//        addgame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Add.class);
//                startActivity(intent);
//
//            }
//        });
//
        mixgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mixin.class);
                MainActivity.this.finish();
                startActivity(intent);
            }
        });
    }
}