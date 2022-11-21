package com.example.useopencvwithcmake;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RoiActivity extends AppCompatActivity {
    ImageView roi_img;
    Bitmap image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roi);
        roi_img = (ImageView)findViewById(R.id.roi_photo);

        Intent intent = getIntent();
        byte[] arr = intent.getByteArrayExtra("roi");
        image = BitmapFactory.decodeByteArray(arr,0,arr.length);
        roi_img.setImageBitmap(image);

        Button b1 = (Button) findViewById(R.id.clear);
        final TouchDraw td = (TouchDraw) findViewById(R.id.draw);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                td.reset();
                Toast.makeText(getApplicationContext(), "지워졌습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

