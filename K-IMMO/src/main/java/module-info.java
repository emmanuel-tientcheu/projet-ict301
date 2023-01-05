module com.example.kimmo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kimmo to javafx.fxml;
    exports com.example.kimmo;
}