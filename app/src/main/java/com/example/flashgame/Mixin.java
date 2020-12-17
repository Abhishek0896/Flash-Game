package com.example.flashgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Mixin extends AppCompatActivity {
    Button mixhome, mixstart;
    TextView mixtimer;
    ArrayList<String> data = new ArrayList<>();
    TimerAdapter adapter;
    RecyclerView recyclerView;
    int sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixin);
        mixhome = findViewById(R.id.mixhome);
//        scroll_mixing = findViewById(R.id.scroll_mixing);
        mixtimer = findViewById(R.id.mixtimer);
        mixstart = findViewById(R.id.mixstart);
        recyclerView = findViewById(R.id.recyleview);
        mixstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                sum=0;
                getRandom();
//                settimer();

            }
        });

        mixhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Mixin.this, MainActivity.class);
                Mixin.this.finish();
                startActivity(intent);
            }
        });

    }

    public void getRandom() {
        data.clear();
        int i = 0;
        int val=0;
        while (i < 3) {
            int rand = -10 + new Random().nextInt(20);
            rand = rand == 0 ? rand + new Random().nextInt(9) : rand;
            sum = sum+ rand;
            int s= sum;

            data.add(i,""+rand);
            i++;
        }
        data.add(3,"??");
        adapter = new TimerAdapter(data, Mixin.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Mixin.this));
        recyclerView.setAdapter(adapter);
        settimer(sum);

//        adapter = new TimerAdapter(data, Mixin.this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(Mixin.this));
//        recyclerView.setAdapter(adapter);
    }

    public void settimer(int sum) {
            new CountDownTimer(6000, 1000) {
                int i =5;
                public void onTick(long millisUntilFinished) {
                    if (i >= 0) {
                        mixtimer.setText("" + i);
                        i--;
                    }
                }
                public void onFinish() {
                    data.set(0,"??");
                    data.set(1,"??");
                    data.set(2,"??");
                    data.set(3,""+sum);
                     adapter.notifyDataSetChanged();
                }
            }.start();
        }

}

