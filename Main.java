package com.company;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave(){
        Catalog catalog = new Catalog("Java Resources", "Desktop:/Facultate an 2/javalearn/lab 5/catalog.ser");
        Document doc = new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        try {
            CatalogUtil.save(catalog);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void testLoadView(){
        Catalog catalog = new Catalog();
        try {
            catalog = CatalogUtil.load("Desktop:/Facultate an 2/javalearn/lab 5/catalog.ser");
        }
        catch(IOException| InvalidCatalogException| ClassNotFoundException e) {
            e.printStackTrace();
        }
        Document doc = catalog.findById("java1");
        try {
            CatalogUtil.view(doc);
        }
        catch (IOException|URISyntaxException e){
            e.printStackTrace();
        }


    }
}
