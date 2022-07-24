package com.studies.evolution.core.body;

import com.studies.evolution.core.positioning.Coordinate;
import com.studies.evolution.core.positioning.PixelWithCoordinate;
import com.studies.evolution.core.positioning.Pixel;
import com.studies.evolution.core.positioning.World;

import java.util.ArrayList;
import java.util.List;

public class Herbivores implements Organism {

    private static final List<PixelWithCoordinate> body = List.of(
            new PixelWithCoordinate(new Pixel(255, 0, 0, 255), new Coordinate(0, 0))
    );

    private List<Coordinate> cachePosition = null;

    private Coordinate position;

    public Herbivores(int x, int y) {
        this.position = new Coordinate(x, y);
    }

    @Override
    public List<PixelWithCoordinate> getBody() {
        return body;
    }

    @Override
    public List<PixelWithCoordinate> getBodyInTheWorld() {
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
    public List<Coordinate> getBodyOldPosition() {
        return cachePosition;
    }

    @Override
    public Coordinate getPosition() {
        return position;
    }

    @Override
    public void setPosition(int x, int y) {
        this.position = new Coordinate(x, y);
    }

    @Override
    public void process(World renderer) {
        Coordinate coordinate = new Coordinate(
                position.x() + (Math.random() % 2 == 0? 1 : -1),
                position.y() + (Math.random() % 2 == 0? 1 : -1)
        );

        if(renderer.isFree(coordinate))
            setPosition(coordinate.x(), coordinate.y());
    }
}
