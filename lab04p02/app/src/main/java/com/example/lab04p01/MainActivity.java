package com.example.lab04p01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    ImageView imageView01;
    TextView textView01;

    GestureDetector detektor;
    int[] obrazki = new int[] {
            R.drawable.rys_01,
            R.drawable.rys_02,
            R.drawable.rys_03,
            R.drawable.rys_04
    };
      String[] opisy;
    int poz =0;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opisy = getResources().getStringArray(R.array.opisy);
        imageView01 = findViewById(R.id.imageView01);
        textView01 = findViewById(R.id.textView01);
        poz = random.nextInt(obrazki.length);
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);
        detektor = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detektor.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void w_prawo() {
        poz++;
        if(poz==obrazki.length) poz=0;
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);
    }

    private void w_lewo() {
        poz--;
        if(poz<0) poz=obrazki.length-1;
        imageView01.setImageResource(obrazki[poz]);
        textView01.setText(opisy[poz]);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {

        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        Intent intencja = new Intent(getApplicationContext(), MainActivity2.class);
        intencja.putExtra("obrazek",obrazki[poz]);
        startActivity(intencja);
    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        int dx = Math.round(e2.getX()- e1.getX());
        int dy = Math.round(e2.getY()-e1.getY());
        if(Math.abs(dx) > Math.abs(dy))
        {
           if(dx>0)
               w_prawo();
           else
               w_lewo();
        }


        return false;
    }
}