package com.studies.evolution.renderer;

import com.studies.evolution.core.body.Coordinate;
import com.studies.evolution.core.body.Pixel;
import com.studies.evolution.core.body.PixelWithCoordinate;
import javafx.scene.image.PixelBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;

import java.nio.IntBuffer;
import java.util.List;

public class Renderer {
    private static final Pixel BACKGROUND = new Pixel(0, 0, 0, 0);

    private final int width;
    private final int height;

    private final PixelBuffer<IntBuffer> pixelBuffer;
    private final WritableImage writableImage;
    private final int[] pixels;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;

        IntBuffer buffer = IntBuffer.allocate(width * height);
        pixels = buffer.array();
        pixelBuffer = new PixelBuffer<>(width, height, buffer, PixelFormat.getIntArgbPreInstance());

        writableImage = new WritableImage(pixelBuffer);

        setFullTransparent();
    }

    public WritableImage getImage() {
        return writableImage;
    }

    public void setFullTransparent() {

        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                pixels[(x % width) + (y * width)] = BACKGROUND.getArgb();

        pixelBuffer.updateBuffer(b -> null);
    }

    public void setPixelColor(Pixel pixel, Coordinate coordinate) {
        pixels[(coordinate.x() % width) + (coordinate.y() * width)] = pixel.getArgb();
        pixelBuffer.updateBuffer(b -> null);
    }

    public void setAllPixelColor(List<PixelWithCoordinate> allPixels) {
        for (PixelWithCoordinate each : allPixels)
            pixels[(each.coordinate().x() % width) + (each.coordinate().y() * width)] = each.pixel().getArgb();

        pixelBuffer.updateBuffer(b -> null);
    }

    public void clear(List<Coordinate> allPixels) {
        if(allPixels == null)
            return;

        for (Coordinate each : allPixels)
            pixels[(each.x() % width) + (each.y() * width)] = BACKGROUND.getArgb();

        pixelBuffer.updateBuffer(b -> null);
    }
}
