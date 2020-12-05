package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ShowDiary extends AppCompatActivity {

    TextView name;
    EditText description;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);

        name = (TextView) findViewById(R.id.textView8);
        description = (EditText) findViewById(R.id.editTextTextMultiLine2);

        Intent intent = getIntent();
        String n = "여행지 이름 : " + intent.getStringExtra("name");
        name.setText(n);
        description.append(intent.getStringExtra("description"));

        setImage(intent.getByteArrayExtra("img"));

    }

    private void setImage(byte[] image){
        try{
            //InputStream is = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            imageView.setImageBitmap(bitmap);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}