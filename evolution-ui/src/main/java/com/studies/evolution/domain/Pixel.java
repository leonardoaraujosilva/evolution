package com.studies.evolution.domain;

public record Pixel(int alpha, int red, int green, int blue) {
    public int getArgb() {
        return alpha << 24 | red << 16 | green << 8 | blue;
    }
}
