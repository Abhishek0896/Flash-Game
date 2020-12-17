package com.example.flashgame;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.MyViewHolder> {
    ArrayList<String> data = new ArrayList<String>();
    Context context;

    public TimerAdapter(ArrayList<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v;
        v= LayoutInflater.from(context).inflate(R.layout.raw_layout,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvload.setText(data.get(position));
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
