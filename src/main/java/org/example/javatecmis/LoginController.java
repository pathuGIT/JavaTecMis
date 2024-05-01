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
import org.example.javatecmis.admin.adminCtrl;
import org.example.javatecmis.connect.adminConnect;
import org.example.javatecmis.connect.studentConnect;
import org.example.javatecmis.lecturer.lecCtrl;
import org.example.javatecmis.technicalOfficer.techCtrl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class LoginController {

    private double xOffset = 0;
    private double yOffset = 0;

    private Stage stage;
    private Scene scene;
    public  String tg;
    public static String pwd;

    public static String offtg ;
    public static String STDG ;
    public static String LETG;

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorId;

    @FXML
    private TextField userName;
    private String uName = "TG0001";

    @FXML
    private TextField userPwd;
    private String uPwd = "336ebe3a";

    @FXML
    void login(ActionEvent event1) {
        //String query = "select * from student";
        String query = "SELECT ID, Password, 'Technical_Officer' AS Position FROM Technical_Officer UNION SELECT Lec_id AS ID, Password, 'Lecture' AS Position FROM Lecture UNION SELECT username AS ID, Password, 'Admin' AS Position FROM Admin UNION SELECT Std_id AS ID, Password, 'Student' AS Position FROM Student";
        try {
            adminConnect obj = new adminConnect();
            obj.connect();
            PreparedStatement pre = obj.connect().prepareStatement(query);
            ResultSet result = pre.executeQuery();

            boolean isAdmin = false;
            boolean isDean = false;

            while (result.next()) {
                tg = result.getString(1);
                pwd = result.getString(2);

                if (userName.getText().equals(tg) && userPwd.getText().equals(pwd) && result.getString(3).equals("Student")) {
                //if (uName.equals(tg) && uPwd.equals(pwd)) {
                    System.out.println(tg+" "+pwd);
                    STDG = tg;

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student/student.fxml")));
                    stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("student/student.css").toExternalForm());

//                    X & Y move access from mouse
                    root.setOnMousePressed(event -> {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    });
                    root.setOnMouseDragged(event -> {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    });

                    stage.setScene(scene);
                    stage.show();
                    stage.setScene(scene);
                    stage.show();

                } else if (userName.getText().equals(tg) && userPwd.getText().equals(pwd) && result.getString(3).equals("Admin")) {
                    System.out.println(userName.getText()+" "+userPwd.getText());
                    adminCtrl ad = new adminCtrl();
                    ad.loginToAdmin(event1);
                    break;

                    //} else if (userName.getText().equals("lecturer") && userPwd.getText().equals("1234")) {
                } else if (userName.getText().equals(tg) && userPwd.getText().equals(pwd) && result.getString(3).equals("Lecture")) {
                    LETG = tg;
                    lecCtrl ad = new lecCtrl();
                    ad.loginToLecturer(event1);
                    break;

                } else if (userName.getText().equals(tg) && userPwd.getText().equals(pwd) && result.getString(3).equals("Technical_Officer")) {
                    offtg = tg;
                    System.out.println("hel");
                    techCtrl ad = new techCtrl();
                    ad.loginToTechofficer(event1);
                    break;
                }else {
                    errorId.setText("Wrong credentials...");
                }
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

    public void logout(ActionEvent event1) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());

//      X & Y move access from mouse
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();

    }
}