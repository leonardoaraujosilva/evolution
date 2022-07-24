module com.studies {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.studies.evolution.ui to javafx.fxml;
    exports com.studies.evolution.ui;
}
