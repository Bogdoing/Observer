module com.example.task5_builder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task5_builder to javafx.fxml;
    exports com.example.task5_builder;
    exports model;
    opens model to javafx.fxml;
}