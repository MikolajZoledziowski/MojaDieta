package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Produkt extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produkt);


        Intent intent = getIntent();
    }
    public void ProduktDodaj(View view) {
        Intent intent = new Intent(this, DodajProdukt.class);

        startActivity(intent);
    }

    public void ProduktWyswietl(View view) {

        Intent intent = new Intent(this, Lista_prodoktow.class);
        startActivity(intent);
    }
}
