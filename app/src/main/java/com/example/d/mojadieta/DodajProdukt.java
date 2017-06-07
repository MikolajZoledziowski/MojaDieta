package com.example.d.mojadieta;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class DodajProdukt extends AppCompatActivity {
    private static final String TAG ="Media" ;
    Spinner spinner;
    Context context ;


    public void DodajP(View view)
    {
         EditText nazwa =  (EditText) findViewById(R.id.nazwa);
         Spinner jednostka =  (Spinner) findViewById(R.id.wybiezwage);
         EditText kcal=  (EditText) findViewById(R.id.kcal);
         EditText weglowodany=  (EditText) findViewById(R.id.weglowodany);
         EditText tluszcze=  (EditText) findViewById(R.id.tluszcze);
        EditText bialka=  (EditText) findViewById(R.id.bialka);
        XML xml = new XML();
        Document document = null;
        try {
            document = xml.get_xml();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Element rootElement = document.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("produkty").item(0);

        Element newProdukt = document.createElement("produkt");


        Element nazwa2= document.createElement("nazwa");
        nazwa2.setTextContent(nazwa.getText().toString());
        newProdukt.appendChild(nazwa2);




        Element waga= document.createElement("waga");
        waga.setTextContent("100");
        newProdukt.appendChild(waga);





        Element rodzaj_wagi= document.createElement("rodzaj_wagi");
        rodzaj_wagi.setTextContent(jednostka.getSelectedItem().toString());
        newProdukt.appendChild(rodzaj_wagi);




        Element kcal2 = document.createElement("kcal");
        kcal2.setTextContent(kcal.getText().toString());
        newProdukt.appendChild(kcal2);




        Element weglowodany2= document.createElement("weglowodany");
        weglowodany2.setTextContent(weglowodany.getText().toString());
        newProdukt.appendChild(weglowodany2);




        Element tluszcze2= document.createElement("tluszcze");
        tluszcze2.setTextContent(tluszcze.getText().toString());
        newProdukt.appendChild(tluszcze2);




        Element bialka2= document.createElement("bialka");
        bialka2.setTextContent(bialka.getText().toString());
        newProdukt.appendChild(bialka2);








        produkty.appendChild(newProdukt);
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

        Intent intent = new Intent(this, Produkt.class);

        startActivity(intent);

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_produkt);
        Intent intent = getIntent();

        //lista
        spinner=(Spinner) findViewById(R.id.wybiezwage);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.Rodzajewag,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


    }


}
