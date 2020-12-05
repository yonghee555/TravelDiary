package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);
    }

    public void getDiary(View view){
        String[] columns = new String[]{"name", "description", "latitude", "longitude"};
        Cursor c = getContentResolver().query(MyContentProvider.CONTENT_URI, columns, null,
                null, null, null);
        if(c!= null){
            TextView description = findViewById(R.id.textView10);
            //description.append()
        }
    }
}