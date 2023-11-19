package com.example.lab02p02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_1, edit_2, edit_wynik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_1 = findViewById(R.id.editText01);
        edit_2 = findViewById(R.id.editText02);
        edit_wynik = findViewById(R.id.editText03);
    }

    public void licz(View view) {
 /*       int x = Integer.parseInt(edit_1.getText().toString());
        int y = Integer.parseInt(edit_2.getText().toString());*/
        int x=0,y=0;
        String s = edit_1.getText().toString();
        if(s.isEmpty())
        {
            Toast.makeText(this, "Pole Dana_1 musi być wypełnione", Toast.LENGTH_SHORT).show();
            return;
        }
        x = Integer.parseInt(s);

        s = edit_2.getText().toString();
        if(s.isEmpty())
        {
            Toast.makeText(this, "Pole Dana_2 musi być wypełnione", Toast.LENGTH_SHORT).show();
            return;
        }
        y = Integer.parseInt(s);

        edit_wynik.setText(String.valueOf(x+y));
    }
}