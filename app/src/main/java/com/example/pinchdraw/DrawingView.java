package com.example.pinchdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Circle currentCircle;
    private List<Circle> circles = new ArrayList<>();
    private Paint circlePaint;
    private Paint backgroundPaint;


    public DrawingView(Context context) {

        super(context);
    }


    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        circlePaint = new Paint();
        backgroundPaint = new Paint();

        Resources resources = getResources();
        int circleColor = resources.getColor(R.color.black);
        int backgroundColor = resources.getColor(R.color.white);

        circlePaint.setColor(circleColor);
        backgroundPaint.setColor(backgroundColor);

    }




    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(backgroundPaint); //заполняем фон кругами
        for(Circle circle: circles){
            float cx = Math.min(circle.getStartPoint().x, circle.getEndPoint().x);
            float cy = Math.max(circle.getStartPoint().y, circle.getEndPoint().y);
            float radius;
                if(cx > cy){
                radius = cy/4;
            } else{
                radius = cx/4;
            }



            canvas.drawCircle(cx, cy, radius, circlePaint);

        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());


        switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        currentCircle = new Circle(current);
                        circles.add(currentCircle);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(currentCircle != null){
                            currentCircle.setEndPoint(current);
                            invalidate();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        currentCircle = null;
                        break;

                }
                return true;
    }

}
