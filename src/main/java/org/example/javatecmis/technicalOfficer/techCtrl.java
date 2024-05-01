package org.example.javatecmis.technicalOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.lecturerConnect;
import org.example.javatecmis.connect.studentConnect;
import org.example.javatecmis.connect.techConnect;
import org.example.javatecmis.student.Attendance;
import org.example.javatecmis.student.Notice;
import org.example.javatecmis.student.Student;
import org.example.javatecmis.student.Timetable;

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

public class techCtrl {

    private double xOffset = 0;
    private double yOffset = 0;
    private Stage stage;
    private Scene scene;
    String passName;

    @FXML
    private Label l;
    @FXML
    private Pane TimetablePane;
    @FXML
    private Pane attendplane;
    @FXML
    private TableView<Attendancetec>attentable;
    @FXML
    private TableColumn<Attendancetec, String>recol;
    @FXML
    private TableColumn<Attendancetec, String>cousecol;
    @FXML
    private TableColumn<Attendancetec, String>countcol;
    @FXML
    private TableColumn<Attendancetec, String>aidcol;
    @FXML
    private TextField r_num;
    @FXML
    private TextField c_num;
    @FXML
    private TextField co_num;
    @FXML
    private TextField ai_num;
    @FXML
    private TextField registernum;


    @FXML
    private Pane homePane;
    @FXML
    private HBox hboxofficerid;
    @FXML
    private Label officerid;

    @FXML
    private HBox hboxofficername;
    @FXML
    private Label officername;

    @FXML
    private HBox hboxofficercontact;
    @FXML
    private Label officercontat;

    @FXML
    private HBox hboxofficermail;
    @FXML
    private Label officermail;

    @FXML
    private Pane noticepane;
    @FXML
    private Pane profilePane;
    @FXML
    private TextField upemail;
    @FXML
    private TextField upcontact;
    @FXML
    private Circle circle;
    @FXML
    private Circle userImg;
    @FXML
    private TextField updateTOprofile;
    @FXML
    private TableView<Notice> noticeTable;
    @FXML
    private TableColumn<Notice , String> clickCol;
    @FXML
    private TableColumn<Notice , String> dateCol;
    @FXML
    private TableColumn<Notice , String> noticeCol;
    @FXML
    private TextArea msg;

    @FXML
    private TableView<Timetable> timeTable;
    @FXML
    private TableColumn<Timetable, String> timeDepCol;
    @FXML
    private TableColumn<Timetable, String> timeDowCol;
    @FXML
    Button dwnld;
    @FXML
    private Label Tmsg;
    @FXML
    private  Label attendlable;
    @FXML
    private Label notyup;
    @FXML
    private Label passname;
    @FXML
    private Pane medicalPane;


    @FXML
    void btn(ActionEvent event) {
        l.setText("Kamal");
    }

