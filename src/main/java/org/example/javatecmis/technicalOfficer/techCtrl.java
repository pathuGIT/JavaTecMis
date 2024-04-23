package org.example.javatecmis.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;

import java.io.IOException;
import java.util.Objects;

public class techCtrl {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label l;
    @FXML
    private Pane TimetablePane;
    @FXML
    private Pane attendplane;
    @FXML
    private Pane homePane;
    @FXML
    private Pane noticepane;
    @FXML
    private Pane profilePane;

    @FXML
    void btn(ActionEvent event) {
        l.setText("Kamal");
    }

    public void loginToTechofficer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("techOfficer.fxml")));
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


    @FXML
    void noticeFun(ActionEvent event) {
        choosePanel("notice");
    }

    @FXML
    void profileFun(ActionEvent event) {
        choosePanel("profile");
    }

    @FXML
    void timeFun(ActionEvent event) {
        choosePanel("timetable");
    }
    @FXML
    void AttendanceFun(ActionEvent event) {
        choosePanel("attendance");
    }

    @FXML
    void homeFun(ActionEvent event) {
        choosePanel("home");
    }


    void choosePanel(String  x){
        switch (x){
            case "home":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(true);
                noticepane.setVisible(false);
                profilePane.setVisible(false);

                break;
            case "attendance":
                TimetablePane.setVisible(false);
                attendplane.setVisible(true);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                break;
            case "timetable":
                TimetablePane.setVisible(true);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                break;
            case "profile":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(true);
                break;
            case "notice":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(true);
                profilePane.setVisible(false);
                break;
        }
    }



    public void initialize(){

    }
}
