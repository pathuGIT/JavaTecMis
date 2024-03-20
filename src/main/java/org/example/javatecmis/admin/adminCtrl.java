package org.example.javatecmis.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.adminConnect;
import org.example.javatecmis.student.Attendance;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class adminCtrl {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label l;
    @FXML
    void btn(ActionEvent event) {
        l.setText("Kamal");
    }

    public void loginToAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }



    public void initialize(){

    }
}
