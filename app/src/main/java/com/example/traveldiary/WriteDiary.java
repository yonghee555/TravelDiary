package com.example.traveldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class WriteDiary extends AppCompatActivity {

    Button upload;
    private static final int PICK_IMAGE = 100;
    Bitmap picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);

        upload = (Button) findViewById(R.id.button_upload);
        upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, PICK_IMAGE);
            }
        });
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri uri = data.getData();
            String x = getPath(uri);

            try{
                InputStream is = getContentResolver().openInputStream(uri);
                picture = BitmapFactory.decodeStream(is);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri){
        if(uri == null)
            return null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor c = managedQuery(uri, projection, null, null, null);
        if(c != null){
            int column_index = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            c.moveToFirst();
            return c.getString(column_index);
        }
        return uri.getPath();
    }

    public byte[] getImage(Bitmap bitmap){
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, os);
        byte[] data = os.toByteArray();
        return data;
    }


    public void addDiary(View view){
        ContentValues addValues = new ContentValues();
        addValues.put(MyContentProvider.NAME,((EditText) findViewById(R.id.editText)).getText().toString());
        addValues.put(MyContentProvider.DESCRIPTION,((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString());
        addValues.put(MyContentProvider.LATITUDE,((EditText) findViewById(R.id.editTextNumberDecimal)).getText().toString());
        addValues.put(MyContentProvider.LONGITUDE,((EditText) findViewById(R.id.editTextNumberDecimal2)).getText().toString());
        addValues.put(MyContentProvider.IMG, getImage(picture));
        getContentResolver().insert(MyContentProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(), "일기가 추가되었습니다", Toast.LENGTH_LONG).show();
    }

}