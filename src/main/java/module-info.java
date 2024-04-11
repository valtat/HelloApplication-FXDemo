module org.example.helloapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.helloapplication to javafx.fxml;
    exports org.example.helloapplication;
}