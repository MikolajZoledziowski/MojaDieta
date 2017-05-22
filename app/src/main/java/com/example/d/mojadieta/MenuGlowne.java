package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuGlowne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_glowne);
    }
    public void Produkt(View view) {
        Intent intent = new Intent(this, Produkt.class);

        startActivity(intent);
    }
}

