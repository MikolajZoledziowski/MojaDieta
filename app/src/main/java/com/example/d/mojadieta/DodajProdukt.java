package com.example.d.mojadieta;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class DodajProdukt extends AppCompatActivity {
    private static final String TAG ="Media" ;
    Spinner spinner;
    Context context ;
    String filename = "myfile";
    String string = "Hello world!";
    FileOutputStream fos;


    public void generateNoteOnSD(Context context, String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, sFileName);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String CreateXMLString() throws IllegalArgumentException, IllegalStateException, IOException
    {
        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();

        serializer.setOutput(writer);

        //Start Document
        serializer.startDocument(null, Boolean.valueOf(true));
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

        serializer.startTag(null, "root");

        for(int j = 0 ; j < 3 ; j++)
        {

            serializer.startTag(null, "record");

            serializer.text("test");

            serializer.endTag(null, "record");
        }
        serializer.endDocument();

        return writer.toString();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_produkt);
        Intent intent = getIntent();
        //lista
        spinner=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.Rodzajewag,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        try {
            generateNoteOnSD(this,filename,CreateXMLString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
