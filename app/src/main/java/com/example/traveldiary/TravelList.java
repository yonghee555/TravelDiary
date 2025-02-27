package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class TravelList extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_list);

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        String[] columns = new String[]{"name", "description", "latitude", "longitude", "img"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null,
                null, null, null);
        ArrayList<Diary> diaryList = new ArrayList<>();
        if(c!= null){
            while(c.moveToNext()){
                diaryList.add(new Diary(c.getString(0), c.getString(1), c.getDouble(2), c.getDouble(3), c.getBlob(4)));
            }
            c.close();
        }

        MyAdapter myAdapter = new MyAdapter(diaryList);
        myRecyclerView.setAdapter(myAdapter);
    }
}