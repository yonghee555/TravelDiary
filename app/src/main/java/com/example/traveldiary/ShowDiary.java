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
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary);

        name = (TextView) findViewById(R.id.textView8);
        description = (EditText) findViewById(R.id.editTextTextMultiLine2);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button_map);

        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        name.setText("여행지 이름 : " + n);
        description.append(intent.getStringExtra("description"));
        setImage(intent.getByteArrayExtra("img"));
        Double latitude = intent.getDoubleExtra("latitude", 0);
        Double longitude = intent.getDoubleExtra("longitude", 0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MapsActivity.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                intent.putExtra("name", n);
                startActivity(intent);
            }
        });
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