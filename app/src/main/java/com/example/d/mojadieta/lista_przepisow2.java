package com.example.d.mojadieta;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.d.mojadieta.R.id.nazwa;

public class lista_przepisow2 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_przepisow2);
        Intent intent = getIntent();
        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();


        XML2 xml = new XML2();
        Document doc = null;
        try {
            doc= xml.get_xml(intent.getStringExtra("sciezka"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element rootElement = doc.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("produkty").item(0);

        NodeList nl = produkty.getChildNodes();

        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            String skladniki = "";
            // adding each child node to HashMap key => value
            NodeList za = e.getChildNodes();
            for(int j=1;j< za.getLength()-1;j++) {
                Element f = (Element) za.item(j);
                NodeList wynik = f.getChildNodes();
                skladniki = skladniki + wynik.item(0).getTextContent() +" "+ wynik.item(1).getTextContent()+"\n";

            }
            map.put("nazwa", za.item(0).getTextContent());
            map.put("skladniki", skladniki);
            map.put("opis", za.item(za.getLength()-1).getTextContent());




            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.przepis,
                new String[] { "nazwa","skladniki","opis"}, new int[] {
                R.id.nazwa ,R.id.skladniki,R.id.opis});

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();
    }
}
