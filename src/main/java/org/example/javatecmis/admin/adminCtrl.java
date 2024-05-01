package org.example.javatecmis.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.adminConnect;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.nio.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Character.getName;

public class adminCtrl {
    int myIndex;
    int id;
    private Stage stage;
    private Scene scene;

    @FXML
    //Student Details add button
    private Button st_btn_add;

    @FXML
    //Student Details delete button
    private Button st_btn_delete;

    @FXML
    //Student Details edit button
    private Button st_btn_edit;

    @FXML
    //Student table
    private TableColumn<?, ?> st_dep;

    @FXML
    private TextField st_in_mobile;

    @FXML
    private TextField st_in_dep;

    @FXML
    private TextField st_in_email;

    @FXML
    private TextField st_in_name;

    @FXML
    private TextField st_in_nic;

    @FXML
    private TextField st_in_regno;

    @FXML
    private TextField st_in_pass1;

    @FXML
    private TableColumn<StudentTable, String> st_mail;

    @FXML
    private TableColumn<StudentTable, String> st_name;

    @FXML
    private TableColumn<StudentTable, String> st_nic;

    @FXML
    private TableColumn<StudentTable, String> st_regno;

    @FXML
    private TableColumn<StudentTable, String> st_mobile;

    @FXML
    private TableColumn<StudentTable, String> st_dep1;

    @FXML
    private TableColumn<StudentTable, String> st_pass;

    @FXML
    private TableView<StudentTable> student_table;
    //End  student table.
    //start student search
    @FXML
    private Label st_s_con;

    @FXML
    private Label st_s_dep;

    @FXML
    private Label st_s_email;

    @FXML
    private Label st_s_id;

    @FXML
    private Label st_s_name;

    @FXML
    private Label st_s_nic;
    @FXML
    private TextField st_se_id;
    //student search end
    //lecture table
    @FXML
    private Button lec_btn_add;

    @FXML
    private Button lec_btn_delete;

    @FXML
    private Button lec_btn_edit;

    @FXML
    private TableColumn<LectureTable, String> lec_cont;

    @FXML
    private TableColumn<LectureTable, String> lec_dep;

    @FXML
    private TableColumn<LectureTable, String> lec_email;

    @FXML
    private TableColumn<LectureTable, String> lec_id;

    @FXML
    private TextField lec_in_con;

    @FXML
    private TextField lec_in_dep;

    @FXML
    private TextField lec_in_email;

    @FXML
    private TextField lec_in_id;

    @FXML
    private TextField lec_in_name;

    @FXML
    private TextField lec_in_pass;

    @FXML
    private TableColumn<LectureTable, String> lec_name;

    @FXML
    private TableColumn<LectureTable, String> lec_pass;

    @FXML
    private TableView<LectureTable> lecture_table;
    @FXML
    private Label lec_s_dep1;

    @FXML
    private Label lec_s_email1;

    @FXML
    private Label lec_s_id1;

    @FXML
    private Label lec_s_name1;

    @FXML
    private Label lec_s_nic1;

    @FXML
    private TextField lec_se_id1;
    @FXML
    private Text imp_msg;

    //Couse Table
    @FXML
    private Button co_btn_add1;

    @FXML
    private Button co_btn_delete1;

    @FXML
    private Button co_btn_edit1;
    @FXML
    private TextField co_in_credit1;

    @FXML
    private TextField co_in_dep1;

    @FXML
    private TextField co_in_lecid1;

    @FXML
    private TextField co_in_name1;

    @FXML
    private TextField co_in_regno1;

    @FXML
    private TextField co_in_type1;
    @FXML
    private TableColumn<CouseTable, String> co_credit;

    @FXML
    private TableColumn<CouseTable, String> co_dep;

    @FXML
    private TableColumn<CouseTable, String> co_depID;

    @FXML
    private TableColumn<CouseTable, String> co_id;
    @FXML
    private TableColumn<CouseTable, String> co_lecID;

    @FXML
    private TableColumn<CouseTable, String> co_lecNAME;

    @FXML
    private TableColumn<CouseTable, String> co_name;

    @FXML
    private TableColumn<CouseTable, String> co_type;
    @FXML
    private TableView<CouseTable> couse_table;

    //notice

    @FXML
    private Button no_btn_add;

    @FXML
    private Button no_btn_delete;

    @FXML
    private Button no_btn_edit;
    @FXML
    private TableColumn<NoticeTable, String> no_date;
    @FXML
    private TableColumn<NoticeTable, String> no_id;
    @FXML
    private TableColumn<NoticeTable, String> no_notice;
    @FXML
    private TableColumn<NoticeTable, String> no_topic;
    @FXML
    private TableView<NoticeTable> notice_table;
    @FXML
    private TextField no_in_id;
    @FXML
    private TextField no_in_name;
    @FXML
    private TextArea no_in_notice;
//    @FXML
//    private TextField no_in_date;
    @FXML
    private DatePicker no_in_date;
    //Timetable table
    @FXML
    private TableColumn<TimeTable, String> tt_url;
    @FXML
    private TableColumn<TimeTable, String> tt_dep;
    @FXML
    private TableColumn<TimeTable, String> tt_id;
    @FXML
    private TableView<TimeTable> time_table;
    @FXML
    private TextField tt_in_dep;
    @FXML
    private TextField tt_in_id;
    @FXML
    private TextField tt_in_url;

