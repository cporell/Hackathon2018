package com.example.connor00.hackathon2018.activity;

import android.graphics.Color;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.connor00.hackathon2018.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

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

    public void writeHeroData(){

    }

    // Code from https://stackoverflow.com/questions/13630844/read-write-to-external-xml-file-in-android
    public void readHeroData(){
        final String xmlFile = "heroes";
        ArrayList<String> heroes = new ArrayList<String>();
        String data = "";
        try{
            FileInputStream fis = getApplicationContext().openFileInput(xmlFile);
            InputStreamReader isr = new InputStreamReader(fis);
            char[] inputBuffer = new char[fis.available()];
            isr.read(inputBuffer);
            data = new String(inputBuffer);
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        factory.setNamespaceAware(true);
        XmlPullParser xpp = null;
        try {
            xpp = factory.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            xpp.setInput(new StringReader(data));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        int eventType = 0;
        try {
            eventType = xpp.getEventType();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        while (eventType != XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_DOCUMENT){
                System.out.println("start document");
            }
            else if(eventType == XmlPullParser.START_TAG){
                System.out.println("Start tag "+xpp.getName());
            }
            else if(eventType == XmlPullParser.END_TAG){
                System.out.println("End tag "+xpp.getName());
            }
            else if(eventType == XmlPullParser.TEXT){
                heroes.add(xpp.getText());
            }
            try{
                eventType = xpp.next();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
