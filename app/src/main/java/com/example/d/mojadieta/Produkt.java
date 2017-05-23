package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Produkt extends AppCompatActivity {

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
}
