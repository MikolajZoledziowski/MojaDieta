package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class wprowadz_diete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadz_deiete);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(diety.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void powrot(View view) {
        Intent intent = new Intent(this, diety.class);
        startActivity(intent);
    }
}
