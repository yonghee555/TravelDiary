package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDiary extends AppCompatActivity {

    TextView name, description;
    // TODO : description 멀티라인으로 변경
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);

        name = (TextView) findViewById(R.id.textView8);
        description = (TextView) findViewById(R.id.textView10);

        Intent intent = getIntent();
        String n = "여행지 이름 : " + intent.getStringExtra("name");

        name.setText(n);
        description.setText(intent.getStringExtra("description"));
    }

}