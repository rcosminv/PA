package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.security.krb5.internal.crypto.Des;

import javax.print.attribute.URISyntax;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {


    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }


    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException
    {
        Catalog cat = new Catalog("new", path);
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cat = (Catalog) ois.readObject();
        }
        catch (IOException io){
            System.out.println("Error reading file");
            io.printStackTrace();
        }catch(ClassNotFoundException cn){
            System.out.println("Error loading treets");
            cn.printStackTrace();
        }
        return cat;
    }


    public static void view(Document doc)
            throws IOException, URISyntaxException {
        try {
            Desktop desktop = Desktop.getDesktop();
            String path = doc.getLocation();

            boolean isWeb = path.startsWith("http://") || path.startsWith("https://");
            if(isWeb)
                desktop.browse(new URI(path));
            else{
                File file = new File(doc.getLocation());
                desktop.open(file);
            }
        } catch (IOException | URISyntaxException io) {
            io.printStackTrace();
        }
    }

}

