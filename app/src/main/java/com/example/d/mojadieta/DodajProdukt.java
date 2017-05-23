package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DodajProdukt extends AppCompatActivity {
    Spinner spinner;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_produkt);
        Intent intent = getIntent();
        spinner=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.Rodzajewag,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }



}
