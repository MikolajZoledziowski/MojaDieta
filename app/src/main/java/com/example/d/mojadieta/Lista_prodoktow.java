package com.example.d.mojadieta;


import android.app.ListActivity;

import android.os.Bundle;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.d.mojadieta.R.id.nazwa;


public class Lista_prodoktow extends ListActivity {






    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prodoktow);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();


        XML xml = new XML();
        Document doc = null;
        try {
            doc= xml.get_xml();
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
            // adding each child node to HashMap key => value
            NodeList za = e.getChildNodes();
            map.put("nazwa", za.item(0).getTextContent());
            map.put("waga", za.item(1).getTextContent()+" "+za.item(2).getTextContent());
            map.put("kcal", "Kcal:"+za.item(3).getTextContent()+" Weglowodany:"+za.item(4).getTextContent()+" Tluszcz:"+za.item(5).getTextContent()+" Białko"+za.item(6).getTextContent());




            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.produkt,
                new String[] { "nazwa","waga","kcal"}, new int[] {
                nazwa ,R.id.waga,R.id.kcal});
        setListAdapter(adapter);
        ListView lv = getListView();
        // listening to single listitem click
    }
}
