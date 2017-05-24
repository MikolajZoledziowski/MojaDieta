package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class wprowadz_przepis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadz_przepis);


        Intent intent = getIntent();
        String message = intent.getStringExtra(przepisy.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.textView_przepisy);
        textView.setText(message);
    }

    public void powrot(View view) {
        Intent intent = new Intent(this, przepisy.class);
        startActivity(intent);
    }
}

