package com.example.lab03p01_przelicznik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_in, tv_out;
    RadioGroup rg_in, rg_out;
    RadioButton rb_in_pln, rb_in_euro, rb_in_usd,
                rb_out_pln, rb_out_euro, rb_out_usd;
    SeekBar sb_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        przygotuj();
        obslugaSuwaka();
        obslugaRadioButtonow();
    }

    private void obslugaRadioButtonow() {

        RadioGroup.OnCheckedChangeListener sluchacz = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                wyswietlWynik();
            }
        };
        rg_in.setOnCheckedChangeListener(sluchacz);
        rg_out.setOnCheckedChangeListener(sluchacz);
    }

    private void obslugaSuwaka() {
        sb_in.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_in.setText(String.valueOf(progress));
                wyswietlWynik();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void wyswietlWynik() {
        int k_in, k_out;
        if(rb_in_pln.isChecked())
            k_in=0;
        else if(rb_in_euro.isChecked())
            k_in=1;
        else
            k_in=2;
        if(rb_out_pln.isChecked())
            k_out=0;
        else if(rb_out_euro.isChecked())
            k_out=1;
        else
            k_out=2;
        double x = Double.parseDouble(tv_in.getText().toString());
        tv_out.setText(String.valueOf( przelicz(x, k_in,k_out)));
    }

    private void przygotuj() {
        tv_in = findViewById(R.id.tv_in);
        tv_out = findViewById(R.id.tv_out);
        sb_in = findViewById(R.id.sb_in);
        rb_in_pln = findViewById(R.id.rb_in_pln);
        rb_in_euro = findViewById(R.id.rb_in_euro);
        rb_in_usd = findViewById(R.id.rb_in_usd);
        rb_out_pln = findViewById(R.id.rb_out_pln);
        rb_out_euro = findViewById(R.id.rb_out_euro);
        rb_out_usd = findViewById(R.id.rb_out_usd);
        rb_in_pln.setChecked(true);
        rb_out_euro.setChecked(true);
        rg_in = findViewById(R.id.rg_in);
        rg_out = findViewById(R.id.rg_out);


    }

    double przelicz(double x, int k_in, int k_out)
    {
        //0 - PLN  1 - EURO   2 - USD
        double kurs_euro = 4.6;
        double kurs_usd = 4.12;
        double wynik = 0;
        double przeliczeniowaPln = 0;
        if(k_in==0)
            przeliczeniowaPln = x;
        else if(k_in==1)
            przeliczeniowaPln = x * kurs_euro;
        else
            przeliczeniowaPln = x * kurs_usd;

        if(k_out==0)
            wynik = przeliczeniowaPln;
        else if(k_out==1)
            wynik =  przeliczeniowaPln / kurs_euro;
        else
            wynik = przeliczeniowaPln / kurs_usd;

        wynik*=100;
        wynik = Math.round(wynik);
        wynik/=100;
        return wynik;
    }

}