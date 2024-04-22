package org.example.javatecmis.student;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.example.javatecmis.connect.studentConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Notice {
    private String date = null;
    private String notice = null;
    private String view = null;
    private String id = null;
    private TextArea label = null;

    public Notice(String date, String notice, String view,String id, TextArea label) {
        this.date = date;
        this.notice = notice;
        this.view = view;
        this.id = id;
        this.label = label; // Assign the label reference
    }
    Notice(){

    }

    public void handle(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        int buttonId = Integer.parseInt(sourceButton.getId());

        try {
            studentConnect conn = new studentConnect();
            String query = "SELECT * FROM notice WHERE nId = ?";
            PreparedStatement ptr = conn.connect().prepareStatement(query);
            ptr.setInt(1, buttonId); // Set parameterized query

            ResultSet rs = ptr.executeQuery();
            while (rs.next()) {
                String text = rs.getString("notice");
                // Update the label with the retrieved notice text
                label.setText(text);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public String getDate() {
        return date;
    }

    public String getNotice() {
        return notice;
    }

    public Button getView(){
        Button btn = new Button(view);
        btn.setId(id);
        btn.setStyle("-fx-pref-width: 100px");
        btn.setStyle("-fx-font-family: Corbel");
        btn.setOnAction(event -> {
            handle(event);
        });
        return btn;
    }


}
