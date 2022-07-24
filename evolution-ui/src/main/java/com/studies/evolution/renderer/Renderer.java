package com.studies.evolution.renderer;

import com.studies.evolution.domain.Pixel;
import javafx.scene.image.PixelBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;

import java.nio.IntBuffer;

public class Renderer {

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
        Pixel pixel = new Pixel(0, 0, 0, 0);

        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                pixels[(x % width) + (y * width)] = pixel.getArgb();

        // tell the buffer that the entire area needs redrawing
        pixelBuffer.updateBuffer(b -> null);
    }

    public void setPixelColor(Pixel pixel, int x, int y) {
        pixels[(x % width) + (y * width)] = pixel.getArgb();
        pixelBuffer.updateBuffer(b -> null);
    }
}
