package com.example.connor00.hackathon2018.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.connor00.hackathon2018.R;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToFEH(View view){
        Intent intent = new Intent(this, FEHActivity.class);
        startActivity(intent);
    }

    public void goToPKMN(View view){
        Intent intent = new Intent(this, PKMNActivity.class);
        startActivity(intent);
    }
}
