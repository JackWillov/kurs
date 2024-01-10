module com.example.kurs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kurs to javafx.fxml,javafx.base;
    opens com.example.kurs.entity to javafx.base;
    exports com.example.kurs;
}