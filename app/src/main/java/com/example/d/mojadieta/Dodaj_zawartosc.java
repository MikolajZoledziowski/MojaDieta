package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Dodaj_zawartosc extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_zawartosc);
        spinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.produkty_array,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        Intent intent = getIntent();
    }
}
