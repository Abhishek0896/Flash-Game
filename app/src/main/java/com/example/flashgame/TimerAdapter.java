package com.example.flashgame;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.MyViewHolder> {
    ArrayList<String> data = new ArrayList<String>();
    Context context;
    int tile;

    public TimerAdapter(ArrayList<String> data, Context context, int tile) {
        this.data = data;
        this.context = context;
        this.tile = tile;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v;
        v= LayoutInflater.from(context).inflate(R.layout.raw_layout,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvload.setText(data.get(position));
        if(position == tile ){
            Intent intent = new Intent(context,AnswerAct.class);
            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(holder.tvload, "descTransition");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
            context.startActivity(intent, options.toBundle());

        }
//        new CountDownTimer(4000, 1000)
//        {
//            public void onTick(long millisUntilFinished)
//            {
//
//            }
//            public void onFinish()
//            {
//                    if(position +1 != data.size()) {
//                        data.set(position, "??");
//                        notifyDataSetChanged();
//                    }
//            }
//        }.start();

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvload;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvload = itemView.findViewById(R.id.mixin3);
        }
    }

    public void countdown(){
    }
}
