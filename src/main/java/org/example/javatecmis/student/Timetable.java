package org.example.javatecmis.student;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javatecmis.connect.studentConnect;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Timetable {
    private Stage stage;

    private String id = null;
    private String department = null;
    private String dwPath = null;
    private Button dwnld = null;
    private Label Tmsg;
    private String exe = null;

    public Timetable(String id, String department, String dwPath, Button dwnld, Label Tmsg, String exe) {
        this.id = id;
        this.department = department;
        this.dwPath = dwPath;
        this.dwnld = dwnld;
        this.Tmsg = Tmsg;
        this.exe = exe;
    }

    public String getDepartment() {
        return department;
    }

    public String getDwPath() {
        return dwPath;
    }

    public Button getDwnld() {
        Button btn = new Button("Download");
        btn.setId(id);
        btn.setStyle("-fx-pref-width: 100px");
        btn.setStyle("-fx-font-family: Corbel");
        btn.setOnAction(event -> {
            handle(event);
        });
        return btn;
    }

    public void handle(ActionEvent event) {

        String path = "";
        path = getDwPath();
        String fileUrl = "https://drive.usercontent.google.com/u/0/uc?id="+path+"&export=download";
        FileChooser file = new FileChooser();
        Path selectedFile = file.showSaveDialog(stage).toPath();
        String URL = selectedFile.toString()+"."+exe;
        System.out.println(URL);
        try {
            downloadFile(fileUrl, URL);
            System.out.println("File downloaded successfully.");
            Tmsg.setStyle("-fx-text-fill: #21c721;");
            Tmsg.setText("Successfully Downloaded.");
        } catch (IOException e) {
            System.err.println("Error downloading file: " + e.getMessage());
            Tmsg.setStyle("-fx-text-fill: #fd1e1e;");
            Tmsg.setText("Downloading Error.");
        }
    }
    public static void downloadFile(String fileUrl, String destinationPath) throws IOException {
        URL url = new URL(fileUrl);
        Path path = Paths.get(destinationPath);
        Files.copy(url.openStream(), path);
    }
}
