module org.example.javatecmis {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javatecmis to javafx.fxml;
    exports org.example.javatecmis;
}