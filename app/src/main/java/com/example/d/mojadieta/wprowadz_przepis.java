package com.example.d.mojadieta;
import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

        EditText opis =  (EditText) findViewById(R.id.tluszcze);
        XML xml = new XML();
        Document document= null;
        Intent intent2 = new Intent(this, Lista_prodoktow2.class);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            document = xml.get_xml();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element rootElement = document.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("przepisy").item(0);
        Element przepis = (Element) produkty.getLastChild();

        Element opis2 = (Element) document.createElement("opis");
        opis2.setTextContent(opis.getText().toString());

        przepis.appendChild(opis2);


        DOMSource source = new DOMSource(document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();

            StreamResult result = null;

            result = new StreamResult(new FileOutputStream("storage/sdcard/XML.xml"));

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


        startActivity(intent);


    }

    public void wybiez(View view) {
        EditText nazwa =  (EditText) findViewById(R.id.editText2);
        Intent intent = getIntent();
        XML xml = new XML();
        Document document= null;
        Intent intent2 = new Intent(this, Lista_prodoktow2.class);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            document = xml.get_xml();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element rootElement = document.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("przepisy").item(0);
        Element przepis = (Element) produkty.getLastChild();
        Element skladnik = (Element) document.createElement("skladnik") ;
        Element waga = (Element) document.createElement("waga");
        waga.setTextContent(nazwa.getText().toString());
        skladnik.appendChild(waga);
        przepis.appendChild(skladnik);


        DOMSource source = new DOMSource(document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();

            StreamResult result = null;

            result = new StreamResult(new FileOutputStream("storage/sdcard/XML.xml"));

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }







        intent2.putExtra("nazwa",intent.getStringExtra(przepisy.EXTRA_MESSAGE) );
        startActivity(intent2);
    }

}

