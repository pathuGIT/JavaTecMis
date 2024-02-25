package org.example.javatecmis.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.DbConnect;

import java.io.IOException;
import java.sql.ResultSet;


public class Student {
    private Stage stage;
    private Scene scene;
    private int S = 1;

    @FXML
    private Label sName;
    @FXML
    private Label sId;
    @FXML
    private Label sDep;
    @FXML
    private Label sTel;
    @FXML
    private Label sMail;
    @FXML
    private Label sNic;
    @FXML
    private Pane ProfilePane;

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);

    }
    @FXML
    void course(ActionEvent event) {
        System.out.println("sfsg");
    }
    @FXML
    void profile(){
        if(S == 1){
            ProfilePane.setVisible(false);
            S = 0;
        }else{
            ProfilePane.setVisible(true);
            S = 1;
        }
    }

    void showStudentData(){
        LoginController obj = new LoginController();
        String TG = obj.tg;
        try{
            String query = "Select * from student where Std_id = '"+TG+"'";
            DbConnect connect = new DbConnect();
            ResultSet result = connect.statement.executeQuery(query);
            while (result.next()) {
                sName.setText(result.getString(2));
                sId.setText(result.getString(1));
                sDep.setText(result.getString(8));
                sTel.setText(result.getString(4));
                sMail.setText(result.getString(3));
                sNic.setText(result.getString(5));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void initialize(){
        System.out.println("here");
        showStudentData();
        profile();
    }
}