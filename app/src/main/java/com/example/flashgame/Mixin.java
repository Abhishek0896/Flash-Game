package com.example.flashgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Mixin extends AppCompatActivity {
    Button mixhome, mixstart;
    TextView mixtimer;
    ArrayList<String> data = new ArrayList<>();
    TimerAdapter adapter;
    RecyclerView recyclerView;
    CountDownTimer timer;
    int sum=0,j, round =0, i=3;

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
                round =0;
                data.clear();
                sum=0;
                getRandom();
                settimer();

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
        int val=0;
            int rand = -10 + new Random().nextInt(20);
            rand = rand == 0 ? rand + new Random().nextInt(9) : rand;

            if(round <= 2) {
                data.add(round, "" + rand);
                sum = sum+ rand;
            }

//            if(round == 3){
//                data.add(round,""+sum);
//            }
        adapter = new TimerAdapter(data, Mixin.this, 3);
        recyclerView.setLayoutManager(new LinearLayoutManager(Mixin.this));
        recyclerView.setAdapter(adapter);



//
//        settimer(sum);

//        adapter = new TimerAdapter(data, Mixin.this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(Mixin.this));
//        recyclerView.setAdapter(adapter);
    }

    public void settimer() {

        int interval =4000;

        timer = new CountDownTimer(interval, 1000) {


            public void onTick(long millisUntilFinished) {
                if (i >= 0) {
                    mixtimer.setText("" + i);
                    i--;
                }
            }

            public void onFinish() {
            if(round == 3){
                timer.cancel();
                setData();
            }
            else {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
                        setData();
                        i=3;
//                    }
//                });
                timer.start();
            }
//            adapter.notifyDataSetChanged();

//

//
//
//
//
//
            }
        }.start();

        }


        public void setData(){
            if (round == 0) {
                Toast.makeText(Mixin.this,"set value", Toast.LENGTH_LONG);
                data.set(0, "??");
            }
            if (round == 1) {
                Toast.makeText(Mixin.this,"set value", Toast.LENGTH_LONG);
                data.set(1, "??");
            }
            if (round == 2) {
                Toast.makeText(Mixin.this,"set value", Toast.LENGTH_LONG);
                data.set(2, "??");
            }
            if (round == 3) {
                Toast.makeText(Mixin.this,"set value", Toast.LENGTH_LONG);
                data.add(3, "" + sum);
            }
            round++;
            adapter = new TimerAdapter(data, Mixin.this,3);
            recyclerView.setLayoutManager(new LinearLayoutManager(Mixin.this));
            recyclerView.setAdapter(adapter);
            getRandom();
        }

}

