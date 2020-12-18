package com.example.flashgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout mixsingle,mixdouble,sumsingle,sumdouble,multiplysingle,multiplydouble;
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mixsingle = findViewById(R.id.mixsingle);
        mixdouble = findViewById(R.id.mixdouble);
        sumdouble = findViewById(R.id.sumdouble);
        sumsingle = findViewById(R.id.sumsingle);
        multiplysingle = findViewById(R.id.multiplysingle);
        multiplydouble = findViewById(R.id.multiplydouble);
         intent = new Intent(MainActivity.this, Lev.class);

         sumsingle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 intent.putExtra("activity","sum");
                 intent.putExtra("digit","single");
                 startActivity(intent);
                 MainActivity.this.finish();

             }
         });
         sumdouble.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 intent.putExtra("activity","sum");
                 intent.putExtra("digit","double");
                 startActivity(intent);
                 MainActivity.this.finish();
             }
         });
         mixdouble.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 intent.putExtra("activity","mix");
                 intent.putExtra("digit","double");
                 startActivity(intent);
                 MainActivity.this.finish();
             }
         });

         mixsingle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 intent.putExtra("activity","mix");
                 intent.putExtra("digit","single");
                 startActivity(intent);
                 MainActivity.this.finish();
             }
         });
         multiplysingle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,Mixin.class);
                 intent.putExtra("digit","single");
                 startActivity(intent);
                 MainActivity.this.finish();
             }
         });
         multiplydouble.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,Mixin.class);
                 intent.putExtra("digit","double");
                 startActivity(intent);
                 MainActivity.this.finish();
             }
         });

//        intent.putExtra("phnno", phoneNo);
//        otp otimepass = new otp();
//        otimepass.setArguments(intent);
//        getFragmentManager().beginTransaction().replace(R.id.container,otimepass).commit();


    }
}