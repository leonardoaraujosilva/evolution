package com.studies.evolution.core.body;

import com.studies.evolution.core.positioning.Coordinate;
import com.studies.evolution.core.positioning.PixelWithCoordinate;
import com.studies.evolution.core.positioning.World;

import java.util.List;

public interface Organism {

    List<PixelWithCoordinate> getBody();

    List<PixelWithCoordinate> getBodyInTheWorld();

    List<Coordinate> getBodyOldPosition();

    void setPosition(int x, int y);

    Coordinate getPosition();

    void process(World renderer);

}
