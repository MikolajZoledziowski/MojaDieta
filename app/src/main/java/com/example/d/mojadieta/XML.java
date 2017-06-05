package com.example.d.mojadieta;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import javax.xml.parsers.*;
/**
 * Created by Frost on 2017-06-05.
 */

public class XML {


    public Document get_xml() throws Exception{
        InputStream XmlFileInputStream;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File file = new File("storage/sdcard/XML.txt");
        Document document = documentBuilder.parse(new FileInputStream(file));


    return document;
    }


}