    //technicalOfficer
    @FXML
    private TableColumn<TechnicalOfficer, String> to_con;

    @FXML
    private TableColumn<TechnicalOfficer, String> to_email;

    @FXML
    private TableColumn<TechnicalOfficer, String> to_gen;

    @FXML
    private TableColumn<TechnicalOfficer, String> to_id;
    @FXML
    private TableColumn<TechnicalOfficer, String> to_name;

    @FXML
    private TableColumn<TechnicalOfficer, String> to_pass;

    @FXML
    private TableColumn<TechnicalOfficer, String> to_usname;
    @FXML
    private TableView<TechnicalOfficer> officer_table;
    @FXML
    private TextField to_in_dep;

    @FXML
    private TextField to_in_email;

    @FXML
    private TextField to_in_mobile;

    @FXML
    private TextField to_in_name;

    @FXML
    private TextField to_in_nic;

    @FXML
    private TextField to_in_pass;

    @FXML
    private TextField to_in_regno;

    //+++++++++++++++++++++admin edit+++++++++++++++++++++
    @FXML
    private Circle imgC;
    @FXML
    private Circle imgC1;
    @FXML
    private TextField ad_in_name;
    @FXML
    private TextField ad_in_pass;

    @FXML
    // Pains
    private Pane studentpain;
    @FXML
    private Pane homepane;
    @FXML
    private Pane lecturepain;
    @FXML
    private Pane lectureSearchPain;
    @FXML
    private Pane studentSearchPain;
    @FXML
    private Pane cousepain;
    @FXML
    private Pane noticepain;
    @FXML
    private Pane timetablepain;
    @FXML
    private Pane officerpane;
    @FXML
    private Pane adminpane;
    @FXML
    private Pane homeleftpain;
    //error msg label
    @FXML
    private Label field_text;


    //@FXML
    //void logout(ActionEvent event) {

    // }
    //-------------home pane ------------
    public void initialize(){
        //StuTable();
        homepane.setVisible(true);
        homeleftpain.setVisible(true);
        studentpain.setVisible(false);
        lecturepain.setVisible(false);
        studentSearchPain.setVisible(false);
        lectureSearchPain.setVisible(false);
        cousepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        adminpane.setVisible(false);
        displayImageFromDB();

    }
    @FXML
    void home_pane(ActionEvent event) {
        homepane.setVisible(true);
        homeleftpain.setVisible(true);
        studentpain.setVisible(false);
        lecturepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        cousepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        adminpane.setVisible(false);
    }
    //------Student details display part +++Student pane ++++ ---------
    @FXML
    void student_pane(ActionEvent event) {
        studentpain.setVisible(true);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        cousepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        StuTable();
    }
    @FXML
    void lecture_pain(ActionEvent event) {
        lecturepain.setVisible(true);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lectureSearchPain.setVisible(false);
        cousepain.setVisible(false);
        studentSearchPain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        LecTable();
    }
    @FXML
    void student_search_pain(ActionEvent event) {
        studentSearchPain.setVisible(true);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        cousepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
    }
    @FXML
    void lecture_search_pain(ActionEvent event) {
        lectureSearchPain.setVisible(true);
        studentSearchPain.setVisible(false);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        cousepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
    }
    @FXML
    void couse_pain(ActionEvent event) {
        cousepain.setVisible(true);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        noticepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        CoTable();
    }
    @FXML
    void nitice_pain(ActionEvent event) {
        noticepain.setVisible(true);
        cousepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        timetablepain.setVisible(false);
        officerpane.setVisible(false);
        NoTable();
    }
    @FXML
    void timetable_pain(ActionEvent event) {
        timetablepain.setVisible(true);
        noticepain.setVisible(false);
        cousepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        officerpane.setVisible(false);
        TmTable();
    }
    @FXML
    void officer_pain(ActionEvent event){
        officerpane.setVisible(true);
        timetablepain.setVisible(false);
        noticepain.setVisible(false);
        cousepain.setVisible(false);
        lectureSearchPain.setVisible(false);
        studentSearchPain.setVisible(false);
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        TecOfficer();
    }
    @FXML
    void admin_pane(ActionEvent event){
        adminpane.setVisible(true);
        homeleftpain.setVisible(false);
        displayImageFromDB();
    }
    @FXML
    void homego(ActionEvent event){
        adminpane.setVisible(false);
        homeleftpain.setVisible(true);
        displayImageFromDB();
    }

