package com.example.flashgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Add extends AppCompatActivity {
    Button addhome, addstart;
    ScrollView scroll_add;
    CardView ans;
    TextView timeadd;
    Handler handler;
    TimerAdapter adapter;
    RecyclerView recyclerViewadd;
    int sum = 0, j;
    ArrayList<String> data = new ArrayList<>();
    TextView timeradd;
    boolean previoustimerstart = false;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        timeadd = findViewById(R.id.timeradd);
        addhome = findViewById(R.id.addhome);

        addstart = findViewById(R.id.addstart);
        recyclerViewadd = findViewById(R.id.recyleviewadd);


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
                data.clear();
                sum = 0;
                getRand();
            }
        });


    }

//    public void focusOnView(final  View view) {
//
//        try {
//            scroll_add.post(new Runnable() {
//            @Override
//            public void run() {
//                scroll_add.scrollTo(0, view.getBottom());
//            }
//        });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public synchronized void settimer() {
//        mix1.setText(""+getRand());
//        Toast.makeText(Add.this,""+sum, Toast.LENGTH_SHORT).show();
//       timer = new CountDownTimer(4000, 1000) {
//            int i = 3;
//
//            public void onTick(long millisUntilFinished) {
//                timeadd.setText("" + i);
//                i--;
//            }
//
//            public void onFinish() {
//                mix2.setText(""+getRand());
//                mix3.setText(""+getRand());
//                mix4.setText(""+sum);
//                j++;
//                previoustimerstart = false;
//            }
//
//          }.start();
//
//       timer.cancel();
//
//       j=0;
//    }

    public void getRand() {

        data.clear();
        int i = 0;
        int val = 0;
        while (i < 3) {
            int rand = + new Random().nextInt(9);
            rand = rand == 0 ? rand + new Random().nextInt(9) : rand;
            sum = sum + rand;
            int s = sum;

            data.add(i, "" + rand);
            i++;
        }
        data.add(3, "??");
        adapter = new TimerAdapter(data, Add.this,3);
        recyclerViewadd.setLayoutManager(new LinearLayoutManager(Add.this));
        recyclerViewadd.setAdapter(adapter);
        settimer(sum);

    }


    public void settimer(int sum) {
        new CountDownTimer(6000, 1000) {
            int i =5 ;
            public void onTick(long millisUntilFinished) {
                if (i >= 0) {
                    timeadd.setText("" + i);
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