package com.example.traveldiary;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText;

        MyViewHolder(View view) {
            super(view);
            myText = view.findViewById(R.id.textView);
        }
    }

    private ArrayList<Diary> diaryList;

    MyAdapter(ArrayList<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myText.setText(diaryList.get(position).getName());

        myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ShowDiary.class);
                intent.putExtra("name", diaryList.get(position).getName());
                intent.putExtra("description", diaryList.get(position).getDescription());
                intent.putExtra("latitude", diaryList.get(position).getLatitude());
                intent.putExtra("longitude", diaryList.get(position).getLongitude());
                intent.putExtra("img", diaryList.get(position).getImg());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }
}