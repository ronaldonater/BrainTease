module com.example.braintease_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.prefs;
    requires java.desktop;


    opens com.example.braintease_final to javafx.fxml;
    exports com.example.braintease_final;
}
