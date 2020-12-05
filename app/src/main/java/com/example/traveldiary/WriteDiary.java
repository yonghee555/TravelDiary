package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WriteDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);
    }

    public void addDiary(View view){
        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.NAME,((EditText) findViewById(R.id.editText)).getText().toString());
        addValues.put(MyContentProvider.DESCRIPTION,((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString());
        addValues.put(MyContentProvider.LATITUDE,((EditText) findViewById(R.id.editTextNumberDecimal)).getText().toString());
        addValues.put(MyContentProvider.LONGITUDE,((EditText) findViewById(R.id.editTextNumberDecimal2)).getText().toString());
        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(), "일기가 추가되었습니다", Toast.LENGTH_LONG).show();

    }

}