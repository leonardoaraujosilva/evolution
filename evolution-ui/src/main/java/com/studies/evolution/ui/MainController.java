package com.studies.evolution.ui;

import com.studies.evolution.core.body.Coordinate;
import com.studies.evolution.core.body.Minion;
import com.studies.evolution.core.body.Worm;
import com.studies.evolution.domain.ApplicationStatus;
import com.studies.evolution.renderer.Renderer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class MainController {

    @FXML
    private Label lblGeneration;

    @FXML
    private Label lblStatus;

    @FXML
    private ImageView imgWorld;

    @FXML
    private FlowPane flpBackground;

    private final Minion minion = new Worm();

    private int generationCounter;

    private Renderer renderer;

    @FXML
    private void start() throws IOException {
        restartStatuses();
        recreateImage();
    }

    @FXML
    private void reset() throws IOException {
        // TODO
    }

    @FXML
    private void teste(MouseEvent event) {
        if (renderer == null)
            return;

        minion.setPosition(new Coordinate((int) event.getX(), (int) event.getY()));
        renderer.clear(minion.getBodyLastPosition());
        renderer.setAllPixelColor(minion.getBodyPosition());
    }

    private void restartStatuses() {
        generationCounter = 0;
        lblStatus.setText(ApplicationStatus.RUNNING.getName());
        lblGeneration.setText(String.valueOf(generationCounter));
    }

    private void recreateImage() {
        imgWorld.setFitWidth(flpBackground.getWidth());
        imgWorld.setFitHeight(flpBackground.getHeight());
        renderer = new Renderer((int) imgWorld.getFitWidth(), (int) imgWorld.getFitHeight());
        imgWorld.setImage(renderer.getImage());
    }
}
