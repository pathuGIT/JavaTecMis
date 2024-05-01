package org.example.javatecmis.lecturer;

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
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.lecturerConnect;
//import org.example.javatecmis.student.Notice;
import org.example.javatecmis.connect.studentConnect;
import org.example.javatecmis.student.Medical;
import org.example.javatecmis.student.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lecCtrl {

    private double xOffset = 0;
    private double yOffset = 0;

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

        //For MidTable
        @FXML
        private TextField midId_forMid;

        @FXML
        private TextField stId_forMid;

        @FXML
        private TextField crsId_forMid;

        @FXML
        private TextField marks_forMid;

        @FXML
        private Label labelMid1;


        //For EndTable
        @FXML
        private TextField endId_forEnd;

        @FXML
        private TextField stdId_forEnd;

        @FXML
        private TextField crsId_forEnd;

        @FXML
        private TextField marks_forEnd;



        @FXML
        private Label labelEnd;


        //For QuizTable
        @FXML
        private TextField quizId_forQuiz;

        @FXML
        private TextField quizNo_forQuiz;

        @FXML
        private TextField marks_forQuiz;

        @FXML
        private TextField stdId_forQuiz;

        @FXML
        private TextField crsId_forQuiz;

        @FXML
        private Label labelQuiz;


        //For AssignmentTable
        @FXML
        private TextField assId_forAssignment;

        @FXML
        private TextField assNo_forAssignment;

        @FXML
        private TextField mark_forAssignment;

        @FXML
        private TextField std_d_forAssignment;

        @FXML
        private TextField crsId_forAssignment;


        @FXML
        private Label labelAssignment;




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
        private TableView<StEligibility> tableEligibility;

        @FXML
        private TableColumn<StEligibility, String> Std_id_Eligibility;

        @FXML
        private TableColumn<StEligibility, String> Crs_id_Eligibility;

        @FXML
        private TableColumn<StEligibility, String> Total_Attendance_Eligibility;

        @FXML
        private TableColumn<StEligibility, String> CA_Mark_Eligibility;

        @FXML
        private TableColumn<StEligibility, String> Eligibility_Eligibility;

        @FXML
        void studentEligibilityAction(ActionEvent event) {
            choosePanel("studentEligibility");
        }

    @FXML
    private Pane resLecPane;
        @FXML
        private TableView<StResults> studentResultTable;

        @FXML
        private TableColumn<StResults, String> Std_id_result;

        @FXML
        private TableColumn<StResults, String> Crs_id_result;

        @FXML
        private TableColumn<StResults, String> Mark_result;

        @FXML
        private TableColumn<StResults, String> Grade_result;

        @FXML
        private TableColumn<StResults, String> SGPA_result;

        @FXML
        private TableColumn<StResults, String> CGPA_result;


        @FXML
        void ResultAction(ActionEvent event) {
            choosePanel("studentResult");
        }

    @FXML
    private Pane noticePane;
        @FXML
        private TableView<LecNotices> noticeTableLec;

        @FXML
        private TableColumn<LecNotices, String> clickCol;

        @FXML
        private TableColumn<LecNotices, String> dateCol;

        @FXML
        private TableColumn<LecNotices, String> noticeCol;

        @FXML
        private TextArea msg;

        @FXML
        private TextField serchcrsId;


        @FXML
        void NoticeAction(ActionEvent event) {
            choosePanel("lectureNotice");
        }


        @FXML
        private Pane updocLecPane;
            @FXML
            private TextField updocMatname;

            @FXML
            private TextField updocCoursecode;

            @FXML
            private Label hidelabel;

            @FXML
            private Button documentUpdateBtn;

            @FXML
            private Button deletedocbtn;

    @FXML
    private Pane medicalPane;

    @FXML
    private TableView<leMedical> medical;

    @FXML
    private TableColumn<leMedical, String > mstatus;

    @FXML
    private TableColumn<leMedical, String> mstdid;

    @FXML
    private TableColumn<leMedical, String> mcsid;

    @FXML
    private TableColumn<leMedical, String> mdate;

    @FXML
    void uploadDocumentsForCourse(ActionEvent event) {
        String docName = updocMatname.getText().trim();
        String courseCode = updocCoursecode.getText().trim();

        // Check if text fields are empty
        if (docName.isEmpty() || courseCode.isEmpty()) {
            hidelabel.setText("Please fill in all fields!");
            return; // Exit method if fields are empty
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Document to Upload");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();

            try {
                lecturerConnect conn = new lecturerConnect();
                String insertQuery = "INSERT INTO lecmaterials (Crs_id, Doc_Name, upload_path) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.connect().prepareStatement(insertQuery);
                pst.setString(1, courseCode);
                pst.setString(2, docName);
                pst.setString(3, filePath);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    hidelabel.setText("Document uploaded successfully!");
                } else {
                    hidelabel.setText("Failed to upload document!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hidelabel.setText("Error: Failed to upload document!");
                // Handle any SQL exceptions
            }
        } else {
            hidelabel.setText("No file selected!");
        }
    }


    @FXML
    void deleteDocument(ActionEvent event) {
        String docNameToDelete = updocMatname.getText(); // Assuming you use the document name to identify the document to delete

        try {
            lecturerConnect conn = new lecturerConnect();
            String deleteQuery = "DELETE FROM lecmaterials WHERE Doc_Name=?";
            PreparedStatement pst = conn.connect().prepareStatement(deleteQuery);
            pst.setString(1, docNameToDelete);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                hidelabel.setText("Document deleted successfully!");
            } else {
                hidelabel.setText("Failed to delete document!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            hidelabel.setText("Error: Failed to delete document!");
            // Handle any SQL exceptions
        }
    }


    @FXML
        void uploadDocumentAction(ActionEvent event) {
            choosePanel("uploadDocuments");
        }


    @FXML
    private Pane homeLecPane;

            @FXML
            private Label l_contact;

            @FXML
            private Label l_email;

            @FXML
            private Label l_id;

            @FXML
            private Label l_name;

            @FXML
            private Label l_coursename;

        @FXML
        void homeAction(ActionEvent event) {
            choosePanel("home");

        }





    private String userSession(){
        LoginController login = new LoginController();
        return login.LETG;
    }

    public void loginToLecturer(ActionEvent event1) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lecturer.fxml")));
        stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();

        scene = new Scene(root);

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
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }

    private String profImagePath = "img/account.png"; // Default path

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
            profImg.setImage(image);

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
                pst.executeUpdate();
                displayImageFromDB();

                // Update the profImagePath variable
                profImagePath = imagePath;
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
            profImg.setImage(image);
            displayImageFromDB();
        }catch (Exception e){
            System.out.println(e);
        }
    }




    //Before edit 1


    @FXML
    public void displayImageFromDB() {
        try {
            // Retrieve the image path from the database for the specific student
            String sql = "SELECT Image FROM lecture WHERE Lec_id = ?";
            lecturerConnect DB = new lecturerConnect();

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
                    l_email.setText(rs.getString(3)); // Update l_email field
                    l_contact.setText(rs.getString(5)); // Update l_contact field
                } else {
                    System.out.println("No Data for the lecture with ID: " + userSession());
                }

            } else {

                String query = "UPDATE lecture SET Email = ?, Contact = ? WHERE Lec_id = ?";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(1, edit_email.getText());
                pst.setString(2, edit_number.getText());
                pst.setString(3, userSession());
                pst.executeUpdate();

                // Update l_email and l_contact
                l_email.setText(edit_email.getText());
                l_contact.setText(edit_number.getText());
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }



    //Inserting Marks for Mid, End, Quiz and Assignment

    @FXML
    void uploadMidMarks(ActionEvent event) {
        String midId, midcrsId, midstdId;
        int midMark;

        midcrsId = crsId_forMid.getText();
        midstdId = stId_forMid.getText();

        if (midcrsId.isEmpty() || midstdId.isEmpty()) {
            labelMid1.setText("All fields are required.");
            return; // Exit the method if any field is empty
        }

        try {
            midMark = Integer.parseInt(marks_forMid.getText());

            String sqlToGetMaxMidId = "SELECT MAX(Mid_id) AS max_mid_id FROM mid";
            String nextMidId = null;

            lecturerConnect conn = new lecturerConnect();
            Statement stmt = conn.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sqlToGetMaxMidId);

            if (rs.next()) {
                String maxMidId = rs.getString("max_mid_id");
                if (maxMidId != null) {
                    // Extract the number part, increment it, and format it
                    int numPart = Integer.parseInt(maxMidId.substring(2)) + 1;
                    nextMidId = "MD" + String.format("%03d", numPart);
                } else {
                    // If there are no existing entries in the table, start with MD001
                    nextMidId = "MD001";
                }
            }

            // Set the generated next Mid_id into the text field
            midId_forMid.setText(nextMidId);

            String sqlToInsertMidMark = "INSERT INTO mid (Mid_id, Crs_id, Mid_mark, Std_id) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.connect().prepareStatement(sqlToInsertMidMark);

            pst.setString(1, nextMidId);
            pst.setString(2, midcrsId);
            pst.setInt(3, midMark);
            pst.setString(4, midstdId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                labelMid1.setText("Data inserted");
            } else {
                labelMid1.setText("Data entering failed!");
            }
        } catch (NumberFormatException e) {
            // Handle parsing error
            labelMid1.setText("Mark should be integer.");
            e.printStackTrace(); // Log the exception
        } catch (SQLException e) {
            // Handle database error
            labelMid1.setText("Error while inserting data.");
            e.printStackTrace(); // Log the exception
        }
    }



    @FXML
    void uploadEndMarks(ActionEvent event) {
        String endId, endcrsId, endstdId;
        int endMark;

        endcrsId = crsId_forEnd.getText();
        endstdId = stdId_forEnd.getText();

        if (endcrsId.isEmpty() || endstdId.isEmpty()) {
            labelEnd.setText("All fields are required.");
            return;
        }

        try {
            endMark = Integer.parseInt(marks_forEnd.getText());

            String sqlToGetMaxEndId = "SELECT MAX(End_id) AS max_end_id FROM end";
            String nextEndId = null;

            lecturerConnect conn = new lecturerConnect();
            Statement stmt = conn.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sqlToGetMaxEndId);

            if (rs.next()) {
                String maxEndId = rs.getString("max_end_id");
                if (maxEndId != null) {
                    // Extract the number part, increment it, and format it
                    int numPart = Integer.parseInt(maxEndId.substring(2)) + 1;
                    nextEndId = "EN" + String.format("%03d", numPart);
                } else {
                    // If there are no existing entries in the table, start with EN001
                    nextEndId = "EN001";
                }
            }

            // Set the generated next End_id into the text field
            endId_forEnd.setText(nextEndId);

            String sqlToInsertEndMark = "INSERT INTO end (End_id, Crs_id, End_marks, Std_id) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.connect().prepareStatement(sqlToInsertEndMark);

            pst.setString(1, nextEndId);
            pst.setString(2, endcrsId);
            pst.setInt(3, endMark);
            pst.setString(4, endstdId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                labelEnd.setText("Data inserted");
            } else {
                labelEnd.setText("Data entering failed!");
            }
        } catch (NumberFormatException e) {
            // Handle parsing error
            labelEnd.setText("Marks should be integer.");
            e.printStackTrace(); // Log the exception
        } catch (SQLException e) {
            // Handle database error
            labelEnd.setText("Error while inserting data.");
            e.printStackTrace(); // Log the exception
        }
    }


    @FXML
    void uploadQuizMarks(ActionEvent event) {
        String quizId, quizcrsId, quizstdId;
        int quizMark, quizNo;

        quizcrsId = crsId_forQuiz.getText();
        quizstdId = stdId_forQuiz.getText();

        if (quizcrsId.isEmpty() || quizstdId.isEmpty()) {
            labelQuiz.setText("All fields are required.");
            return;
        }

        try {
            quizMark = Integer.parseInt(marks_forQuiz.getText());
            quizNo = Integer.parseInt(quizNo_forQuiz.getText());

            String sqlToGetMaxQuizId = "SELECT MAX(Quiz_id) AS max_quiz_id FROM quiz";
            String nextQuizId = null;

            lecturerConnect conn = new lecturerConnect();
            Statement stmt = conn.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sqlToGetMaxQuizId);

            if (rs.next()) {
                String maxQuizId = rs.getString("max_quiz_id");
                if (maxQuizId != null) {
                    // Extract the number part, increment it, and format it
                    int numPart = Integer.parseInt(maxQuizId.substring(1)) + 1;
                    nextQuizId = "Q" + String.format("%03d", numPart);
                } else {
                    // If there are no existing entries in the table, start with Q001
                    nextQuizId = "Q001";
                }
            }

            // Set the generated next Quiz_id into the text field
            quizId_forQuiz.setText(nextQuizId);

            String sqlToInsertQuizMark = "INSERT INTO quiz (Quiz_id, Qiz_no, Qiz_mark, Std_id, Crs_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.connect().prepareStatement(sqlToInsertQuizMark);

            pst.setString(1, nextQuizId);
            pst.setInt(2, quizNo);
            pst.setInt(3, quizMark);
            pst.setString(4, quizstdId);
            pst.setString(5, quizcrsId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                labelQuiz.setText("Data inserted");
            } else {
                labelQuiz.setText("Data entering failed!");
            }
        } catch (NumberFormatException e) {
            // Handle parsing error
            labelQuiz.setText("Marks should be integer.");
            e.printStackTrace(); // Log the exception
        } catch (SQLException e) {
            // Handle database error
            labelQuiz.setText("Error while inserting data.");
            e.printStackTrace(); // Log the exception
        }
    }

    @FXML
    void uploadAssignmentMarks(ActionEvent event) {
        String AsmId, AsmcrsId, AsmstdId;
        int AsmMark, AsmNo;

        AsmcrsId = crsId_forAssignment.getText();
        AsmstdId = std_d_forAssignment.getText();

        if (AsmcrsId.isEmpty() || AsmstdId.isEmpty()) {
            labelAssignment.setText("All fields are required.");
            return;
        }

        try {
            AsmMark = Integer.parseInt(mark_forAssignment.getText());
            AsmNo = Integer.parseInt(assNo_forAssignment.getText());

            String sqlToGetMaxAsmId = "SELECT MAX(Asm_id) AS max_asm_id FROM assignment";
            String nextAsmId = null;

            lecturerConnect conn = new lecturerConnect();
            Statement stmt = conn.connect().createStatement();
            ResultSet rs = stmt.executeQuery(sqlToGetMaxAsmId);

            if (rs.next()) {
                String maxAsmId = rs.getString("max_asm_id");
                if (maxAsmId != null) {
                    // Extract the number part, increment it, and format it
                    int numPart = Integer.parseInt(maxAsmId.substring(2)) + 1;
                    nextAsmId = "AS" + String.format("%03d", numPart);
                } else {
                    // If there are no existing entries in the table, start with AS001
                    nextAsmId = "AS001";
                }
            }

            // Set the generated next Asm_id into the text field
            assId_forAssignment.setText(nextAsmId);

            String sqlToInsertAssignmentMark = "INSERT INTO assignment (Asm_id, Asm_no, Asm_mark, Std_id, Crs_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.connect().prepareStatement(sqlToInsertAssignmentMark);

            pst.setString(1, nextAsmId);
            pst.setInt(2, AsmNo);
            pst.setInt(3, AsmMark);
            pst.setString(4, AsmstdId);
            pst.setString(5, AsmcrsId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                labelAssignment.setText("Data inserted");
            } else {
                labelAssignment.setText("Data entering failed!");
            }
        } catch (NumberFormatException e) {
            // Handle parsing error
            labelAssignment.setText("Mark should be integer.");
            e.printStackTrace(); // Log the exception
        } catch (SQLException e) {
            // Handle database error
            labelAssignment.setText("Error while inserting data.");
            e.printStackTrace(); // Log the exception
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
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
                medicalPane.setVisible(false);
                break;

            case "medical":
                homeLecPane.setVisible(false);
                profileLecPane.setVisible(false);
                updocLecPane.setVisible(false);
                stuDetLecPane.setVisible(false);
                stuElLecPane.setVisible(false);
                resLecPane.setVisible(false);
                noticePane.setVisible(false);
                upmarksLecPane.setVisible(false);
                medicalPane.setVisible(true);
                ShowMedical("Default");
                break;

        }
    }

    public String COURSE;
    @FXML
    public void medicalShow(ActionEvent event){
        choosePanel("medical");
    }

    @FXML
    void mSearch(ActionEvent event) {
        String crs_id = serchcrsId.getText();
        //String query = "select * from medical where std_id = ?";
        ShowMedical(crs_id);
    }

    void ShowMedical(String getCrs_id) {
        String st_id;
        String crs_id;
        String date;
        String status;
        String query;
        try {
            lecturerConnect conn = new lecturerConnect();
            PreparedStatement ptr = null;
            if(getCrs_id == "Default"){
                query = "select * from medical where crs_id = ?";
                ptr = conn.connect().prepareStatement(query);
                ptr.setString(1,COURSE);
            }else{
                query = "select * from medical where crs_id = ? and std_id = ?";
                ptr = conn.connect().prepareStatement(query);
                ptr.setString(1,COURSE);
                ptr.setString(2,serchcrsId.getText());
            }

            medical.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
                st_id = rs.getString(1);
                crs_id = rs.getString(2);
                date = rs.getString(3);
                status = rs.getString(4);
                leMedical med_record = new leMedical(st_id,crs_id,date,status);
                medical.getItems().add(med_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    void showLectureDetails(){
        try{
            String query = "SELECT * FROM lecture where Lec_id = '"+userSession()+"'";
            String query2 = "SELECT course.Name FROM course JOIN lecture ON course.Lec_id = lecture.Lec_id WHERE lecture.Lec_id ='"+userSession()+"' LIMIT 1";
            lecturerConnect connect = new lecturerConnect();
            PreparedStatement ptr = connect.connect().prepareStatement(query);
            PreparedStatement ptr2 = connect.connect().prepareStatement(query2);

            ResultSet result = ptr.executeQuery();
            ResultSet result2 = ptr2.executeQuery();
            while(result.next()){
                l_id.setText(result.getString(1));
                l_name.setText(result.getString(2));
                l_email.setText(result.getString(3));
                l_contact.setText((result.getString(5)));
                profName.setText(result.getString(2));


            }
            while(result2.next()){
                l_coursename.setText(result2.getString(1));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }






    public void setValueFactory(){
        //For student details
        Std_id_Details.setCellValueFactory(new PropertyValueFactory<>("Stid"));
        Name_Details.setCellValueFactory(new PropertyValueFactory<>("Sname"));
        Email_Details.setCellValueFactory(new PropertyValueFactory<>("Semail"));
        Contact_Details.setCellValueFactory(new PropertyValueFactory<>("Scontact"));
        NIC_Details.setCellValueFactory(new PropertyValueFactory<>("Snic"));

        //For student eligibility
        Std_id_Eligibility.setCellValueFactory(new PropertyValueFactory<>("Stdid"));
        Crs_id_Eligibility.setCellValueFactory(new PropertyValueFactory<>("Crsid"));
        Total_Attendance_Eligibility.setCellValueFactory(new PropertyValueFactory<>("Totalattendance"));
        CA_Mark_Eligibility.setCellValueFactory(new PropertyValueFactory<>("Camarks"));
        Eligibility_Eligibility.setCellValueFactory(new PropertyValueFactory<>("Eligibility"));

        //For student Result
        Std_id_result.setCellValueFactory(new PropertyValueFactory<>("Sid"));
        Crs_id_result.setCellValueFactory(new PropertyValueFactory<>("Cid"));
        Mark_result.setCellValueFactory(new PropertyValueFactory<>("TotMark"));
        Grade_result.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        SGPA_result.setCellValueFactory(new PropertyValueFactory<>("Sgpa"));
        CGPA_result.setCellValueFactory(new PropertyValueFactory<>("Cgpa"));

        //For lecture notices
        noticeCol.setCellValueFactory(new PropertyValueFactory<>("Notice"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
        clickCol.setCellValueFactory(new PropertyValueFactory<>("View"));


        mstdid.setCellValueFactory(new PropertyValueFactory<>("Std_id"));
        mcsid.setCellValueFactory(new PropertyValueFactory<>("Crs_id"));
        mdate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        mstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }

    void showStudentDetails(){

        String stid;
        String sname;
        String semail;
        String scontact;
        String snic;

        try{
            lecturerConnect conn = new lecturerConnect();
            String Query = "SELECT s.Std_id,s.Name,s.Email,s.Contact,s.NIC FROM student s JOIN Mark m ON s.Std_id = m.Std_id JOIN course c ON m.Crs_id = c.Crs_id WHERE c.Lec_id = '" + userSession() + "'";
            PreparedStatement ptr = conn.connect().prepareStatement(Query);

            stuDetTable.getItems().clear();
            ResultSet rs = ptr.executeQuery(Query);


            while(rs.next()){
                stid = rs.getString(1);
                sname = rs.getString(2);
                semail = rs.getString(3);
                scontact = rs.getString(4);
                snic = rs.getString(5);

                //System.out.println(stid+sname+semail+scontact+snic);
                StDetails rec = new StDetails(stid,sname,semail,scontact,snic);
                stuDetTable.getItems().add(rec);
            }


        }catch(Exception e){
            System.out.println(e);

        }
    }

    void ShowStudentResults() {
        String studentid;
        String courseid;
        String marks;
        String grade;
        String sgpa;
        String cgpa;

        try{
            lecturerConnect conn = new lecturerConnect();
            String que = "SELECT m.Std_id,m.Crs_id, m.Total_Mark, m.Grade, sg.SGPA, cg.CGPA FROM Mark m JOIN course c On m.Crs_id = c.Crs_id LEFT JOIN student_sgpa sg ON m.Std_id = sg.Std_id LEFT JOIN student_cgpa cg ON m.Std_id = cg.Std_id WHERE c.Lec_id = '" + userSession() + "'";
            PreparedStatement ptr = conn.connect().prepareStatement(que);

            studentResultTable.getItems().clear();
            ResultSet rs = ptr.executeQuery(que);

            while(rs.next()){
                studentid = rs.getString(1);
                courseid = rs.getString(2);
                marks  = rs.getString(3);
                grade = rs.getString(4);
                sgpa = rs.getString(5);
                cgpa = rs.getString(6);

                //System.out.println(studentid+"\t"+courseid+"\t"+marks+"\t"+grade+"\t"+sgpa+"\t"+cgpa);
                StResults record = new StResults(studentid,courseid,marks,grade,sgpa,cgpa);
                studentResultTable.getItems().add(record);
            }
        }catch(Exception err){
            System.out.println(err);
        }
    }


    public void ShowStudentEligibility(){
        String stdid;
        String crsid;
        String stdtotatt;
        String stdcamark;
        String stdelegi;

        try{
            lecturerConnect conn = new lecturerConnect();
            String sqlQuery = "SELECT e.Std_id,e.Crs_id,e.Total_Attendance,e.CA_Mark,e.Eligibility FROM eligibility e INNER JOIN course c ON e.Crs_id = c.Crs_id WHERE c.Lec_id = '" + userSession() + "'";
            PreparedStatement ptr = conn.connect().prepareStatement(sqlQuery);

            tableEligibility.getItems().clear();
            ResultSet resultset = ptr.executeQuery(sqlQuery);

            while(resultset.next()){
                COURSE = resultset.getString(2);
                stdid = resultset.getString(1);
                crsid = resultset.getString(2);
                stdtotatt = resultset.getString(3);
                stdcamark = resultset.getString(4);
                stdelegi = resultset.getString(5);

                //System.out.println(stdid+crsid+stdtotatt+stdcamark+stdelegi);
                StEligibility record = new StEligibility(stdid,crsid,stdtotatt,stdcamark,stdelegi);
                tableEligibility.getItems().add(record);
            }
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public void showLecNotice(){

        String date;
        String notice;
        String view;
        String id;

        try {
            lecturerConnect conn = new lecturerConnect();
            PreparedStatement ptr = null;
            String query = "SELECT * FROM notice ORDER BY date DESC";
            ptr = conn.connect().prepareStatement(query);

            noticeTableLec.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                date = rs.getString(4);
                notice = rs.getString(2);
                view = "View";
                id = rs.getString(1);
                LecNotices notice_record = new LecNotices(date,notice,view,id,msg);
                noticeTableLec.getItems().add(notice_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }



    public void initialize(){
        System.out.println(userSession());
        showLectureDetails();
        showStudentDetails();
        ShowStudentResults();
        ShowStudentEligibility();
        setValueFactory();
        showLecNotice();
        displayImageFromDB();
        ShowMedical("Default");



    }
}
