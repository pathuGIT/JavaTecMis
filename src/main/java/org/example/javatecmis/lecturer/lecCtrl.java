package org.example.javatecmis.lecturer;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.lecturerConnect;
import org.example.javatecmis.connect.studentConnect;
import org.example.javatecmis.student.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;

import java.io.IOException;
import java.util.Objects;


public class lecCtrl {
    private Stage stage;
    private Scene scene;


    //For Panes
    @FXML
    private Pane ProfileDetailsPane;

        @FXML
        private ImageView profImg;

        @FXML
        private Label profName;

        @FXML
        private Button lecprofileBtn;
        @FXML
        void LectureProfile(ActionEvent event) {

        }

        @FXML
        private Button noticeBtn;
        @FXML
        void Notice(ActionEvent event) {

        }
    @FXML
    private Pane profileLecPane;

        @FXML
        private Circle circle;

        @FXML
        private Button profileUploadBtn;


        @FXML
        private TextField edit_email;

        @FXML
        private TextField edit_number;


        @FXML
        void LectureProfileAction(ActionEvent event) {
            choosePanel("lectureProfile");
        }

    @FXML
    private Pane upmarksLecPane;

        @FXML
        void uploadMarksAction(ActionEvent event) {
            choosePanel("uploadMarks");
        }

        //For Shoe student Details
    @FXML
    private Pane stuDetLecPane;
        @FXML
        private TableView<StDetails> stuDetTable;
        @FXML
        private TableColumn<StDetails, String> Std_id_Details;
        @FXML
        private TableColumn<StDetails, String> Name_Details;
        @FXML
        private TableColumn<StDetails, String> Email_Details;
        @FXML
        private TableColumn<StDetails, String> Contact_Details;
        @FXML
        private TableColumn<StDetails, String> NIC_Details;



    @FXML
    void studentDetailsAction(ActionEvent event) {
        choosePanel("studentDetails");
    }

    @FXML
    private Pane stuElLecPane;

        @FXML
        private TableView<?> tableEligibility;

        @FXML
        private TableColumn<?, ?> Std_id_Eligibility;

        @FXML
        private TableColumn<?, ?> Crs_id_Eligibility;

        @FXML
        private TableColumn<?, ?> Total_Attendance_Eligibility;

        @FXML
        private TableColumn<?, ?> CA_Mark_Eligibility;

        @FXML
        private TableColumn<?, ?> Eligibility_Eligibility;

        @FXML
        void studentEligibilityAction(ActionEvent event) {
            choosePanel("studentEligibility");
        }

    @FXML
    private Pane resLecPane;
//        @FXML
//        private TableView<DataResult> studentResultTable;

        @FXML
        private TableColumn<DataResult, String> Std_id_result;

        @FXML
        private TableColumn<DataResult, String> Crs_id_result;

        @FXML
        private TableColumn<DataResult, Integer> Mark_result;

        @FXML
        private TableColumn<DataResult, String> Grade_result;

        @FXML
        private TableColumn<DataResult, Double> SGPA_result;

        @FXML
        private TableColumn<DataResult, Double> CGPA_result;

    public class DataResult {
        private String stdId;
        private String crsId;
        private Integer totalMark;
        private String grade;
        private Double sgpa;
        private Double cgpa;

        public DataResult(String stdId, String crsId, Integer totalMark, String grade, Double sgpa, Double cgpa) {
            this.stdId = stdId;
            this.crsId = crsId;
            this.totalMark = totalMark;
            this.grade = grade;
            this.sgpa = sgpa;
            this.cgpa = cgpa;
        }

        public String getStdId() {
            return stdId;
        }

        public void setStdId(String stdId) {
            this.stdId = stdId;
        }

        public String getCrsId() {
            return crsId;
        }

        public void setCrsId(String crsId) {
            this.crsId = crsId;
        }

        public Integer getTotalMark() {
            return totalMark;
        }

        public void setTotalMark(Integer totalMark) {
            this.totalMark = totalMark;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public Double getSgpa() {
            return sgpa;
        }

        public void setSgpa(double sgpa) {
            this.sgpa = Double.valueOf(sgpa);
        }

        public Double getCgpa() {
            return cgpa;
        }

        public void setCgpa(double cgpa) {
            this.cgpa = Double.valueOf(cgpa);
        }

        public Double getSGPA() {
            return sgpa;
        }

        public Double getCGPA() {
            return cgpa;
        }

        // Constructor, getters, and setters
    }
        @FXML
        void ResultAction(ActionEvent event) {
            choosePanel("studentResult");
        }

    @FXML
    private Pane noticePane;
        @FXML
        private TableView<?> noticeTable;

        @FXML
        private TableColumn<?, ?> clickCol;

