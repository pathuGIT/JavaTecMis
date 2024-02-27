package org.example.javatecmis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.javatecmis.connect.DbConnect;
import org.example.javatecmis.connect.SelectDb;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class LoginController {
    private Stage stage;
    private Scene scene;
    public static  String tg;
    public static String pwd;

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorId;

    @FXML
    private TextField userName;
    private String uName = "TG0015";

    @FXML
    private TextField userPwd;
    private String uPwd = "1709e512";

    @FXML
    void login(ActionEvent event) {
        String query = "select * from student";

        try {
            DbConnect obj = new DbConnect();
            obj.connect();
            PreparedStatement pre = obj.connect().prepareStatement(query);
            ResultSet result = pre.executeQuery();

            boolean isAdmin = false;
            boolean isDean = false;

            while (result.next()) {
                tg = result.getString(1);
                pwd = result.getString(6);

                //if (userName.getText().equals(tg) && userPwd.getText().equals(pwd)) {
                if (uName.equals(tg) && uPwd.equals(pwd)) {

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student/student.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("student/student.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();

                } else if (userName.getText().equals("admin") && userPwd.getText().equals("1234")) {
                    isAdmin = true;
                } else if (userName.getText().equals("dean") && userPwd.getText().equals("1234")) {
                    isDean = true;
                }
            }
            // If user is not a student, check if they are admin or dean
            if (isAdmin) {
                new SelectDb("ADMIN", "1234", event);
            } else if (isDean) {
                new SelectDb("DEAN", "1234", event);
            } else {
                errorId.setText("Wrong credentials...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void loginCancel(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}