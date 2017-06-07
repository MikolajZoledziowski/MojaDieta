package com.example.d.mojadieta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Plan extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
    }

    public void Plan1(View view) {
        Intent intent = new Intent(this, lista_przepisow2.class);
        intent.putExtra("sciezka","storage/sdcard/XML1.xml");
        startActivity(intent);
    }

    public void Plan2(View view) {
        Intent intent = new Intent(this, lista_przepisow2.class);
        intent.putExtra("sciezka","storage/sdcard/XML2.xml");
        startActivity(intent);
    }

    public void Plan3(View view) {
        Intent intent = new Intent(this, lista_przepisow2.class);
        intent.putExtra("sciezka","storage/sdcard/XML3.xml");
        startActivity(intent);
    }
}
