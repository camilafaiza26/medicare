package com.example.medicare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class EditProfileActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent photoIntent = new Intent();
                photoIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                if(photoIntent.resolveActivity(getPackageManager()) =! null ) {
                startActivityForResult(photoIntent, 201803);
//                }
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 201803 && resultCode == RESULT_OK ){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}