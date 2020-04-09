package com.company;


import Dao.AlbumControler;
import Dao.ArtistControler;

import java.sql.*;
import java.util.List;

class Main{
    public static void main(String args[]){
        try {
            Connection conn =Database.getInstance().getConnection();
            ArtistControler a=new ArtistControler(conn);
            //a.create("Varlan","BulangiuStater");
            List<String> g=a.findByName("Varlan");
            for (String n : g) {
                System.out.println(n);
            }
            AlbumControler b =new AlbumControler(conn);
            //b.create("Spiri",1,1999);
            List<String> v= b.findByArtistId(1);
            for (String n : v) {
                System.out.println(n);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}


