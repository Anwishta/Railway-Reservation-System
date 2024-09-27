package org.example;
import java.sql.*;

public class ConnectDB {

    Connection c;
    Statement s;
    public ConnectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///railwayreservationsystem", "root", "Ag@30072003");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