    @FXML
    void student_add(ActionEvent event) {
        String std_id1, std_name1, std_email1, std_nic1, std_dep1, std_contact1,std_pass1;
        std_id1 = st_in_regno.getText();
        std_name1 = st_in_name.getText();
        std_email1 = st_in_email.getText();
        std_nic1 = st_in_nic.getText();
        std_dep1 = st_in_dep.getText();
        std_contact1 = st_in_mobile.getText();
        std_pass1 = st_in_pass1.getText();
        if(!(std_id1.isEmpty())){
            try {
                String sql = "INSERT INTO student(Std_id,Name,Email,NIC,Dep_id,Contact,Password) VALUES (?,?,?,?,?,?,?)";
                adminConnect conn = new adminConnect();
                PreparedStatement pst = conn.connect().prepareStatement(sql);

                pst.setString(1,std_id1);
                pst.setString(2,std_name1);
                pst.setString(3,std_email1);
                pst.setString(4,std_nic1);
                pst.setString(5,std_dep1);
                pst.setString(6,std_contact1);
                pst.setString(7,std_pass1);
                pst.executeUpdate();

                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setTitle("Student details");
                add_alert.setHeaderText("Student Form");
                add_alert.setContentText("Succsessfull Insert");
                add_alert.showAndWait();

                st_in_regno.setText("Enter Reg_no");
                st_in_name.setText("Enter Name");
                st_in_email.setText("Enter Email");
                st_in_nic.setText("Enter NIC ");
                st_in_dep.setText("Enter department");
                st_in_mobile.setText("Enter Mobile Number");
                st_in_pass1.setText("Enter Password");

                StuTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill field");
        }

    }
    public void StuTable(){
        adminConnect conn = new adminConnect();
        ObservableList<StudentTable> students = FXCollections.observableArrayList();
        try{
            String sql = "SELECT Std_id,Name,Email,NIC,Dep_id,Contact,Password FROM student";
            PreparedStatement pst = conn.connect().prepareStatement(sql);

            //student_table.getItems().clear();
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                StudentTable st = new StudentTable();
                st.setStd_id1(rs.getString(1));
                st.setStd_name1(rs.getString(2));
                st.setStd_email1(rs.getString(3));
                st.setStd_nic1(rs.getString(4));
                st.setStd_dep1(rs.getString(5));
                st.setStd_contact1(rs.getString(6));
                st.setStd_pass1(rs.getString(7));
                students.add(st);

                //StudentTable stable = new StudentTable(Id,name,Email,NIC,Dep,Contact);
                // student_table.getItems().add(stable);

            }
            student_table.setItems(students);
            st_regno.setCellValueFactory(f -> f.getValue().std_id1Property());
            st_name.setCellValueFactory(f -> f.getValue().std_name1Property());
            st_mail.setCellValueFactory(f -> f.getValue().std_email1Property());
            st_nic.setCellValueFactory(f -> f.getValue().std_nic1Property());
            st_dep1.setCellValueFactory(f -> f.getValue().std_dep1Property());
            st_mobile.setCellValueFactory(f -> f.getValue().std_contact1Property());
            st_pass.setCellValueFactory(f -> f.getValue().std_pass1Property());



        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        student_table.setRowFactory(tv -> {
            TableRow<StudentTable> tRow = new TableRow<>();
            tRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!tRow.isEmpty())){
                    myIndex = student_table.getSelectionModel().getFocusedIndex();
                    //id = Integer.parseInt(String.valueOf(student_table.getItems().get(myIndex).getStd_id1()));
                    st_in_regno.setText(student_table.getItems().get(myIndex).getStd_id1());
                    st_in_name.setText(student_table.getItems().get(myIndex).getStd_name1());
                    st_in_email.setText(student_table.getItems().get(myIndex).getStd_email1());
                    st_in_nic.setText(student_table.getItems().get(myIndex).getStd_nic1());
                    st_in_dep.setText(student_table.getItems().get(myIndex).getStd_dep1());
                    st_in_mobile.setText((student_table.getItems().get(myIndex).getStd_contact1()));
                    st_in_pass1.setText((student_table.getItems().get(myIndex).getStd_pass1()));


                }
            });
            return tRow;
        });

    }

    @FXML
    void student_delete(ActionEvent event) {
        String stu_id = st_in_regno.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        if(!(stu_id.isEmpty())){
            try{
                String sql = "DELETE FROM student WHERE Std_id=?";
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,stu_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Student details");
                alert.setHeaderText("Student Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();

                StuTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            field_text.setText("fill ID");
        }

    }

    @FXML
    void student_edit(ActionEvent event) {
        String std_id1, std_name1, std_email1, std_nic1, std_dep1, std_contact1,std_pass1;
        std_id1 = st_in_regno.getText();
        std_name1 = st_in_name.getText();
        std_email1 = st_in_email.getText();
        std_nic1 = st_in_nic.getText();
        std_dep1 = st_in_dep.getText();
        std_contact1 = st_in_mobile.getText();
        std_pass1 = st_in_pass1.getText();

        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        if(!(std_id1.isEmpty())){
            try{
                String sql = "UPDATE student SET Std_id=?, Name=?, Email=?, NIC=?, Dep_id=?, Contact=?, Password=? WHERE Std_id=?";

                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,std_id1);
                pst.setString(2,std_name1);
                pst.setString(3,std_email1);
                pst.setString(4,std_nic1);
                pst.setString(5,std_dep1);
                pst.setString(6,std_contact1);
                pst.setString(7,std_pass1);
                pst.setString(8,std_id1);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Student details");
                alert.setHeaderText("Student Form");
                alert.setContentText("Successfully Edited");
                alert.showAndWait();

                StuTable();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill the filds");
        }

    }
    //++++++++++++++++++++++student search++++++++++++++++++++++++++++++
    @FXML
    void Student_search(ActionEvent event) {
        String st_id = st_se_id.getText();
        String sql = "SELECT student.Std_id, student.Name, student.Email, student.NIC, department.Name, student.Contact FROM student JOIN department ON student.Dep_id = department.Dep_id WHERE student.Std_id = ?";
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        try{
            pst = conn.connect().prepareStatement(sql);
            pst.setString(1,st_id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                st_s_id.setText(rs.getString(1));
                st_s_name.setText(rs.getString(2));
                st_s_email.setText(rs.getString(3));
                st_s_nic.setText(rs.getString(4));
                st_s_dep.setText(rs.getString(5));
                st_s_con.setText(rs.getString(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //+++++++++++++++Lecture++++++++++++++++++++
    public void LecTable(){
        adminConnect conn = new adminConnect();
        ObservableList<LectureTable> lecture = FXCollections.observableArrayList();
        try {
            String sql = "SELECT lecture.Lec_id, lecture.Name, lecture.Email, lecture.Password, lecture.Contact, department.Name FROM lecture JOIN department ON lecture.Dep_id = department.Dep_id;";
            PreparedStatement pst = conn.connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                LectureTable lt = new LectureTable();
                lt.setLec_id1(rs.getString(1));
                lt.setLec_name1(rs.getString(2));
                lt.setLec_email1(rs.getString(3));
                lt.setLec_pass1(rs.getString(4));
                lt.setLec_cont1(rs.getString(5));
                lt.setLec_dep1(rs.getString(6));
                lecture.add(lt);

            }

            lecture_table.setItems(lecture);
            lec_id.setCellValueFactory(f -> f.getValue().lec_id1Property());
            lec_name.setCellValueFactory(f -> f.getValue().lec_name1Property());
            lec_email.setCellValueFactory(f -> f.getValue().lec_email1Property());
            lec_pass.setCellValueFactory(f -> f.getValue().lec_pass1Property());
            lec_cont.setCellValueFactory(f -> f.getValue().lec_cont1Property());
            lec_dep.setCellValueFactory(f -> f.getValue().lec_dep1Property());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        lecture_table.setRowFactory(tv -> {
            TableRow<LectureTable> tRow = new TableRow<>();
            tRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!tRow.isEmpty())){
                    myIndex = lecture_table.getSelectionModel().getFocusedIndex();
                    lec_in_id.setText(lecture_table.getItems().get(myIndex).getLec_id1());
                    lec_in_name.setText(lecture_table.getItems().get(myIndex).getLec_name1());
                    lec_in_email.setText(lecture_table.getItems().get(myIndex).getLec_email1());
                    lec_in_pass.setText(lecture_table.getItems().get(myIndex).getLec_pass1());
                    lec_in_con.setText(lecture_table.getItems().get(myIndex).getLec_cont1());
                    lec_in_dep.setText(lecture_table.getItems().get(myIndex).getLec_dep1());

                }
            });
            return tRow;
        });
        imp_msg.setFill(Color.RED);
    }
    @FXML
    void lecture_add(ActionEvent event) {
        String lec_id,lec_name,lec_mail,lec_pass,lec_cont,lec_dep;
        lec_id = lec_in_id.getText();
        lec_name = lec_in_name.getText();
        lec_mail = lec_in_email.getText();
        lec_pass = lec_in_pass.getText();
        lec_cont = lec_in_con.getText();
        lec_dep = lec_in_dep.getText();

        String sql = "INSERT INTO lecture(Lec_id,Name,Email,Password,Contact,Dep_id) VALUE(?,?,?,?,?,?);";
        if(!(lec_id.isEmpty())){
            try{
                adminConnect conn = new adminConnect();
                PreparedStatement pst = conn.connect().prepareStatement(sql);

                pst.setString(1,lec_id);
                pst.setString(2,lec_name);
                pst.setString(3,lec_mail);
                pst.setString(4,lec_pass);
                pst.setString(5,lec_cont);
                pst.setString(6,lec_dep);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lecturer Details");
                alert.setHeaderText("Lecturer Form");
                alert.setContentText("Successfully Added");
                alert.showAndWait();

                LecTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("fill Fields");
        }

    }

    @FXML
    void lecture_delete(ActionEvent event) {
        String lec_id = lec_in_id.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "DELETE FROM lecture WHERE Lec_id=?";
        if(!(lec_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,lec_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lecturer details");
                alert.setHeaderText("Lecturer Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                LecTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("fill ID");
        }

    }

    @FXML
    void lecture_edit(ActionEvent event) {
        String lec_id,lec_name,lec_mail,lec_pass,lec_cont,lec_dep;
        lec_id = lec_in_id.getText();
        lec_name = lec_in_name.getText();
        lec_mail = lec_in_email.getText();
        lec_pass = lec_in_pass.getText();
        lec_cont = lec_in_con.getText();
        lec_dep = lec_in_dep.getText();

        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "UPDATE lecture SET Lec_id=?, Name=?, Email=?, Password=?, Contact=?, Dep_id=? WHERE Lec_id=?";
        if(!(lec_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,lec_id);
                pst.setString(2,lec_name);
                pst.setString(3,lec_mail);
                pst.setString(4,lec_pass);
                pst.setString(5,lec_cont);
                pst.setString(6,lec_dep);
                pst.setString(7,lec_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lecturer Details");
                alert.setHeaderText("Lecturer Form");
                alert.setContentText("Successfully Updated");
                alert.showAndWait();

                LecTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            field_text.setText("fill fields");
        }

    }
    @FXML
    void Lecture_search(ActionEvent event) {
        String lec_id = lec_se_id1.getText();
        String sql = "SELECT lecture.Lec_id, lecture.Name, lecture.Email, lecture.Contact, department.Name FROM lecture JOIN department ON lecture.Dep_id = department.Dep_id WHERE lecture.Lec_id=?;";
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        try{
            pst = conn.connect().prepareStatement(sql);
            pst.setString(1,lec_id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                lec_s_id1.setText(rs.getString(1));
                lec_s_name1.setText(rs.getString(2));
                lec_s_email1.setText(rs.getString(3));
                lec_s_nic1.setText(rs.getString(4));
                lec_s_dep1.setText(rs.getString(5));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //+++++++++++++++++++++++++Couse+++++++++++++++++++++++++++++++++++++++++

    public void CoTable(){
        adminConnect conn = new adminConnect();
        ObservableList<CouseTable> couse = FXCollections.observableArrayList();
        PreparedStatement pst;
        try{
            String sql = "SELECT c.Crs_id,c.Name,c.Type,c.Credit,c.Dep_id,d.name,c.Lec_id,l.Name FROM course c JOIN department d ON c.Dep_id = d.Dep_id JOIN lecture l ON c.Lec_id = l.Lec_id;";
            pst = conn.connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                CouseTable ct = new CouseTable();
                ct.setCo_id(rs.getString(1));
                ct.setCo_name(rs.getString(2));
                ct.setCo_type(rs.getString(3));
                ct.setCo_cedit(rs.getString(4));
                ct.setCo_depID(rs.getString(5));
                ct.setCo_dep(rs.getString(6));
                ct.setCo_lecID(rs.getString(7));
                ct.setCo_lec_NAME(rs.getString(8));
                couse.add(ct);
            }
            couse_table.setItems(couse);
            co_id.setCellValueFactory(f -> f.getValue().co_idProperty());
            co_name.setCellValueFactory(f -> f.getValue().co_nameProperty());
            co_type.setCellValueFactory(f -> f.getValue().co_typeProperty());
            co_credit.setCellValueFactory(f -> f.getValue().co_ceditProperty());
            co_depID.setCellValueFactory(f -> f.getValue().co_depIDProperty());
            co_dep.setCellValueFactory(f -> f.getValue().co_depProperty());
            co_lecID.setCellValueFactory(f -> f.getValue().co_lecIDProperty());
            co_lecNAME.setCellValueFactory(f -> f.getValue().co_lec_NAMEProperty());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        couse_table.setRowFactory(tv -> {
            TableRow<CouseTable> tRow = new TableRow<>();
            tRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!tRow.isEmpty())){
                    myIndex = couse_table.getSelectionModel().getFocusedIndex();
                    co_in_regno1.setText(couse_table.getItems().get(myIndex).getCo_id());
                    co_in_name1.setText(couse_table.getItems().get(myIndex).getCo_name());
                    co_in_type1.setText(couse_table.getItems().get(myIndex).getCo_type());
                    co_in_credit1.setText(couse_table.getItems().get(myIndex).getCo_cedit());
                    co_in_dep1.setText(couse_table.getItems().get(myIndex).getCo_depID());
                    co_in_lecid1.setText(couse_table.getItems().get(myIndex).getCo_lecID());

                }
            });
            return tRow;
        });

    }
    @FXML
    void couse_add(ActionEvent event) {
        String co_id,co_name,co_type,co_credit,co_depID,co_dep,co_lecID,co_lecNAME;
        co_id = co_in_regno1.getText();
        co_name = co_in_name1.getText();
        co_type = co_in_type1.getText();
        co_credit = co_in_credit1.getText();
        co_depID = co_in_dep1.getText();
        co_lecID = co_in_lecid1.getText();

        String sql ="INSERT INTO course(Crs_id,Name,Type,Credit,Dep_id,Lec_id) VALUE(?,?,?,?,?,?);";
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        if(!(co_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);

                pst.setString(1,co_id);
                pst.setString(2,co_name);
                pst.setString(3,co_type);
                pst.setString(4,co_credit);
                pst.setString(5,co_depID);
                pst.setString(6,co_lecID);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Courses Details");
                alert.setHeaderText("Courses Form");
                alert.setContentText("Successfully Added");
                alert.showAndWait();
                CoTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            field_text.setText("Fill all fields");
        }

    }

    @FXML
    void couse_delete(ActionEvent event) {
        String co_id = co_in_regno1.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "DELETE FROM course WHERE Crs_id=?";
        if(!(co_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,co_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Courses details");
                alert.setHeaderText("Courses Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                CoTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Enter Id");
        }

    }

    @FXML
    void couse_edit(ActionEvent event) {
        String co_id,co_name,co_type,co_credit,co_depID,co_dep,co_lecID,co_lecNAME;
        co_id = co_in_regno1.getText();
        co_name = co_in_name1.getText();
        co_type = co_in_type1.getText();
        co_credit = co_in_credit1.getText();
        co_depID = co_in_dep1.getText();
        co_lecID = co_in_lecid1.getText();

        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "UPDATE course SET Crs_id=?, Name=?, Type=?, Credit=?, Dep_id=?,Lec_id=? WHERE Crs_id=?";
        if(!(co_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,co_id);
                pst.setString(2,co_name);
                pst.setString(3,co_type);
                pst.setString(4,co_credit);
                pst.setString(5,co_depID);
                pst.setString(6,co_lecID);
                pst.setString(7,co_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Course Details");
                alert.setHeaderText("Course Form");
                alert.setContentText("Successfully Updated");
                alert.showAndWait();

                CoTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill the Filds");
        }

    }
    //+++++++++++++++++++++++++Notice++++++++++++++++++++++++++++++
    public void NoTable(){
        adminConnect conn = new adminConnect();
        ObservableList<NoticeTable> ntt = FXCollections.observableArrayList();
        String sql = "SELECT topic,notice,date,nId FROM notice;";
        try{
            PreparedStatement pst = conn.connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                NoticeTable nt = new NoticeTable();
                nt.setNo_topic(rs.getString(1));
                nt.setNo_notice(rs.getString(2));
                nt.setNo_date(rs.getString(3));
                nt.setNo_id(rs.getString(4));
                ntt.add(nt);
            }

            notice_table.setItems(ntt);
            no_topic.setCellValueFactory(f -> f.getValue().no_topicProperty());
            no_notice.setCellValueFactory(f -> f.getValue().no_noticeProperty());
            no_date.setCellValueFactory(f -> f.getValue().no_dateProperty());
            no_id.setCellValueFactory(f -> f.getValue().no_idProperty());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        notice_table.setRowFactory(tv -> {
            TableRow<NoticeTable> tRow = new TableRow<>();
            tRow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!tRow.isEmpty())){
                    myIndex = notice_table.getSelectionModel().getFocusedIndex();
                    //no_in_id = Integer.parseInt(String.valueOf(notice_table.getItems().get(myIndex).getNo_id()));
                    no_in_name.setText(notice_table.getItems().get(myIndex).getNo_topic());
                    no_in_notice.setText(notice_table.getItems().get(myIndex).getNo_notice());
                    no_in_date.setValue(LocalDate.parse(notice_table.getItems().get(myIndex).getNo_date()));
                    no_in_id.setText(notice_table.getItems().get(myIndex).getNo_id());
                }
            });
            return tRow;
        });

    }
    @FXML
    void notice_add(ActionEvent event) {
        String no_topic,no_notice;
        LocalDate date;
        no_topic = no_in_name.getText();
        no_notice = no_in_notice.getText();
        date = no_in_date.getValue();
        String sql = "INSERT INTO notice(topic,notice,date) VALUES (?,?,?)";
        if(!(no_topic.isEmpty())){
            try{
                adminConnect conn = new adminConnect();
                PreparedStatement pst = conn.connect().prepareStatement(sql);
                pst.setString(1,no_topic);
                pst.setString(2,no_notice);
                pst.setObject(3,date);
                pst.executeUpdate();

                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setTitle("Notice details");
                add_alert.setHeaderText("Notice Form");
                add_alert.setContentText("Successful Insert");
                add_alert.showAndWait();
                NoTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("fill All Filds");
        }

    }

    @FXML
    void notice_delete(ActionEvent event) {
        String no_id = no_in_id.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "DELETE FROM notice WHERE nId=?";
        if(!(no_id.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,no_id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Notice details");
                alert.setHeaderText("Notice Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                NoTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Enter Id");
        }

    }
    //++++++++++++++++++++++Timetable Table+++++++++++++++++++++++++++

    public void TmTable(){
        adminConnect conn = new adminConnect();
        ObservableList<TimeTable> timetable = FXCollections.observableArrayList();
        try{
            String sql = "SELECT * FROM timetable;";
            PreparedStatement pst = conn.connect().prepareStatement(sql);;
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                TimeTable tt = new TimeTable();
                tt.setTt_id(rs.getString(1));
                tt.setTt_dep(rs.getString(2));
                tt.setTt_url(rs.getString(3));
                timetable.add(tt);
            }
            time_table.setItems(timetable);
            tt_id.setCellValueFactory(f -> f.getValue().tt_idProperty());
            tt_dep.setCellValueFactory(f -> f.getValue().tt_depProperty());
            tt_url.setCellValueFactory(f -> f.getValue().tt_urlProperty());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        time_table.setRowFactory(tv -> {
            TableRow<TimeTable> trow = new TableRow<>();
            trow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!trow.isEmpty())){
                    myIndex = time_table.getSelectionModel().getFocusedIndex();
                    tt_in_id.setText(time_table.getItems().get(myIndex).getTt_id());
                    tt_in_dep.setText(time_table.getItems().get(myIndex).getTt_dep());
                    tt_in_url.setText(time_table.getItems().get(myIndex).getTt_url());
                }
            });
            return trow;
        });
    }
    @FXML
    void timetable_add(ActionEvent event) {
        String tt_dep1,tt_url1;
        tt_dep1 = tt_in_dep.getText();
        tt_url1 = tt_in_url.getText();
        String sql = "INSERT INTO timetable(department,path_id) VALUE(?,?)";
        if(!(tt_dep1.isEmpty())){
            try{
                adminConnect conn = new adminConnect();
                PreparedStatement pst = conn.connect().prepareStatement(sql);
                pst.setString(1,tt_dep1);
                pst.setString(2,tt_url1);
                pst.executeUpdate();

                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setTitle("Time Table details");
                add_alert.setHeaderText("Time Table Form");
                add_alert.setContentText("Successful Insert");
                add_alert.showAndWait();
                TmTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill the Filed");
        }

    }
    @FXML
    void timetable_delete(ActionEvent event) {
        String tt_id2 = tt_in_id.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "DELETE FROM timetable WHERE id=?";
        if(!(tt_id2.isEmpty())){
            try{
                pst = conn.connect().prepareStatement(sql);
                pst.setString(1,tt_id2);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Time Table details");
                alert.setHeaderText("Time table Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                TmTable();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Enter ID Filed");
        }

    }
    //++++++++++++++++++++++++++Technical Officer+++++++++++++++++++

    public void TecOfficer(){
        adminConnect conn = new adminConnect();
        ObservableList<TechnicalOfficer> techo = FXCollections.observableArrayList();
        String sql = "SELECT ID,Name,Username,Password,Contact,Email,Gender FROM technical_officer;";
        PreparedStatement pst;
        try{
            pst = conn.connect().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                TechnicalOfficer to = new TechnicalOfficer();
                to.setId(rs.getString(1));
                to.setName(rs.getString(2));
                to.setUser_name(rs.getString(3));
                to.setPass(rs.getString(4));
                to.setContact(rs.getString(5));
                to.setEmail(rs.getString(6));
                to.setGender(rs.getString(7));
                techo.add(to);
            }
            officer_table.setItems(techo);
            to_id.setCellValueFactory(f -> f.getValue().idProperty());
            to_name.setCellValueFactory(f -> f.getValue().nameProperty());
            to_usname.setCellValueFactory(f -> f.getValue().user_nameProperty());
            to_pass.setCellValueFactory(f -> f.getValue().passProperty());
            to_con.setCellValueFactory(f -> f.getValue().contactProperty());
            to_email.setCellValueFactory(f -> f.getValue().emailProperty());
            to_gen.setCellValueFactory(f -> f.getValue().genderProperty());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        officer_table.setRowFactory(tv -> {
            TableRow<TechnicalOfficer> trow = new TableRow<>();
            trow.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && (!trow.isEmpty())){
                    myIndex = officer_table.getSelectionModel().getFocusedIndex();
                    to_in_regno.setText(officer_table.getItems().get(myIndex).getId());
                    to_in_name.setText(officer_table.getItems().get(myIndex).getName());
                    to_in_email.setText(officer_table.getItems().get(myIndex).getUser_name());
                    to_in_nic.setText(officer_table.getItems().get(myIndex).getPass());
                    to_in_dep.setText(officer_table.getItems().get(myIndex).getContact());
                    to_in_mobile.setText(officer_table.getItems().get(myIndex).getEmail());
                    to_in_pass.setText(officer_table.getItems().get(myIndex).getGender());
                }
            });
            return trow;
        });
    }
    @FXML
    void officer_add(ActionEvent event) {
        String id,name,u_name,pass,contact,email,gender;
        id = to_in_regno.getText();
        name = to_in_name.getText();
        u_name = to_in_email.getText();
        pass = to_in_nic.getText();
        contact = to_in_dep.getText();
        email = to_in_mobile.getText();
        gender = to_in_pass.getText();
        String sql = "INSERT INTO technical_officer(ID,Name,Username,Password,Contact,Email,Gender) VALUE (?,?,?,?,?,?,?);";
        if(!(id.isEmpty())){
            try{
                adminConnect conn = new adminConnect();
                PreparedStatement pst = conn.connect().prepareStatement(sql);
                pst.setString(1,id);
                pst.setString(2,name);
                pst.setString(3,u_name);
                pst.setString(4,pass);
                pst.setString(5,contact);
                pst.setString(6,email);
                pst.setString(7,gender);
                pst.executeUpdate();
                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setTitle("Technical Officer details");
                add_alert.setHeaderText("Technical Officer Form");
                add_alert.setContentText("Successful Insert");
                add_alert.showAndWait();
                TecOfficer();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill All Fields");
        }


    }
    //++++++++++++++++++++++++Imageupload part++++++++++++++++++
    @FXML
    public void displayImageFromDB() {
        try {
            // Retrieve the image path from the database for the specific student
            String sql = "SELECT Image FROM admin WHERE id = ?";
            adminConnect DB = new adminConnect();
            int id = 1;
            PreparedStatement pst = DB.connect().prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                if(rs.getString("Image") != null){
                    String relativeImagePath = rs.getString("Image");
                    String absoluteImagePath = Paths.get(System.getProperty("user.dir"), relativeImagePath).toString();

                    File imageFile = new File(absoluteImagePath);
                    if (imageFile.exists()) {
                        Image image = new Image(imageFile.toURI().toString());
                        imgC.setFill(new ImagePattern(image));
                        imgC1.setFill(new ImagePattern(image));
                    } else {
                        System.out.println("Image file not found: " + absoluteImagePath);
                    }
                }else{
                    String path = "img/account.png";
                    File imageFile = new File(path);
                    Image image = new Image(imageFile.toURI().toString());
                    imgC.setFill(new ImagePattern(image));
                    imgC1.setFill(new ImagePattern(image));
                }

            } else {
                //System.out.println("");
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Student.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @FXML
    void img_updadte(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        // Show the file chooser dialog
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Display the selected image in a Circle
            Image image = new Image(selectedFile.toURI().toString());
            imgC.setFill(new ImagePattern(image));


            File imgFolder = new File("img");
            if (!imgFolder.exists()) {
                imgFolder.mkdirs();
            }
            File destinationFile = new File(imgFolder, selectedFile.getName());
            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String imagePath = "img/" + selectedFile.getName(); // Relative path to the 'img' folder
            String sql = "UPDATE admin SET Image = ? WHERE id = ?";
            String id = "1";
            try {
                adminConnect DB = new adminConnect();

                PreparedStatement pst = DB.connect().prepareStatement(sql);
                pst.setString(1, imagePath);
                pst.setString(2, id);
                pst.executeUpdate();
                displayImageFromDB();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Student.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    @FXML
    void img_delete(ActionEvent event){
        adminConnect DB = new adminConnect();

        try {
            String sql = "update admin set Image = NULL";
            PreparedStatement ptr = DB.connect().prepareStatement(sql);
            ptr.executeUpdate();

            String path = "img/account.png";
            File imageFile = new File(path);
            Image image = new Image(imageFile.toURI().toString());
            imgC.setFill(new ImagePattern(image));
            displayImageFromDB();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void officer_delete(ActionEvent event) {
        String id = to_in_regno.getText();
        System.out.println(id);
        adminConnect conn = new adminConnect();
        String sql = "DELETE FROM technical_officer WHERE ID=?;";
        if(!(id.isEmpty())){
            try{
                PreparedStatement pst = conn.connect().prepareStatement(sql);
                pst.setString(1,id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Technical Officer details");
                alert.setHeaderText("Technical Officer Form");
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();
                TecOfficer();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Enter ID Filed");
        }

    }

    @FXML
    void officer_edit(ActionEvent event) {
        String id,name,u_name,pass,contact,email,gender;
        id = to_in_regno.getText();
        name = to_in_name.getText();
        u_name = to_in_email.getText();
        pass = to_in_nic.getText();
        contact = to_in_dep.getText();
        email = to_in_mobile.getText();
        gender = to_in_pass.getText();
        adminConnect conn = new adminConnect();
        String sql = "UPDATE technical_officer SET ID=?, Name=?, Username=?, Password=?, Contact=?, Email=?, Gender=? WHERE ID=?;";
        if(!(id.isEmpty())){
            try{
                PreparedStatement pst = conn.connect().prepareStatement(sql);
                pst.setString(1,id);
                pst.setString(2,name);
                pst.setString(3,u_name);
                pst.setString(4,pass);
                pst.setString(5,contact);
                pst.setString(6,email);
                pst.setString(7,gender);
                pst.setString(8,id);
                pst.executeUpdate();
                Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
                add_alert.setTitle("Technical Officer details");
                add_alert.setHeaderText("Technical Officer Form");
                add_alert.setContentText("Successful Insert");
                add_alert.showAndWait();
                TecOfficer();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            field_text.setText("Fill All fields");
        }

    }
    @FXML
    public void admin_update(){
        adminConnect conn = new adminConnect();
        String name = ad_in_name.getText();
        String pss = ad_in_pass.getText();
        PreparedStatement pst;
        try{
            String sql = "update admin set username =?, password =? where id=1";
            pst = conn.connect().prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,pss);
            pst.executeUpdate();
            Alert add_alert = new Alert(Alert.AlertType.INFORMATION);
            add_alert.setTitle("Admin details");
            add_alert.setHeaderText("Admin Form");
            add_alert.setContentText("Successful");
            add_alert.showAndWait();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Label l;
    @FXML
    void btn(ActionEvent event) {
        l.setText("Kamal");
    }

    public void loginToAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }

}