        @FXML
        private TableColumn<?, ?> dateCol;

        @FXML
        private TableColumn<?, ?> noticeCol;

        @FXML
        private TextArea msg;

        @FXML
        void NoticeAction(ActionEvent event) {
            choosePanel("lectureNotice");
        }

    @FXML
    private Pane updocLecPane;
        @FXML
        private Button documentUpdateBtn;

        @FXML
        void uploadDocumentsForCourse(ActionEvent event) {

        }

        @FXML
        private Button docDeleteBtn;

        @FXML
        void deleteDocumentsInCourse(ActionEvent event) {

        }

        @FXML
        void uploadDocumentAction(ActionEvent event) {
            choosePanel("uploadDocuments");
        }


    @FXML
    private Pane homeLecPane;
        @FXML
        private HBox HboxForLec_contact;
            @FXML
            private Label l_contact;

        @FXML
        private HBox HboxForLec_email;
            @FXML
            private Label l_email;

        @FXML
        private HBox HboxForLec_id;
            @FXML
            private Label l_id;

        @FXML
        private HBox HboxForLec_name;
            @FXML
            private Label l_name;

        @FXML
        void homeAction(ActionEvent event) {
            choosePanel("home");

        }


    //For ButtonPane
    @FXML
    private Pane ButtonPane;

        @FXML
        private HBox navicontent;

    @FXML
    private Button homeBtn;

    @FXML
    private Button updocBtn;

    @FXML
    private Button upmarksBtn;

    @FXML
    private Button stdetBtn;

    @FXML
    private Button stelBtn;

    @FXML
    private Button resultBtn;

    @FXML
    private Button logoutbtn;






/*
=======
>>>>>>> main
=======
>>>>>>> 3c085d5215363e64ee3fcce5b2c3326ba43f039d
    @FXML
    private Label l;
    @FXML
    void btn(ActionEvent event) {
        l.setText("Kamal");
    }
<<<<<<< HEAD
<<<<<<< HEAD
*/

    private String userSession(){
        LoginController login = new LoginController();
        return login.LETG;
    }

    public void loginToLecturer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lecturer.fxml")));
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
    void imgUpload(ActionEvent event)throws IOException, SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files","*.png", "*.jpg", "*.gif")
        );

