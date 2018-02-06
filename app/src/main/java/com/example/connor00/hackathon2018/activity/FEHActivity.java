package com.example.connor00.hackathon2018.activity;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.connor00.hackathon2018.R;

public class FEHActivity extends AppCompatActivity {
    private int lastHeroPicked = 0;
    private final String[] items = new String[]{"Alphonse", "Sharena", "Anna", "Veronica", "Ike", "Celica", "Kiran", "Chrom", "Lyndis"};
    private final int[] imgs = new int[]{R.drawable.alphonse, R.drawable.sharena, R.drawable.anna, R.drawable.veronica, R.drawable.ike, R.drawable.celica, R.drawable.kiran, R.drawable.chrom, R.drawable.lyn};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feh);
        setTitle("FEH Team Builder");

        Spinner dropdown = (Spinner) findViewById(R.id.heronames);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lastHeroPicked = i;
                ImageView iv = (ImageView) findViewById(R.id.heropic);
                iv.setImageResource(imgs[lastHeroPicked]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onClick(View v){
        ImageButton ib = (ImageButton) v;
        ib.setImageResource(imgs[lastHeroPicked]);
    }
}
