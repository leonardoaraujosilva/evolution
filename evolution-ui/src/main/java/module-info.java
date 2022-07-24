module com.studies.evolution.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.studies.evolution.core;

    opens com.studies.evolution.ui to javafx.fxml;
    exports com.studies.evolution.ui;
}
