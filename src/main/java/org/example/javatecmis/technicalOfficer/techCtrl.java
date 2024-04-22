package org.example.javatecmis.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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



    public void initialize(){

    }
}
