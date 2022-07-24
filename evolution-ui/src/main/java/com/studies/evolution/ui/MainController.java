package com.studies.evolution.ui;

import com.studies.evolution.domain.ApplicationStatus;
import com.studies.evolution.domain.Pixel;
import com.studies.evolution.renderer.Renderer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class MainController {

    private int generationCounter;
    private Renderer renderer;

    @FXML
    private Label lblGeneration;

    @FXML
    private Label lblStatus;

    @FXML
    private ImageView imgWorld;

    @FXML
    private FlowPane flpBackground;

    @FXML
    private void start() throws IOException {

        restartStatuses();
        recreateImage();

    }

    @FXML
    private void reset() throws IOException {

        lblStatus.setText(ApplicationStatus.FINISHED.getName());

        // TODO

    }

    @FXML
    private void teste(MouseEvent event) {
        if (renderer == null)
            return;

        renderer.setPixelColor(new Pixel(255, 255, 0, 0), (int) event.getX(), (int) event.getY());
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
