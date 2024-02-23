package org.example.javatecmis.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnect {
    String url;
    String user;
    String pswd;
    public Statement statement;

    public DbConnect(){

        url = "jdbc:mysql://localhost:3306/tecmis_teclms";
        user = "STUDENT";
        pswd = "1234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pswd);
            statement = conn.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }




}
