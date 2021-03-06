package com.example.d.mojadieta;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.d.mojadieta.R.id.nazwa;

public class Lodowka extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodowka);
        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();


        XML xml = new XML();
        Document doc = null;
        try {
            doc= xml.get_xml();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element rootElement = doc.getDocumentElement();
        Element produkty = (Element) rootElement.getElementsByTagName("lodowka").item(0);

        NodeList nl = produkty.getChildNodes();

        // looping through all item nodes <item>

        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            NodeList za = e.getChildNodes();
            map.put("wszystko" ,za.item(0).getTextContent()+":"+za.item(1).getTextContent()+"g");
            map.put("cos" ,za.item(1).getTextContent());




            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.lodowka,
                new String[] { "wszystko","cos"}, new int[] {
                R.id.wszystko,R.id.cos});
        setListAdapter(adapter);
        ListView lv = getListView();
    }
    public void ZawstoscDodaj(View view) {
        Intent intent = new Intent(this, Dodaj_zawartosc.class);

        startActivity(intent);
    }
    public void wroc(View view) {
        Intent intent = new Intent(this, MenuGlowne.class);

        startActivity(intent);
    }
}
