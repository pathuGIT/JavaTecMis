module org.example.javatecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.javatecmis to javafx.fxml;
    exports org.example.javatecmis;
    exports org.example.javatecmis.student;
    opens org.example.javatecmis.student to javafx.fxml;
    exports org.example.javatecmis.admin;
    opens org.example.javatecmis.admin to javafx.fxml;
    exports org.example.javatecmis.lecturer;
    opens org.example.javatecmis.lecturer to javafx.fxml;
    exports org.example.javatecmis.technicalOfficer;
    opens org.example.javatecmis.technicalOfficer to javafx.fxml;
}