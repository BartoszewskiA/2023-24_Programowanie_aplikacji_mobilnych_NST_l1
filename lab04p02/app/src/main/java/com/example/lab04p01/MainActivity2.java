package com.example.lab04p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView02 = findViewById(R.id.imageView02);
        int id=  getIntent().getExtras().getInt("obrazek");
        imageView02.setImageResource(id);
    }
}