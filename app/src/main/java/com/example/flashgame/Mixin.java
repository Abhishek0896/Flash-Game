package com.example.flashgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
    TextView quesm,ansm;
    CountDownTimer timer;
    int sum=1,j, round =1,tile, i=3;
    String digit;
    int rand;
    CardView cardm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixin);
        mixhome = findViewById(R.id.mixhome);
        mixtimer = findViewById(R.id.mixtimer);
        mixstart = findViewById(R.id.mixstart);
        quesm = findViewById(R.id.quesm);
        ansm= findViewById(R.id.ansm);
        cardm = findViewById(R.id.anscardm);

        Intent intent = getIntent();
        tile= intent.getIntExtra("tile",-1);
        digit = intent.getStringExtra("digit");
        Toast.makeText(Mixin.this,"digit: "+digit+"no of tile: "+round,Toast.LENGTH_LONG).show();

        mixstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum=1;
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
        if (digit.equals("single"))
            rand = new Random().nextInt(9);
        else
            rand = 10 + new Random().nextInt(9);
        rand = rand == 0 ? rand + new Random().nextInt(9) : rand;
        sum = sum * rand;
        setData();
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
            if(round == 2){
                timer.cancel();
                setData();
            }
            else {
                getRandom();
                i=3;
                timer.start();
            }
            round++;
            }
        }.start();

        }


        public void setData(){
            if(round == 2){
                cardm.setVisibility(View.VISIBLE);
                ansm.setText(""+sum);
                quesm.setText("??");
            }else {
                quesm.setText("* "+rand);
            }
        }

}

