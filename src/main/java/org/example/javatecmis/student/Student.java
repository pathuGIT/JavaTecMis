package org.example.javatecmis.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.Types.NULL;


public class Student{

    private Stage stage;
    private Scene scene;

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
    private Pane CoursePane;
    @FXML
    private Pane HomePanelId;
    @FXML
    private Pane EligibilityPane;
    @FXML
    private Pane GpaPane;
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
    ChoiceBox<String> mychoice;

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TableColumn<Course, String> colId;

    @FXML
    private TableColumn<Course, String> colName;

    @FXML
    private TableColumn<Course, String> colType;

    @FXML
    private TableColumn<Course, Integer> colCredit;

    @FXML
    private TableColumn<Course, String> colLecture;


    private String userSession(){
        LoginController login = new LoginController();
        return login.STDG;
    }

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

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, imagePath);
                pst.setString(2, userSession());
                pst.executeUpdate();
                displayImageFromDB();
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

            PreparedStatement pst = DB.connect().prepareStatement(sql);
            pst.setString(1, userSession());
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
                System.out.println("No image found for the student with ID: " + userSession());
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Student.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @FXML
    void deleteImage(){
        DbConnect DB = new DbConnect();

        try {
            String sql = "update student set Image = NULL where Std_id = '"+userSession()+"'";
            PreparedStatement ptr = DB.connect().prepareStatement(sql);
            ptr.executeUpdate();

            String path = "img/account.png";
            File imageFile = new File(path);
            Image image = new Image(imageFile.toURI().toString());
            circle.setFill(new ImagePattern(image));
            displayImageFromDB();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void updateStudentData() {
        try {
            String sql = "SELECT * FROM student WHERE Std_id = ?";
            DbConnect DB = new DbConnect();


            if(edit_email.getText().isEmpty() && edit_number.getText().isEmpty()){

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, userSession());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    edit_email.setText(rs.getString(3));
                    edit_number.setText(rs.getString(4));
                } else {
                    System.out.println("No Data for the student with ID: " + userSession());
                }

            }else{
                String query = "UPDATE student SET Email = ?, Contact = ? WHERE Std_id = ?";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(1, edit_email.getText());
                pst.setString(2, edit_number.getText());
                pst.setString(3, userSession());
                pst.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    void choosePanel(String  x){
        switch (x){
            case "home":
                HomePanelId.setVisible(true);
                CoursePane.setVisible(false);
                EligibilityPane.setVisible(false);
                GpaPane.setVisible(false);
                ProfilePane.setVisible(false);
                break;
            case "course":
                HomePanelId.setVisible(false);
                CoursePane.setVisible(true);
                EligibilityPane.setVisible(false);
                GpaPane.setVisible(false);
                ProfilePane.setVisible(false);
                break;
            case "eligible":
                HomePanelId.setVisible(false);
                CoursePane.setVisible(false);
                EligibilityPane.setVisible(true);
                GpaPane.setVisible(false);
                ProfilePane.setVisible(false);
                break;
            case "gpa":
                HomePanelId.setVisible(false);
                CoursePane.setVisible(false);
                EligibilityPane.setVisible(false);
                GpaPane.setVisible(true);
                ProfilePane.setVisible(false);
                break;
            case "profile":
                HomePanelId.setVisible(false);
                CoursePane.setVisible(false);
                EligibilityPane.setVisible(false);
                GpaPane.setVisible(false);
                ProfilePane.setVisible(true);
                break;
        }
    }

    @FXML
    void home() {
        choosePanel("home");
        System.out.println(userSession());
    }

    @FXML
    void course(ActionEvent event) {
        choosePanel("course");
    }

    @FXML
    void eligibility(ActionEvent event) { choosePanel("eligible"); }

    @FXML
    void Gpa(ActionEvent event) {
        choosePanel("gpa");
    }

    @FXML
    void profile(){
        choosePanel("profile");
    }

    void showStudentData(){
        try{
            String query = "Select * from student where Std_id = '"+userSession()+"'";

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
        Course o = new Course();
        String value = "Default";

        showStudentData();
        home();
        displayImageFromDB();
        updateStudentData();
        setValueFactory();
        displayCourse(value);
        mychoice.getItems().addAll(o.filter); //Add items to the mychoose box [course]

        mychoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Check if newValue is not null and perform the desired action
            if (newValue != null) {
                displayCourse(newValue);
            }
        });
    }

    public void setValueFactory(){
        colId.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        colType.setCellValueFactory(new PropertyValueFactory<>("CourseType"));
        colCredit.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        colLecture.setCellValueFactory(new PropertyValueFactory<>("CourseLecture"));
    }

    //Get course details from course table and display in the courseTable
    public void displayCourse(String selectedOption) {

        String Id;
        String name;
        String Type;
        int Credit;
        String Lecturer;

        try {
            String query;
            DbConnect conn = new DbConnect();
            PreparedStatement ptr = null;
            switch (selectedOption) {
                case "Default":
                    query = "select c.Crs_id,c.Name,c.Type,c.Credit,l.Lec_id from course c left join lecture l on c.Lec_id = l.Lec_id";
                    ptr = conn.connect().prepareStatement(query);
                    break;
                case "Theory":
                    query = "select c.Crs_id,c.Name,c.Type,c.Credit,l.Lec_id from course c left join lecture l on c.Lec_id = l.Lec_id where Type = 'Theory'";
                    ptr = conn.connect().prepareStatement(query);
                    break;
                case "Practical":
                    query = "select c.Crs_id,c.Name,c.Type,c.Credit,l.Lec_id from course c left join lecture l on c.Lec_id = l.Lec_id where Type = 'Practical'";
                    ptr = conn.connect().prepareStatement(query);
                    break;
                case "Both":
                    query = "select c.Crs_id,c.Name,c.Type,c.Credit,l.Lec_id from course c left join lecture l on c.Lec_id = l.Lec_id where Type = 'Both'";
                    ptr = conn.connect().prepareStatement(query);
                    break;
                // Add cases for other options as needed
                default:
                    System.out.println("Unknown option selected");

            }
            courseTable.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                Id = rs.getString(1);
                name = rs.getString(2);
                Type = rs.getString(3);
                Credit = rs.getInt(4);
                Lecturer = rs.getString(5);

                Course course_record = new Course(Id,name,Type,Credit,Lecturer);
                courseTable.getItems().add(course_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

}