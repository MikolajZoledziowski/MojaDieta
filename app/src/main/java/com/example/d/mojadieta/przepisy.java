package com.example.d.mojadieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class przepisy extends AppCompatActivity  {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przepisy);


    }

    public void wyslijprzepis(View view) throws Exception {
        Intent intent = new Intent(this, wprowadz_przepis.class);
        EditText editText = (EditText) findViewById(R.id.bialka);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        Document document= null;
        XML xml = new XML();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        document = xml.get_xml();

        Element rootElement = document.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("przepisy").item(0);
        Element przepis = document.createElement("przepis");
        Element nazwa = document.createElement("nazwa");
        nazwa.setTextContent(editText.getText().toString());
        przepis.appendChild(nazwa);
        produkty.appendChild(przepis);
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

    public void PrzepisWyswietl(View view) {

        Intent intent = new Intent(this, Lista_przepisow.class);
        startActivity(intent);
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
}
