package com.example.pinchdraw;


import android.graphics.Path;
import android.graphics.PointF;

public class Circle {

    private PointF startPoint;
    private PointF endPoint;
    private Path path;

    public Circle(PointF point){
        startPoint = point;
        endPoint = point;

    }

  /*  public Circle(PointF startPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.path = path;
    }*/

    public void setStartPoint(PointF startPoint) {

       this.startPoint = startPoint;
    }


    public void setEndPoint(PointF endPoint) {
        this.endPoint = endPoint;
    }

    public PointF getStartPoint() {
        return startPoint;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public PointF getEndPoint() {
        return endPoint;
    }


}
