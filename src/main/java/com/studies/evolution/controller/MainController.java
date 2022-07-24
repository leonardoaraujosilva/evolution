package com.studies.evolution.ui;

import com.studies.evolution.core.body.Predator;
import com.studies.evolution.core.positioning.Coordinate;
import com.studies.evolution.renderer.ProcessingRender;
import com.studies.evolution.core.positioning.World;
import com.studies.evolution.core.body.Herbivores;
import com.studies.evolution.core.body.Organism;
import com.studies.evolution.domain.ApplicationStatus;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private Label lblGeneration;

    @FXML
    private Label lblStatus;

    @FXML
    private ImageView imgWorld;

    @FXML
    private FlowPane flpBackground;

    private World world;
    private Thread processing;

    @FXML
    private void start() throws IOException {
        restartStatuses();
        recreateImage();

        if(processing == null || processing.isInterrupted())
            execute();
    }

    @FXML
    private void stop() throws IOException {
        if(processing != null && processing.isAlive())
            processing.interrupt();
    }

    private void restartStatuses() {
        lblStatus.setText(ApplicationStatus.RUNNING.getName());
        lblGeneration.setText("disabled");
    }

    private void recreateImage() {
        imgWorld.setFitWidth(flpBackground.getWidth());
        imgWorld.setFitHeight(flpBackground.getHeight());
        world = new World((int) imgWorld.getFitWidth(), (int) imgWorld.getFitHeight());
        imgWorld.setImage(world.getImage());
    }

    private void execute() {
        ProcessingRender worker = new ProcessingRender(world, instantiateOrganism());
        processing = new Thread(worker);
        processing.start();
    }

    private List<Organism> instantiateOrganism() {
        List<Organism> organismList = new ArrayList<>();

        for(int i = 0; i<1500; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * imgWorld.getFitWidth());
                y = (int) (Math.random() * imgWorld.getFitHeight());
            } while(!world.isFree(x, y));

            organismList.add(new Herbivores(new Coordinate(x, y)));
        }

        for(int i = 0; i<300; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * imgWorld.getFitWidth());
                y = (int) (Math.random() * imgWorld.getFitHeight());
            } while(!world.isFree(x, y));

            organismList.add(new Predator(new Coordinate(x, y)));
        }

        return organismList;
    }
}