    public void loginToTechofficer(ActionEvent event1) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("techOfficer.fxml")));
        stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("technical.css").toExternalForm());


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

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }

     private String userSession(){
           LoginController login = new LoginController();
          return login.offtg;
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
    @FXML
    void AddMedical(ActionEvent event){
        choosePanel("medical");
    }

    void choosePanel(String  x){
        switch (x){
            case "home":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(true);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                medicalPane.setVisible(false);

                break;
            case "attendance":
                TimetablePane.setVisible(false);
                attendplane.setVisible(true);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                medicalPane.setVisible(false);
                showAttendancetec();
                break;
            case "timetable":
                TimetablePane.setVisible(true);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                medicalPane.setVisible(false);
                break;
            case "profile":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(true);
                medicalPane.setVisible(false);
                break;
            case "notice":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(true);
                profilePane.setVisible(false);
                medicalPane.setVisible(false);
                break;
            case "medical":
                TimetablePane.setVisible(false);
                attendplane.setVisible(false);
                homePane.setVisible(false);
                noticepane.setVisible(false);
                profilePane.setVisible(false);
                medicalPane.setVisible(true);
                break;
        }
    }
public void setValueFactory(){
    dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
    noticeCol.setCellValueFactory(new PropertyValueFactory<>("Notice"));
    clickCol.setCellValueFactory(new PropertyValueFactory<>("View"));
    timeDepCol.setCellValueFactory(new PropertyValueFactory<>("Department"));
    timeDowCol.setCellValueFactory(new PropertyValueFactory<>("Dwnld"));
    recol.setCellValueFactory(new PropertyValueFactory<>("TGnum"));
    cousecol.setCellValueFactory(new PropertyValueFactory<>("Course"));
    countcol.setCellValueFactory(new PropertyValueFactory<>("Count"));
    aidcol.setCellValueFactory(new PropertyValueFactory<>("Attid"));


}


    public void initialize(){
        showNotice();
        setValueFactory();
        showTimetable();
        officerhome();
        updateTOprofile();
        displayImageFromDB();
        showAttendancetec();
        passname.setText(passName);
    }

    @FXML
    private Label err;

    @FXML
    private TextField mdate;

    @FXML
    private TextField msid;

    @FXML
    private TextField csid;

    @FXML
    private TextField mststus;

    @FXML
    public void Add(ActionEvent event){
        try{
            techConnect conn = new techConnect();
            String query = "INSERT INTO medical (std_id, crs_id, date, medical_status) VALUES (?, ?,?,?)";
            PreparedStatement ptr = conn.connect().prepareStatement(query);
            ptr.setString(1,msid.getText());
            ptr.setString(2,csid.getText());
            ptr.setString(3,mdate.getText());
            ptr.setString(4,mststus.getText());
            ptr.executeUpdate();
            err.setText("Medical Add Successfull!!");

        }catch (Exception e){
            err.setText("Something wrong!!");
        }
    }

    @FXML
    public void clear(ActionEvent event){
        try{
            msid.setText("");
            csid.setText("");
            mdate.setText("");
            mststus.setText("");

        }catch (Exception e){
            err.setText("Something wrong!!");
        }
    }

    void showAttendancetec(){
        System.out.println("Hello att");
        String tgnum;
        String course;
        String count;
        String attid;
        try {
            techConnect conn = new techConnect();
            String query = "SELECT * FROM attendance ";
            PreparedStatement ptr = conn.connect().prepareStatement(query);

            attentable.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                tgnum = rs.getString(3);
                course = rs.getString(4);
                count = rs.getString(2);
                attid = rs.getString(1);
                Attendancetec att_record = new Attendancetec(tgnum,course,count,attid);
                attentable.getItems().add(att_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void tgviweattendance(){
        String tgnum;
        String course;
        String count;
        String attid;

        try{
            String sql = "SELECT * FROM attendance WHERE Std_id = ?";
            techConnect DB = new techConnect();

            PreparedStatement pst = DB.connect().prepareStatement(sql);
            pst.setString(1,registernum.getText());
            ResultSet r = pst.executeQuery();

            attentable.getItems().clear();
//            ResultSet r = pst.executeQuery();

            while (r.next()) {
                tgnum = r.getString(3);
                course = r.getString(4);
                count = r.getString(2);
                attid = r.getString(1);
                Attendancetec att_record = new Attendancetec(tgnum,course,count,attid);
                attentable.getItems().add(att_record);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void addattendance(){
        try {
            String sql = "SELECT * FROM attendance WHERE A_id = ?";
            techConnect DB = new techConnect();


            if(r_num.getText().isEmpty() && c_num.getText().isEmpty()&& co_num.getText().isEmpty()&& ai_num.getText().isEmpty()){

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1,ai_num.getText());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    ai_num.setText(rs.getString(1));
                    r_num.setText(rs.getString(3));
                    c_num.setText(rs.getString(4));
                    co_num.setText(rs.getString(2));

                } else {
                    System.out.println("No Data for the student with ID: " + ai_num);
                }

            }else{
                String query = "UPDATE attendance SET Count = ?, Std_id = ? ,Crs_id = ? WHERE A_id = ?";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(1, co_num.getText());
                pst.setString(2, r_num.getText());
                pst.setString(3, c_num.getText());
                pst.setString(4, ai_num.getText());
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    attendlable.setText("Successfully updated.");
                } else {
                    attendlable.setText("No records updated.");
                }
                //pst.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void insertattendance(){
        try {
            String sql = "SELECT * FROM attendance WHERE A_id = ?";
            techConnect DB = new techConnect();


            if(r_num.getText().isEmpty() && c_num.getText().isEmpty()&& co_num.getText().isEmpty()&& ai_num.getText().isEmpty()){

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1,ai_num.getText());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    ai_num.setText(rs.getString(1));
                    r_num.setText(rs.getString(3));
                    c_num.setText(rs.getString(4));
                    co_num.setText(rs.getString(2));

                } else {
                    System.out.println("No Data for the student with ID: " + ai_num);
                }

            }else{
                String query = "INSERT INTO attendance (A_id,Count,Std_id,Crs_id) VALUES  (  ?,  ? ,  ? , ?)";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(2, co_num.getText());
                pst.setString(3, r_num.getText());
                pst.setString(4,c_num.getText());
                pst.setString(1,ai_num.getText());
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    attendlable.setText("Successfully updated.");
                } else {
                    attendlable.setText("No records updated.");
                }
                pst.executeUpdate();
            }

        }catch(Exception e){
            System.out.println(e);

        }
    }
    @FXML
    void updateTOprofile(){
        System.out.println("call");
        System.out.println(userSession());
        try {
            String sql = "SELECT * FROM technical_officer WHERE ID = ?";
            techConnect DB = new techConnect();


            if(upemail.getText().isEmpty() && upcontact.getText().isEmpty()){
                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, userSession());
                ResultSet rs = pst.executeQuery();

                if(rs.next()) {
                    upemail.setText(rs.getString(6));
                    upcontact.setText(rs.getString(5));

                } else {
                    System.out.println("No Data for the student with ID: " + userSession());
                }

            }else{
                System.out.println("else");
                String query = "UPDATE technical_officer SET Email = ?, Contact = ? WHERE ID = ?";

                PreparedStatement pst = DB.connect().prepareStatement(query);
                pst.setString(1, upemail.getText());
                pst.setString(2, upcontact.getText());
                pst.setString(3, userSession());
                pst.executeUpdate();
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    notyup.setText("Successfully updated.");
                } else {
                    notyup.setText("No records updated.");
                }
            }

        }catch(Exception e){
            System.out.println(e);

        }
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
            System.out.println(userSession());
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
            String sql = "UPDATE technical_officer SET Image = ? WHERE ID = ?";

            try {
                techConnect DB = new techConnect();

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, imagePath);
                pst.setString(2, userSession());
                pst.executeUpdate();
                displayImageFromDB();
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    notyup.setText("Successfully updated Image.");
                } else {
                    notyup.setText("No Image updated.");
                }


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
            String sql = "SELECT Image FROM technical_officer WHERE ID = ?";
            techConnect DB = new techConnect();

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
        techConnect DB = new techConnect();

        try {
            String sql = "update technical_officer set Image = NULL where ID = '"+userSession()+"'";
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
    public void showNotice(){

        String date;
        String notice;
        String view;
        String id;

        try {
            techConnect conn = new techConnect();
            PreparedStatement ptr = null;
            String query = "SELECT * FROM notice ORDER BY date DESC";
            ptr = conn.connect().prepareStatement(query);

            noticeTable.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                date = rs.getString(4);
                notice = rs.getString(2);
                view = "View";
                id = rs.getString(1);
               Notice notice_record = new Notice(date,notice,view,id,msg);
                noticeTable.getItems().add(notice_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public void showTimetable(){

        String id;
        String department;
        String dwPath;
        String exe;
        try {
            techConnect conn = new techConnect();
            PreparedStatement ptr = null;
            String query = "SELECT * FROM timetable";
            ptr = conn.connect().prepareStatement(query);

            timeTable.getItems().clear();
            ResultSet rs = ptr.executeQuery();

            while (rs.next()) {
                id = rs.getString(1);
                department = rs.getString(2);
                dwPath = rs.getString(3);
                exe = rs.getString(4);
                Timetable notice_record = new Timetable(id,department,dwPath,dwnld,Tmsg,exe);
                timeTable.getItems().add(notice_record);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    void officerhome(){
        try{
            String query = "SELECT * FROM Technical_Officer where ID = ?";
            techConnect connect = new techConnect();
            PreparedStatement ptr = connect.connect().prepareStatement(query);
            ptr.setString(1,userSession());
            ResultSet result = ptr.executeQuery();

            while(result.next()){
                officerid.setText(result.getString(1));
                officername.setText(result.getString(2));
                officercontat.setText(result.getString(5));
                officermail.setText((result.getString(6)));
                //profName.setText(result.getString(2));

                passName = result.getString(2);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
