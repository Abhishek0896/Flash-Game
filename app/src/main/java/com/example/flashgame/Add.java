package com.example.flashgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Add extends AppCompatActivity {
    Button addhome, addstart;
    TextView timeadd;
    Handler handler;
    CardView anscard;
    CountDownTimer timer;
    int sum = 0, j,i=3;
    ArrayList<String> data = new ArrayList<>();
    TextView timeradd,ques,ans;
    boolean previoustimerstart = false;
    int round;
    String digit,type;
    int tile,rand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        tile = intent.getIntExtra("tile",-1);
        digit = intent.getStringExtra("digit");
        type = intent.getStringExtra("activity");

        timeadd = findViewById(R.id.timeradd);
        addhome = findViewById(R.id.addhome);
        ques = findViewById(R.id.quesm);
        ans = findViewById(R.id.ansm);
        anscard = findViewById(R.id.anscardm);
        addstart = findViewById(R.id.addstart);



        addhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add.this, MainActivity.class);
                Add.this.finish();
                startActivity(intent);
            }
        });

        addstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anscard.setVisibility(View.GONE);
                i=3;
                round =1;
                data.clear();
                sum=0;
                getRand();
                settimer();
            }
        });


    }

    public void getRand() {

        if(type.equals("sum")) {
            if (digit.equals("single"))
                rand = new Random().nextInt(9);
            else
                rand = 10 + new Random().nextInt(9);
            rand = rand == 0 ? rand + new Random().nextInt(9) : rand;
            sum = sum + rand;
            int s = sum;
            setData();
        }else{
            if (digit.equals("single"))
                rand = -10+ new Random().nextInt(20);
            else
                rand = -20 + new Random().nextInt(30);
            rand = rand == 0 ? rand + new Random().nextInt(9) : rand;
            sum = sum + rand;
            int s = sum;
            setData();
        }

    }





    public void settimer() {

        int interval = 4000;

        timer = new CountDownTimer(interval, 1000) {


            public void onTick(long millisUntilFinished) {
                if (i >= 0) {
                    timeadd.setText("" + i);
                    i--;
                }
            }

            public void onFinish() {
                if (round == tile) {
                    timer.cancel();
                    setData();
                } else if(round < tile) {
//                    setData();
                    i = 3;
                    getRand();
                    timer.start();
                }
                round++;
            }
        }.start();
    }

    public void setData(){
        if(round == tile){
            ques.setText("??");
            anscard.setVisibility(View.VISIBLE);
            ans.setText(""+sum);
        }else{
            if(rand >=0)
                ques.setText("+"+rand);
            else
                ques.setText(""+rand);
        }
    }


//        new CountDownTimer(6000, 1000) {
//            int i =5 ;
//            public void onTick(long millisUntilFinished) {
//                if (i >= 0) {
//                    timeadd.setText("" + i);
//                    i--;
//                }
//            }
//            public void onFinish() {
//                data.set(0,"??");
//                data.set(1,"??");
//                data.set(2,"??");
//                data.set(3,""+sum);
//            }
//        }.start();



}




//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Message message = new Message();
//                Bundle bundle = new Bundle();
//                int i =3;
//                try{
//                    while(i>=0){
//                        bundle.putString("timer", ""+i);
//                        message.setData(bundle);
//                        handler.sendMessage(message);
//                        i--;
//                    Thread.sleep(3000);
//                    }
//                }catch (Exception e){e.printStackTrace();}
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//        runOnUiThread(new Runnable() {
//            int i=3;
//            @Override
//            public void run() {
//
//                try {
//                    sleep(3000);
//                    while (i>=0){
//                        timeadd.setText(""+i);
//                        i--;
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


//__________________________________________
//                if(j==0){

//                    focusOnView(mix2);
//                    mix1.setText("??");
//                }
//                else if(j==1){

//                    focusOnView(mix3);
//                    mix2.setText("??");
//                }
//                else if(j==2){

//                    focusOnView(mix4);
//                    mix3.setText("??");
//                }