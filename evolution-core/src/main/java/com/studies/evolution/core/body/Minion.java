package com.studies.evolution.core.body;

import java.util.List;

public interface Minion {

    List<PixelWithCoordinate> getBody();

    List<PixelWithCoordinate> getBodyPosition();

    List<Coordinate> getBodyLastPosition();

    Coordinate getPosition();

    void setPosition(Coordinate coordinate);

}
