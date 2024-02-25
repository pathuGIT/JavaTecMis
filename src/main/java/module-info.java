module org.example.javatecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.javatecmis to javafx.fxml;
    exports org.example.javatecmis;
    exports org.example.javatecmis.student;
    opens org.example.javatecmis.student to javafx.fxml;
}