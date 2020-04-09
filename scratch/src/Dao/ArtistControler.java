package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistControler {
    private Connection conu;
    public ArtistControler(Connection conu)
    {
        this.conu=conu;
    }

    public void create(String name, String country) throws SQLException {
        Statement sonu =conu.createStatement();
        sonu.executeUpdate("insert into Artists values(2,'"+name+"','" + country + "')");
    }
    public List<String> findByName(String name) throws SQLException {
        Statement sonu =conu.createStatement();
        List<String> list=new ArrayList<>();
        ResultSet artists=sonu.executeQuery("select name from artists where name like '%"+name+"%'");
        if(artists !=null)
            while(artists.next())
            {
                list.add(artists.getString("name"));
            }
            artists.close();
            sonu.close();
            return list;
    }
}
