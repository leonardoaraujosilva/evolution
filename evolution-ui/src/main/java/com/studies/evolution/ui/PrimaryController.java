package com.studies.evolution.ui;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        EvolutionApplication.setRoot("secondary");
    }
}
