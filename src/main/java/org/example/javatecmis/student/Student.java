package org.example.javatecmis.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.DbConnect;
import javafx.stage.FileChooser;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.Types.NULL;


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
    private Circle userImg;
    @FXML
    private Circle circle;
    @FXML
    private Label userName;
    @FXML
    private TextField edit_email;
    @FXML
    private TextField edit_number;

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }

    @FXML
    public void imgUpload(ActionEvent event) throws IOException, SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Display the selected image in a Circle
            Image image = new Image(selectedFile.toURI().toString());
            circle.setFill(new ImagePattern(image));

            // Save the selected image file to the 'img' folder
            File imgFolder = new File("img");
            if (!imgFolder.exists()) {
                imgFolder.mkdirs(); // Create the 'img' folder if it doesn't exist
            }
            File destinationFile = new File(imgFolder, selectedFile.getName());
            Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Save the path of the saved image file to the database
            String imagePath = "img/" + selectedFile.getName(); // Relative path to the 'img' folder
            String sql = "UPDATE student SET Image = ? WHERE Std_id = ?";
            try {
                DbConnect DB = new DbConnect();
                LoginController login = new LoginController();
                String TG = login.tg;

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, imagePath);
                pst.setString(2, TG);

                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Student.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }

    @FXML
    public void displayImageFromDB() {
        try {
            // Retrieve the image path from the database for the specific student
            String sql = "SELECT Image FROM student WHERE Std_id = ?";
            DbConnect DB = new DbConnect();
            LoginController login = new LoginController();
            String TG = login.tg;

            PreparedStatement pst = DB.connect().prepareStatement(sql);
            pst.setString(1, TG);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if(rs.getString("Image") != null){
                    // Construct the absolute path to the image file
                    String relativeImagePath = rs.getString("Image");
                    String absoluteImagePath = Paths.get(System.getProperty("user.dir"), relativeImagePath).toString();

                    // Load the image file and display it in the ImageView
                    File imageFile = new File(absoluteImagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        circle.setFill(new ImagePattern(image));
                        userImg.setFill(new ImagePattern(image));
                    } else {
                        System.out.println("Image file not found: " + absoluteImagePath);
                    }
                }else{
                    String path = "img/account.png";
                    File imageFile = new File(path);
                    Image image = new Image(imageFile.toURI().toString());
                    circle.setFill(new ImagePattern(image));
                    userImg.setFill(new ImagePattern(image));
                }

            } else {
                System.out.println("No image found for the student with ID: " + TG);
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Student.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @FXML
    void deleteImage(){
        DbConnect DB = new DbConnect();
        LoginController login = new LoginController();
        String TG = login.tg;
        try {
            String sql = "update student set Image = NULL where Std_id = '"+TG+"'";
            PreparedStatement ptr = DB.connect().prepareStatement(sql);
            ptr.executeUpdate();

            String path = "img/account.png";
            File imageFile = new File(path);
            Image image = new Image(imageFile.toURI().toString());
            circle.setFill(new ImagePattern(image));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void updateStudentData() {
        try {
            String sql = "SELECT * FROM student WHERE Std_id = ?";
            DbConnect DB = new DbConnect();

            LoginController login = new LoginController();
            String TG = login.tg;

            if(edit_email.getText().isEmpty() && edit_number.getText().isEmpty()){

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, TG);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    edit_email.setText(rs.getString(3));
                    edit_number.setText(rs.getString(4));
                } else {
                    System.out.println("No Data for the student with ID: " + TG);
                }

            }else{
                String query = "UPDATE student SET Email = ?, Contact = ? WHERE Std_id = ?";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(1, edit_email.getText());
                pst.setString(2, edit_number.getText());
                pst.setString(3, TG);
                pst.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void home(ActionEvent event) {
        if(S == 1){
            ProfilePane.setVisible(false);
            S = 0;
        }
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
            displayImageFromDB();
        }
    }

    void showStudentData(){
        LoginController obj = new LoginController();
        String TG = obj.tg;
        try{
            System.out.println(TG);
            String query = "Select * from student where Std_id = '"+TG+"'";
            DbConnect connect = new DbConnect();
            PreparedStatement ptr = connect.connect().prepareStatement(query);
            ResultSet result = ptr.executeQuery();

            while (result.next()) {
                sName.setText(result.getString(2));
                sId.setText(result.getString(1));
                sDep.setText(result.getString(8));
                sTel.setText(result.getString(4));
                sMail.setText(result.getString(3));
                sNic.setText(result.getString(5));
                System.out.println(result.getString(2));
                userName.setText(result.getString(2));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void initialize(){
        showStudentData();
        profile();
        displayImageFromDB();
        updateStudentData();
    }
}