package com.example.d.mojadieta;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Frost on 2017-06-07.
 */

public class XML2 {

    public Document get_xml(String uri) throws Exception{
        InputStream XmlFileInputStream;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File file = new File(uri);
        Document document = documentBuilder.parse(new FileInputStream(file));


        return document;
    }
}
