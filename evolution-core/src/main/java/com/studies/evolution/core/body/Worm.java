package com.studies.evolution.core.body;

import java.util.ArrayList;
import java.util.List;

public class Worm implements Minion {

    private static final List<PixelWithCoordinate> body = List.of(
            new PixelWithCoordinate(new Pixel(255, 255, 0, 0), new Coordinate(-1, 0)),
            new PixelWithCoordinate(new Pixel(255, 255, 0, 0), new Coordinate(-2, 0)),
            new PixelWithCoordinate(new Pixel(255, 255, 0, 0), new Coordinate(-3, 0)),
            new PixelWithCoordinate(new Pixel(255, 255, 0, 0), new Coordinate(-4, 0)),
            new PixelWithCoordinate(new Pixel(255, 255, 0, 0), new Coordinate(-1, 2)),
            new PixelWithCoordinate(new Pixel(255, 0, 255, 0), new Coordinate(-1, 1)),
            new PixelWithCoordinate(new Pixel(255, 255, 255, 0), new Coordinate(-1, -1)),
            new PixelWithCoordinate(new Pixel(255, 0, 255, 0), new Coordinate(0, 0)),
            new PixelWithCoordinate(new Pixel(255, 255, 255, 0), new Coordinate(1, -1))
    );

    private List<Coordinate> cachePosition = null;

    private Coordinate position;

    @Override
    public List<PixelWithCoordinate> getBody() {
        return body;
    }

    @Override
    public List<PixelWithCoordinate> getBodyPosition() {
        List<PixelWithCoordinate> globalPosition = new ArrayList<>();
        cachePosition = new ArrayList<>();

        for(PixelWithCoordinate each : body) {
            Coordinate coordinate = new Coordinate(
                    each.coordinate().x() + position.x(),
                    each.coordinate().y() + position.y()
            );

            globalPosition.add(new PixelWithCoordinate(each.pixel(), coordinate));
            cachePosition.add(coordinate);
        }

        return globalPosition;
    }

    @Override
    public List<Coordinate> getBodyLastPosition() {
        return cachePosition;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