        File selectdFile = fileChooser.showOpenDialog(null);
        if (selectdFile != null){
            //Fill the image with selected one
            Image image = new Image(selectdFile.toURI().toString());
            circle.setFill(new ImagePattern(image));

            //save the selected image to img folder
            File imgFolder = new File("img");
            if(!imgFolder.exists()){
                imgFolder.mkdirs();
            }

            File destinationFile = new File(imgFolder,selectdFile.getName());
            Files.copy(selectdFile.toPath(),destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            String imagePath = "img/"+selectdFile.getName();
            String sqlForUpdateImage = "Update lecture SET Image = ? Where Lec_id = ?";

            try{
                lecturerConnect DB = new lecturerConnect();
                PreparedStatement pst = DB.connect().prepareStatement(sqlForUpdateImage);
                pst.setString(1,imagePath);
                pst.setString(2,userSession());
                pst.executeQuery();
                //dislayImageFromDB();
            }catch(SQLException ex){
                Logger lgr = Logger.getLogger(lecCtrl.class.getName());
                lgr.log(Level.SEVERE,ex.getMessage(),ex);
            }
        }
    }
    @FXML
    void deleteImage(ActionEvent event) {
        lecturerConnect DB = new lecturerConnect();
        try {
            String sql = "update lecture set Image = NULL where Lec_id = '"+userSession()+"'";
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
    public void displayImageFromDB() {
        try {
            // Retrieve the image path from the database for the specific student
            String sql = "SELECT Image FROM student WHERE Std_id = ?";
            studentConnect DB = new studentConnect();

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
                        profImg.setImage(new ImagePattern(image).getImage());
                    } else {
                        System.out.println("Image file not found: " + absoluteImagePath);
                    }
                }else{
                    String path = "img/account.png";
                    File imageFile = new File(path);
                    Image image = new Image(imageFile.toURI().toString());
                    circle.setFill(new ImagePattern(image));
                    profImg.setImage(new ImagePattern(image).getImage());
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
    void updateLectureData(ActionEvent event) {
        try {
            String sql = "SELECT * FROM lecture WHERE Lec_id = ?";
            lecturerConnect DB = new lecturerConnect();


            if(edit_email.getText().isEmpty() && edit_number.getText().isEmpty()){

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, userSession());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    edit_email.setText(rs.getString(3));
                    edit_number.setText(rs.getString(5));
                } else {
                    System.out.println("No Data for the lecture with ID: " + userSession());
                }

            }else{
                String query = "UPDATE lecture SET Email = ?, Contact = ? WHERE Lec_id = ?";

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




    void choosePanel(String x){
        switch (x){
            case "home":
                homeLecPane.setVisible(true);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "uploadDocuments":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(true);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "uploadMarks":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(true);
                break;

            case "studentDetails":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(true);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "studentEligibility":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(true);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "studentResult":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(true);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "lectureProfile":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(true);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                break;

            case "lectureNotice":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(true);
                upmarksLecPane.setVisible(false);
                break;

        }
    }

    void showLectureDetails(){
        try{
            String query = "SELECT * FROM lecture where Lec_id = '"+userSession()+"'";
            lecturerConnect connect = new lecturerConnect();
            PreparedStatement ptr = connect.connect().prepareStatement(query);
            ResultSet result = ptr.executeQuery();

            while(result.next()){
                l_id.setText(result.getString(1));
                l_name.setText(result.getString(2));
                l_email.setText(result.getString(3));
                l_contact.setText((result.getString(5)));
                profName.setText(result.getString(2));

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void ShowStudentResults(){

        try {
            System.out.println("Executing ShowStudentResults method...");
            String resultQuery = "SELECT m.Std_id,m.Crs_id, m.Total_Mark, m.Grade, sg.SGPA, cg.CGPA FROM Mark m JOIN course c On m.Crs_id = c.Crs_id LEFT JOIN student_sgpa sg ON m.Std_id = sg.Std_id LEFT JOIN student_cgpa cg ON m.Std_id = cg.Std_id WHERE c.Lec_id = '" + userSession() + "'";
            System.out.println("Query: " + resultQuery); // Print the SQL query being executed
            lecturerConnect connect = new lecturerConnect();
            PreparedStatement ptr = connect.connect().prepareStatement(resultQuery);
            ResultSet result = ptr.executeQuery();

            ObservableList<DataResult> studentRes = FXCollections.observableArrayList();
            System.out.println("Std_id\tCrs_id\tTotal_Mark\tGrade\tSGPA\tCGPA");
            while (result.next()) {
                DataResult std = new DataResult(
                        result.getString("Std_id"),//"Std_id"
                        result.getString("Crs_id"),//"Crs_id"
                        result.getInt("Total_Mark"),//"Total_Mark"
                        result.getString("Grade"),//"Grade"
                        result.getDouble("SGPA"),//"SGPA"
                        result.getDouble("CGPA")//"CGPA"
                );

                studentRes.add(std);
               // studentResultTable.setItems(studentRes); commented 4.22


                // Print each row's data
                System.out.println(std.getStdId() + "\t" + std.getCrsId() + "\t" + std.getTotalMark() + "\t" + std.getGrade() + "\t" + std.getSGPA() + "\t" + std.getCGPA());
            }

            System.out.println("Student results retrieved: " + studentRes.size()); // Print the number of student results retrieved

            Platform.runLater(() -> {
                //studentResultTable.setItems(studentRes); commented 4.22
               // studentResultTable.refresh(); commented 4.22
            });
        } catch(Exception ex){
            ex.printStackTrace();


        }
    }


    public void setValueFactory(){
        Std_id_Details.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        Name_Details.setCellValueFactory(new PropertyValueFactory<>("Sname"));
        Email_Details.setCellValueFactory(new PropertyValueFactory<>("Semail"));
        Contact_Details.setCellValueFactory(new PropertyValueFactory<>("Scontact"));
        NIC_Details.setCellValueFactory(new PropertyValueFactory<>("Snic"));

    }

    void showStudentDetails(){

        String stid;
        String sname;
        String semail;
        String scontact;
        String snic;

        try{
            lecturerConnect conn = new lecturerConnect();
            String Query = "SELECT s.Std_id,s.Name,s.Email,s.Contact,s.NIC FROM student s JOIN Mark m ON s.Std_id = m.Std_id JOIN course c ON m.Crs_id = c.Crs_id WHERE c.Lec_id = '" + userSession() + "'";;
            PreparedStatement ptr = conn.connect().prepareStatement(Query);

            stuDetTable.getItems().clear();
            ResultSet rs = ptr.executeQuery(Query);


            while(rs.next()){
                stid = rs.getString(1);
                sname = rs.getString(2);
                semail = rs.getString(3);
                scontact = rs.getString(4);
                snic = rs.getString(5);

                System.out.println(stid+sname+semail+scontact+snic);
                StDetails rec = new StDetails(stid,sname,semail,scontact,snic);
                stuDetTable.getItems().add(rec);
            }


        }catch(Exception e){
            System.out.println(e);

        }
    }






    public void initialize(){
        System.out.println(userSession());
        showLectureDetails();
        showStudentDetails();
        ShowStudentResults();
        setValueFactory();

    }



}
