package org.example.javatecmis.connect;
import javafx.event.ActionEvent;
import org.example.javatecmis.admin.Admin;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class SelectDb {    private Stage stage;
    private Scene scene;
    String user;
    String pswd;

    Statement statement;

    public SelectDb(String user, String pswd, ActionEvent event){
        String url = "jdbc:mysql://localhost:3306/tecmis_teclms";
        this.user = user;
        this.pswd = pswd;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pswd);
            statement = conn.createStatement();

            switch (user){
                case "ADMIN":
                    Admin obj = new Admin();
                    //obj.loginToAdmin(event);
                    break;
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
