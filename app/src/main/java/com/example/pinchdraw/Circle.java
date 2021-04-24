package com.example.pinchdraw;


import android.graphics.PointF;

public class Circle {

    private PointF startPoint;
    private PointF endPoint;

   public Circle(PointF point){
        startPoint = point;
        endPoint = point;
    }

    public void setStartPoint(PointF startPoint) {

       this.startPoint = startPoint;
    }

    public void setEndPoint(PointF endPoint) {
        this.endPoint = endPoint;
    }

    public PointF getStartPoint() {
        return startPoint;
    }

    public PointF getEndPoint() {
        return endPoint;
    }
}
