package com.example.pinchdraw;

import android.graphics.Path;
import android.graphics.PointF;

public class Line {


    private Path path;
    private PointF startX;
    private PointF startY;
    private PointF stopX;
    private PointF stopY;

    public Line(Path path, PointF startX, PointF startY, PointF stopX, PointF stopY) {
        this.path = path;
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public PointF getStartX() {
        return startX;
    }

    public void setStartX(PointF startX) {
        this.startX = startX;
    }

    public PointF getStartY() {
        return startY;
    }

    public void setStartY(PointF startY) {
        this.startY = startY;
    }

    public PointF getStopX() {
        return stopX;
    }

    public void setStopX(PointF stopX) {
        this.stopX = stopX;
    }

    public PointF getStopY() {
        return stopY;
    }

    public void setStopY(PointF stopY) {
        this.stopY = stopY;
    }
}