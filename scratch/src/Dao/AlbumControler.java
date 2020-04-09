package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumControler {
    private Connection conu;
    public AlbumControler(Connection conu)
    {
        this.conu=conu;
    }

    public void create(String name, int artistId,int year) throws SQLException {
        Statement sonu =conu.createStatement();
        sonu.executeUpdate("insert into Albums values(10,'"+name+"'," + artistId + ","+year);
    }

    public List<String> findByArtistId(int id) throws SQLException {
        Statement sonu = conu.createStatement();
        List<String> list = new ArrayList<>();
        ResultSet albums = sonu.executeQuery("select name from albums where artist_id="+id);
        if(albums!=null)
        while(albums.next())
        {
            list.add(albums.getString("name"));
        }
        albums.close();
        sonu.close();
        return list;

    }
}
