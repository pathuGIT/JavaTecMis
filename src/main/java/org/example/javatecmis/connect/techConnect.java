package org.example.javatecmis.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class techConnect {
    String url;
    String user;
    String pswd;
    //public Statement statement;

    public Connection connect(){

        url = "jdbc:mysql://localhost:3306/tecmis_teclms";
        user = "TECHNICAL_OFFICER";//user
        pswd = "1234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pswd);
            //statement = conn.createStatement();
            return conn;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
