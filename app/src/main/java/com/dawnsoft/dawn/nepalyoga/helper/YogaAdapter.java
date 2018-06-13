package com.dawnsoft.dawn.nepalyoga.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dawnsoft.dawn.nepalyoga.R;

import java.util.ArrayList;

/**
 * Created by dawn on 3/27/2018.
 */

public class YogaAdapter extends RecyclerView.Adapter<YogaAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<Yoga> yogaList;

    public YogaAdapter(Context mContext, ArrayList<Yoga> yogaList) {
        this.mContext = mContext;
        this.yogaList = yogaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.yoga_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Yoga yoga = yogaList.get(position);
        holder.title.setText(yoga.getTitle());
        holder.time.setText(yoga.getTime() + " Minutes");
        holder.difficulty.setText(yoga.getDifficulty());
        holder.noOfClass.setText(yoga.getNoOfClass() + " classes");

//        holder.thumbnail.setImageResource(yoga.getImage());

        //loading thumbnail using glide library
        Glide.with(mContext).load(yoga.getImage()).into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return yogaList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title, time, difficulty, noOfClass;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            title = (TextView)itemView.findViewById(R.id.title_yogacard);
            time = (TextView)itemView.findViewById(R.id.time_yogacard);
            difficulty = (TextView)itemView.findViewById(R.id.difficulty_yogacard);
            noOfClass = (TextView)itemView.findViewById(R.id.noOfClass_yogacard);
            thumbnail = (ImageView)itemView.findViewById(R.id.thumbnail_yogacard);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
