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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.javatecmis.LoginController;
import org.example.javatecmis.connect.adminConnect;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    // Pains
    private Pane studentpain;
    @FXML
    private Pane homepane;
    @FXML
    private Pane lecturepain;


    //@FXML
    //void logout(ActionEvent event) {

    // }
    //-------------home pane ------------
    @FXML
    void home_pane(ActionEvent event) {
        studentpain.setVisible(false);
        homepane.setVisible(true);
        lecturepain.setVisible(false);
    }
    //------Student details display part +++Student pane ++++ ---------
    @FXML
    void student_pane(ActionEvent event) {
        studentpain.setVisible(true);
        homepane.setVisible(false);
        lecturepain.setVisible(false);
        StuTable();
    }
    @FXML
    void lecture_pain(ActionEvent event) {
        studentpain.setVisible(false);
        homepane.setVisible(false);
        lecturepain.setVisible(true);
        LecTable();
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
            alert.setTitle("Lecture Details");
            alert.setHeaderText("Lecture Form");
            alert.setContentText("Successfully Added");
            alert.showAndWait();

            LecTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void lecture_delete(ActionEvent event) {
        String lec_id = lec_in_id.getText();
        adminConnect conn = new adminConnect();
        PreparedStatement pst;
        String sql = "DELETE FROM lecture WHERE Lec_id=?";
        try{
            pst = conn.connect().prepareStatement(sql);
            pst.setString(1,lec_id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Lecture Details");
            alert.setHeaderText("Lecture Form");
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            LecTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            alert.setTitle("Lecture Details");
            alert.setHeaderText("Lecture Form");
            alert.setContentText("Successfully Updated");
            alert.showAndWait();

            LecTable();
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
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        LoginController o = new LoginController();
        o.logout(event);
    }



    public void initialize(){
        //StuTable();
        homepane.setVisible(true);
        studentpain.setVisible(false);
        lecturepain.setVisible(false);
    }
}
