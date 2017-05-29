package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Produkt extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkt);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.produkty_array,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        Intent intent = getIntent();
    }
    public void ProduktDodaj(View view) {
        Intent intent = new Intent(this, DodajProdukt.class);

        startActivity(intent);
    }
}
