package com.example.d.mojadieta;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

import static com.example.d.mojadieta.R.id.nazwa;

public class Lista_prodoktow2 extends ListActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prodoktow2);

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

        // selecting single ListView item
        ListView lv = getListView();
        // listening to single listitem click

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
            // getting values from selected ListItem
            String name = ((TextView) view.findViewById(nazwa)).getText().toString();
            Intent intent = getIntent();
            XML xml = new XML();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            Document document=null;
            Intent in = new Intent(getApplicationContext(), wprowadz_przepis.class);
            try {
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                document = xml.get_xml();


            } catch ( Exception e) {
                e.printStackTrace();
            }
            in.putExtra("nazwa",intent.getStringExtra(przepisy.EXTRA_MESSAGE) );
            Element rootElement = document.getDocumentElement();
            Element produkty = (Element) rootElement.getElementsByTagName("przepisy").item(0);
            Element przepis = (Element) produkty.getLastChild();
            Element skladnik = (Element) przepis.getLastChild();

            Element nazwa = document.createElement("nazwa");
            nazwa.setTextContent(name);
            skladnik.appendChild(nazwa);



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




            startActivity(in);

        }
    });
    }
}