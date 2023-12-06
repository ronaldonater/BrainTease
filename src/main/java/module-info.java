module com.example.braintease_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.braintease_final to javafx.fxml;
    exports com.example.braintease_final;
}